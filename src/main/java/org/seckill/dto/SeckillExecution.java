package org.seckill.dto;

import org.seckill.entity.SuccessKilled;

/**
 * ��װ��ɱִ�к���
 */
public class SeckillExecution {
    private long seckId;
    private int state;//��ɱ���ִ��״̬
    private String stateInfo;//��ɱ�����ʾ
    private SuccessKilled successKilled;//��ɱ�ɹ�����
    //�ɹ�����µĹ���
    public SeckillExecution(long seckId, int state, String stateInfo, SuccessKilled successKilled) {
        this.seckId = seckId;
        this.state = state;
        this.stateInfo = stateInfo;
        this.successKilled = successKilled;
    }
    //��ɱʧ������µĹ���
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
