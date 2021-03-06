package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

public interface SeckillDao {
    /**reduceNumber
     * 减库存
     * @param seckId
     * @param killTime
     * @return 插入的行数
     */
    int reduceNumber(@Param("seckId")long seckId ,@Param("killTime") Date killTime);

    /**
     * 根据商品ID获取库存信息
     * @param seckId
     * @return
     */
    Seckill queryById(long seckId);

    /**
     * 根据偏移量查询商品库存信息列表
     * @param offset 当前数
     * @param limit 限制行
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset , @Param("limit") int limit);


}
