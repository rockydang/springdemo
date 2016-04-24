package com.rockydang.service.springdemo.common.enums.example4;

/**
 * Created by yanxiao on 16/4/24.
 */
public enum Ensemble2 {
    SOLO(1), DUEL(2), TRIO(3);

    private final int numberOfMusicians;

    Ensemble2(int size) {
        this.numberOfMusicians = size;
    }

    public int numberOfMusicians(){
        return numberOfMusicians;
    }

    public static void main(String[] args) {
        System.out.println("aa=" + Ensemble2.DUEL.numberOfMusicians());
    }
}
