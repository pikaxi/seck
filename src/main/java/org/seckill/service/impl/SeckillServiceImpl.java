package org.seckill.service.impl;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

public class SeckillServiceImpl implements SeckillService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private SeckillDao seckillDao;

    private SuccessKilledDao successKilledDao;

    //MD5盐值字符串，用于混淆MD5
    private final String slat="jjhdqwe09823rvvdsajl$%^*();112323aaPSIOIK";

    @Override
    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0,4);
    }

    @Override
    public Seckill getById(long seckId) {
        return seckillDao.queryById(seckId);
    }

    private String getMD5(long seckId){
        String base = seckId+"/"+slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Override
    public Exposer exportSeckillUrl(long seckId) {
        Seckill seckill= this.getById(seckId);
        if(seckill==null){
            return new Exposer(false,seckId);
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();
        if(nowTime.getTime()>endTime.getTime()||nowTime.getTime()<startTime.getTime()){
            return new Exposer(false,nowTime.getTime(),startTime.getTime(),endTime.getTime());
        }
        String md5=getMD5(seckId);//TODO
        return new Exposer(true,md5,seckId);
    }

    @Override
    public SeckillExecution executeSeckill(long seckId, long userPhone, String md5) throws SeckillException, RepeatKillException, SeckillCloseException {
        if(md5==null ||!md5.equals(getMD5(seckId))){
            throw  new SeckillException("SECKILL Data Rewrite:秒杀数据重写");
        }
        //执行秒杀逻辑 减库存+记录购买行为
        Date nowTime = new Date();

        //减库存
        try {
            int updateCount = this.seckillDao.reduceNumber(seckId,nowTime);
            if(updateCount<=0){
                //没有更新到记录，秒杀结束
                throw new SeckillCloseException("seckill is closed:秒杀已结束");
            }else{
                //记录购买行为
                int insertCount = this.successKilledDao.insertSuccessKilled(seckId,userPhone);
                if(insertCount<=0){
                    //说明重复秒杀
                    throw new RepeatKillException("seckill repeat:重复秒杀");
                }else{
                    SuccessKilled successKilled= this.successKilledDao.queryByIdWithSeckill(seckId,userPhone);
                    if(successKilled!=null){
                        return new SeckillExecution(seckId,1,"秒杀成功",successKilled);
                    }
                }
            }
        }catch(SeckillCloseException e1){
            throw e1;
        }catch (RepeatKillException e2){
            throw e2;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            //编译期异常转化为运行期异常
            throw new SeckillException("seckill inner error :"+e.getMessage());
        }
        return null;
    }
}
