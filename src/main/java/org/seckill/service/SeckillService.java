package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * 业务接口：秒杀业务
 * @Date 2019.01.21
 */
public interface SeckillService {
    /**
     * 查询所有秒杀的商品
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀商品
     * @param seckId
     * @return
     */
    Seckill getById(long seckId);

    /**
     * 秒杀开启时，输出秒杀接口的地址
     * 否则输出系统时间和秒杀时间
     * @param seckId
     */
    Exposer exportSeckillUrl(long seckId);

    /**
     * 执行秒杀操作
     * @param seckId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckId, long userPhone, String md5)
        throws SeckillException,RepeatKillException,SeckillCloseException;
}
