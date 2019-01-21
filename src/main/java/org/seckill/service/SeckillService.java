package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * ҵ��ӿڣ���ɱҵ��
 * @Date 2019.01.21
 */
public interface SeckillService {
    /**
     * ��ѯ������ɱ����Ʒ
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * ��ѯ������ɱ��Ʒ
     * @param seckId
     * @return
     */
    Seckill getById(long seckId);

    /**
     * ��ɱ����ʱ�������ɱ�ӿڵĵ�ַ
     * �������ϵͳʱ�����ɱʱ��
     * @param seckId
     */
    Exposer exportSeckillUrl(long seckId);

    /**
     * ִ����ɱ����
     * @param seckId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckId, long userPhone, String md5)
        throws SeckillException,RepeatKillException,SeckillCloseException;
}
