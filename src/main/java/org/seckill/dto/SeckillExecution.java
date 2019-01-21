package org.seckill.dto;

import org.seckill.entity.SuccessKilled;

/**
 * 封装秒杀执行后结果
 */
public class SeckillExecution {
    private long seckId;
    private int state;//秒杀结果执行状态
    private String stateInfo;//秒杀结果表示
    private SuccessKilled successKilled;//秒杀成功对象
    //成功情况下的构造
    public SeckillExecution(long seckId, int state, String stateInfo, SuccessKilled successKilled) {
        this.seckId = seckId;
        this.state = state;
        this.stateInfo = stateInfo;
        this.successKilled = successKilled;
    }
    //秒杀失败情况下的构造
    public SeckillExecution(long seckId, int state, String stateInfo) {
        this.seckId = seckId;
        this.state = state;
        this.stateInfo = stateInfo;
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
}
