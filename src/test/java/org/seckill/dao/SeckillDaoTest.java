package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    @Resource
    private SeckillDao seckillDao;
    @Test
    public void queryById() {
        long id=1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void queryAll() {
        /*
        java不保存形参的记录*（offset,limit）->>(arg0,arg1)
        可使用注解@Param()
         */
       List<Seckill> lists= seckillDao.queryAll(0,100);
        for(Seckill lis:lists){
            System.out.println(lis);
        }
    }

    @Test
    public void reduceNumber() {

        int updateCount=seckillDao.reduceNumber(1000L,new Date());
        System.out.println(updateCount);
    }
}