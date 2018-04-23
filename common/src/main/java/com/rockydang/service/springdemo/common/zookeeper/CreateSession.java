package com.rockydang.service.springdemo.common.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by yanxiao on 2018/4/20.
 */
public class CreateSession implements Watcher {
    private static ZooKeeper zookeeper;

    public static void main(String[] args) throws IOException, InterruptedException {
        zookeeper = new ZooKeeper("localhost:2181", 5000, new CreateSession());
        System.out.println(zookeeper.getState());
        Thread.sleep(Integer.MAX_VALUE);
    }

    private void doSomething() {

        System.out.println("do something");
    }

    @Override
    public void process(WatchedEvent event) {

        System.out.println("收到事件：" + event);
        if (event.getState() == Event.KeeperState.SyncConnected) {
            if (event.getType() == Event.EventType.None && null == event.getPath()) {
                doSomething();
            }
        }
    }

}