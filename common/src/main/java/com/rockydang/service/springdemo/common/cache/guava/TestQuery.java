package com.rockydang.service.springdemo.common.cache.guava;


/**
 * 文章商品列表键。
 * <p>
 * 键的组成部分：业务方 Key、商品查询条件
 */
public class TestQuery {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestQuery{" +
                "name='" + name + '\'' +
                '}';
    }
}