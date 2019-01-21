package org.seckill.dto;

import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStateEnum;

/**
 * ��װ��ɱִ�к���
 */
public class SeckillExecution {
    private long seckId;
    private int state;//��ɱ���ִ��״̬
    private String stateInfo;//��ɱ�����ʾ
    private SuccessKilled successKilled;//��ɱ�ɹ�����
    //�ɹ�����µĹ���
    public SeckillExecution(long seckId, SeckillStateEnum stateEnum, SuccessKilled successKilled) {
        this.seckId = seckId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.successKilled = successKilled;
    }
    //��ɱʧ������µĹ���
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
