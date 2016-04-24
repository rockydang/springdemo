package com.rockydang.service.springdemo.common.enums.example4;

/**
 * Created by yanxiao on 16/4/24.
 *
 * 不推荐使用 oridinal()方法。。。
 */
public enum Ensemble {
    SOLO, DUEL, TRIO;

    public int numberOfMusicians() {
        return ordinal() + 1;
    }

    public static void main(String[] args) {
        System.out.println("aa=" + Ensemble.DUEL.numberOfMusicians());
    }
}
