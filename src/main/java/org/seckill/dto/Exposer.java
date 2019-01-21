package org.seckill.dto;

/**
 * ��¶��ɱ��ַdto
 */
public class Exposer {
    //�Ƿ�ɿ���
    private boolean exposed;
    private String md5;//һ�ּ��ܴ�ʩ
    private long seckId;
    private long now;//ϵͳ��ǰʱ��(ms)
    private long start;
    private long end;

    public Exposer(boolean exposed, String md5, long seckId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.seckId = seckId;
    }

    public Exposer(boolean exposed,long now, long start, long end) {
        this.exposed = exposed;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean exposed, long seckId) {
        this.exposed = exposed;
        this.seckId = seckId;
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getSeckId() {
        return seckId;
    }

    public void setSeckId(long seckId) {
        this.seckId = seckId;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }
}
