package com.rockydang.service.springdemo.common.enums.example1;

/**
 * Created by yanxiao on 16/4/24.
 */
public class WeightTable {

    public static void main(String[] args) {

        String weight = "10";
        double earthWeight = Double.parseDouble(weight);
        double mass = earthWeight / Planet.EARTH.surfaceGravity();

        for (Planet p : Planet.values()) {
            System.out.printf("Weight on %s is %f%n", p, p.surfaceWeight(mass));
        }
    }
}
