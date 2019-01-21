package org.seckill.dao;

import org.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {
    /**
     * 插入购买明细，可过滤重复
     * @param seckId
     * @param userNumber
     * @return
     */
    int insertSuccessKilled(long seckId , long userNumber);

    /**
     * 根据ID查询SuccessKilled并携带产品对象实体
     * @param seckId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(long seckId);
}
