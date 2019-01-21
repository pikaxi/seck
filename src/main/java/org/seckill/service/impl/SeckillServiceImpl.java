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

    //MD5��ֵ�ַ��������ڻ���MD5
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
            throw  new SeckillException("SECKILL Data Rewrite:��ɱ������д");
        }
        //ִ����ɱ�߼� �����+��¼������Ϊ
        Date nowTime = new Date();

        //�����
        try {
            int updateCount = this.seckillDao.reduceNumber(seckId,nowTime);
            if(updateCount<=0){
                //û�и��µ���¼����ɱ����
                throw new SeckillCloseException("seckill is closed:��ɱ�ѽ���");
            }else{
                //��¼������Ϊ
                int insertCount = this.successKilledDao.insertSuccessKilled(seckId,userPhone);
                if(insertCount<=0){
                    //˵���ظ���ɱ
                    throw new RepeatKillException("seckill repeat:�ظ���ɱ");
                }else{
                    SuccessKilled successKilled= this.successKilledDao.queryByIdWithSeckill(seckId,userPhone);
                    if(successKilled!=null){
                        return new SeckillExecution(seckId,1,"��ɱ�ɹ�",successKilled);
                    }
                }
            }
        }catch(SeckillCloseException e1){
            throw e1;
        }catch (RepeatKillException e2){
            throw e2;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            //�������쳣ת��Ϊ�������쳣
            throw new SeckillException("seckill inner error :"+e.getMessage());
        }
        return null;
    }
}
