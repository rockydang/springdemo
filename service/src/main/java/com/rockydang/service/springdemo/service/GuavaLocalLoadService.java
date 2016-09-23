package com.rockydang.service.springdemo.service;

import com.rockydang.service.springdemo.common.cache.guava.TestListKey;

/**
 * Created by yanxiao on 16/4/12.
 */
public interface GuavaLocalLoadService {

    String queryContentFromLocalCache(TestListKey key);

    String testScope();
}
