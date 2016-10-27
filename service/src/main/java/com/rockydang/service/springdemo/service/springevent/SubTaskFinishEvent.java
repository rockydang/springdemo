package com.rockydang.service.springdemo.service.springevent;

import org.springframework.context.ApplicationEvent;

/**
 * Created by yanxiao on 2016/10/23.
 */
public class SubTaskFinishEvent extends ApplicationEvent {

    private TestEventDO testEventDO;

    public SubTaskFinishEvent(TestEventDO testEventDO) {
        super(testEventDO);
        this.testEventDO = testEventDO;
    }

    public TestEventDO getTestEventDO() {
        return testEventDO;
    }
}
