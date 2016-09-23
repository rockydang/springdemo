package com.rockydang.service.springdemo.common.cache.guava;


import java.util.Objects;

/**
 * 文章商品列表键。
 * <p>
 * 键的组成部分：业务方 Key、商品查询条件
 */
public class TestListKey {

    /**
     * 业务方 Key
     */
    public final String bizKey;

    /**
     * 商品查询
     */
    public final TestQuery testQuery;

    public TestListKey(String bizKey, TestQuery testQuery) {
        this.bizKey = bizKey;
        this.testQuery = testQuery;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TestListKey) {
            TestListKey other = (TestListKey) obj;
            return Objects.equals(bizKey, other.bizKey)
                    && Objects.equals(testQuery, other.testQuery);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bizKey, testQuery);
    }

    @Override
    public String toString() {
        return "TestListKey{" +
                "bizKey='" + bizKey + '\'' +
                ", topicItemInfoQuery=" + testQuery +
                '}';
    }

}