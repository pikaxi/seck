package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService service;
    @Test
    public void getSeckillList() {
        List<Seckill> lists = service.getSeckillList();
        logger.info("list={}",lists);
    }

    @Test
    public void getById() {
        long id=1000L;
        Seckill seckill = service.getById(id);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void exportSeckillUrl() {
        /*
         exposer=Exposer{
         exposed=true,
          md5='89fd61f7e398ceaa8e1d0b8506a78d61',
           seckId=1000,
           now=0,
           start=0,
           end=0}

         */
        long id=1000L;
        Exposer exposer = service.exportSeckillUrl(id);
        if(exposer.isExposed()){
            logger.info("exposer={}",exposer);
            long phone=12236361529L;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution execution = service.executeSeckill(id,phone,md5);
                logger.info("result={}",execution);
            }catch(RepeatKillException e1){
                logger.error(e1.getMessage(),e1);
            }catch(SeckillCloseException e2){
                logger.error(e2.getMessage(),e2);
            }
        }else {
            logger.warn("exposer={}",exposer);
        }

    }

    @Test
    public void executeSeckill() {
        /*long id=1000L;
        String md5="89fd61f7e398ceaa8e1d0b8506a78d61";
        long phone=12236361517L;
        SeckillExecution execution =service.executeSeckill(id,phone,md5);
        logger.info("result={}",execution);*/
    }
}