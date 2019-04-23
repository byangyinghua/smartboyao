package com.guinong.lib_base.event;

import java.io.Serializable;

/**
 * @author wangyu
 * @time 2017/5/5 11:29
 * @desc baseEvent
 */
public class BaseEvent implements Serializable {
    protected String mMsg;
    protected int mCode;

    public BaseEvent(String msg){
        mMsg = msg;
    }

    public String getMsg(){
        return mMsg;
    }

    public BaseEvent(){};

    public void setmMsg(String mMsg) {
        this.mMsg = mMsg;
    }

    public int getmCode() {
        return mCode;
    }

    public void setmCode(int mCode) {
        this.mCode = mCode;
    }
}
