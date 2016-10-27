package com.rockydang.service.springdemo.service.springevent;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Service;

/**
 * Created by yanxiao on 2016/10/23.
 */
@Service
public class SubTaskFinishListener implements ApplicationListener {

    public SubTaskFinishListener() {
        System.out.println("init SubTaskFinishListener...");
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        // TODO Auto-generated method stub
        if (event instanceof SubTaskFinishEvent) {
            SubTaskFinishEvent subTaskFinishEvent = (SubTaskFinishEvent) event;
            //do something
            System.out.println("subTaskFinshEvent==" + subTaskFinishEvent.getTestEventDO());
        } else if (event instanceof ContextClosedEvent) {
            System.out.println("context.close..");
        } else if (event instanceof ContextRefreshedEvent) {
            System.out.println("context.refresh...");
        } else if (event instanceof ContextStartedEvent) {
            System.out.println("context start listener..");
        } else if (event instanceof ContextStoppedEvent) {
            System.out.println("ContextStoppedEvent.close..");

        }
    }
}
