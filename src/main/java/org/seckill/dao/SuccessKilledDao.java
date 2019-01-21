package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {
    /**
     * 插入购买明细，可过滤重复
     * @param seckId
     * @param userNumber
     * @return
     */
    int insertSuccessKilled(@Param("seckId") long seckId ,@Param("userNumber") long userNumber);

    /**
     * 根据ID查询SuccessKilled并携带产品对象实体
     * @param seckId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckId") long seckId ,@Param("userNumber") long userNumber);
}
