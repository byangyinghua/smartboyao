package com.guinong.lib_base.event;

import org.greenrobot.eventbus.EventBus;

/**
 * @author wangyu
 * @time 2017/5/2 11:29
 * @desc 
 */
public class EventBusInstance {

    private EventBusInstance(){}

    private static EventBusInstance mEventBusInstance;

    public static  EventBusInstance getInstance(){
        if (mEventBusInstance==null){
            mEventBusInstance = new EventBusInstance();
        }
        return mEventBusInstance;
    }

    public void  registerEvent(Object t){
        if(!EventBus.getDefault().isRegistered(t)){
            EventBus.getDefault().register(t);
        }
    }


    public void  unRegisterEvent(Object t){
        if(EventBus.getDefault().isRegistered(t)){
            EventBus.getDefault().unregister(t);
        }
    }
    public void post(Object t){
        EventBus.getDefault().post(t);
    }

}
