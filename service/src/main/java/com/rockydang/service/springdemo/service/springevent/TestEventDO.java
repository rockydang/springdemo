package com.rockydang.service.springdemo.service.springevent;

/**
 * Created by yanxiao on 2016/10/23.
 */
public class TestEventDO {

    String id;
    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestEventDO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
