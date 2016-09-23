package com.rockydang.service.springdemo.service.impl;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.rockydang.service.springdemo.common.cache.guava.CacheUtil;
import com.rockydang.service.springdemo.common.cache.guava.LocalCaches;
import com.rockydang.service.springdemo.common.cache.guava.TestListKey;
import com.rockydang.service.springdemo.common.cache.guava.TestQuery;
import com.rockydang.service.springdemo.service.GuavaLocalLoadService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service(value = "guavaLocalLoadService")
public class GuavaLocalLoadServiceImpl implements GuavaLocalLoadService, InitializingBean {

    private static LoadingCache<TestListKey, String> loadingCache;


    @Override
    public String testScope() {
        System.out.println("scope....");
        return "scope...";
    }

    @Override
    public String queryContentFromLocalCache(TestListKey key) {
        System.out.println("queryContentFromLocalCache start..." + key);
        String result = "";
        try {
            result = loadingCache.get(key);
        } catch (Exception e) {
            System.out.printf("queryContentFromLocalCache.error..." + e.getLocalizedMessage(), e);
        }
        return result;
    }

    public String queryContentFromDB(TestQuery testQuery) {
        System.out.println("queryContentFromDB start..." + testQuery);
        return "db=" + testQuery;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet...");
        if (loadingCache == null) {
            final CacheLoader<TestListKey, String> cacheLoader;
            cacheLoader = new CacheLoader<TestListKey, String>() {

                @Override
                public String load(TestListKey key) {
                    return GuavaLocalLoadServiceImpl.this.queryContentFromDB(key.testQuery);
                }

                @Override
                public ListenableFuture<String> reload(
                        final TestListKey key, final String oldValue) {
                    String newValue = GuavaLocalLoadServiceImpl.this.queryContentFromDB(key.testQuery);
                    if (newValue == null) {
                        return Futures.immediateFuture(oldValue); // 请求新的数据失败，则返回旧的值
                    }
                    return Futures.immediateFuture(newValue);
                }
            };

            loadingCache = LocalCaches.newLoadingCache(
                    CacheUtil.LocalCacheConfig.ALL_ARTICLE_ITEM_LIST,
                    cacheLoader);
        }

    }
}
