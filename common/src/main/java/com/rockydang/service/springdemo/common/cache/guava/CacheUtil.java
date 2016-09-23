package com.rockydang.service.springdemo.common.cache.guava;

import java.util.concurrent.TimeUnit;

/**
 * 缓存相关的工具类
 *
 * @author 延霄
 * @since 1.0
 */
public abstract class CacheUtil {

    /**
     * 本地缓存配置。
     */
    public enum LocalCacheConfig {

        /**
         * 所有展示的商品列表，键组成：业务方 key + 类目类型
         */
        ALL_ARTICLE_ITEM_LIST(
                "ArticleService", // 服务名
                100, // 缓存最大条目数量
                180, TimeUnit.SECONDS, // 3分钟取一次价格
                1, TimeUnit.DAYS // 写入过期时间
        ),;

        /**
         * 使用方的服务名称，用于区分日志
         */
        private final String serviceName;
        /**
         * 缓存最大条目数量
         */
        private final long maximumSize;
        /**
         * 刷新间隔时间
         */
        private final long refreshAfterWrite;
        /**
         * 刷新间隔时间单位
         */
        private final TimeUnit refreshAfterWriteTimeUnit;
        /**
         * 距离最近一次写入的过期时间
         */
        private final long expireAfterWrite;
        /**
         * 距离最近一次写入的过期时间单位
         */
        private final TimeUnit expireAfterWriteTimeUnit;

        LocalCacheConfig(
                String serviceName,
                long maximumSize,
                long refreshAfterWrite, TimeUnit refreshAfterWriteTimeUnit,
                long expireAfterWrite, TimeUnit expireAfterWriteTimeUnit) {
            this.serviceName = serviceName;
            this.maximumSize = maximumSize;
            this.refreshAfterWrite = refreshAfterWrite;
            this.refreshAfterWriteTimeUnit = refreshAfterWriteTimeUnit;
            this.expireAfterWrite = expireAfterWrite;
            this.expireAfterWriteTimeUnit = expireAfterWriteTimeUnit;
        }

        public String serviceName() {
            return serviceName;
        }

        public long maximumSize() {
            return maximumSize;
        }

        public long refreshAfterWrite() {
            return refreshAfterWrite;
        }

        public TimeUnit refreshAfterWriteTimeUnit() {
            return refreshAfterWriteTimeUnit;
        }

        public long expireAfterWrite() {
            return expireAfterWrite;
        }

        public TimeUnit expireAfterWriteTimeUnit() {
            return expireAfterWriteTimeUnit;
        }

        @Override
        public String toString() {
            return "LocalCacheConfig{" +
                    name() + '(' +
                    "serviceName='" + serviceName + '\'' +
                    ", maximumSize=" + maximumSize +
                    ", refreshAfterWrite=" + refreshAfterWrite +
                    ", refreshAfterWriteTimeUnit=" + refreshAfterWriteTimeUnit +
                    ", expireAfterWrite=" + expireAfterWrite +
                    ", expireAfterWriteTimeUnit=" + expireAfterWriteTimeUnit +
                    ')' +
                    '}';
        }
    }

}
