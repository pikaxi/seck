package org.seckill.enums;

/**
 * 秒杀状态枚举表
 */
public enum SeckillStateEnum {
    SUCCESS(1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ERROR(-2,"系统异常"),
    DATA_REWRITE(-3,"数据篡改")
    ;
    private int state;

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    private String stateInfo;

    SeckillStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }
    public static SeckillStateEnum stateOf(int index){
        for(SeckillStateEnum s:values()){
            if(s.getState()==index){
                return s;
            }
        }
        return null;
    }
}
