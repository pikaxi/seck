package org.seckill.dto;

import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStateEnum;

/**
 * 封装秒杀执行后结果
 */
public class SeckillExecution {
    private long seckId;
    private int state;//秒杀结果执行状态
    private String stateInfo;//秒杀结果表示
    private SuccessKilled successKilled;//秒杀成功对象
    //成功情况下的构造
    public SeckillExecution(long seckId, SeckillStateEnum stateEnum, SuccessKilled successKilled) {
        this.seckId = seckId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.successKilled = successKilled;
    }
    //秒杀失败情况下的构造
    public SeckillExecution(long seckId, SeckillStateEnum stateEnum) {
        this.seckId = seckId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public long getSeckId() {
        return seckId;
    }

    public void setSeckId(long seckId) {
        this.seckId = seckId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }

    @Override
    public String toString() {
        return "SeckillExecution{" +
                "seckId=" + seckId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", successKilled=" + successKilled +
                '}';
    }
}
