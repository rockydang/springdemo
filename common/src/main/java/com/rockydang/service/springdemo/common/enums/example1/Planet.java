package com.rockydang.service.springdemo.common.enums.example1;

/**
 * Created by yanxiao on 16/4/24.
 */
public enum Planet {
    MERCUR(3.02e+23, 3.439e6),

    VENUS(4.02e+23, 3.439e6),

    EARTH(5.02e+23, 3.439e6),

    MARS(6.02e+23, 3.439e6),

    JUPITER(7.02e+23, 3.439e6),

    SATURN(8.02e+23, 3.439e6),

    URANUS(9.02e+23, 3.439e6),

    NEPTUNE(2.33e+23, 3.439e6);

    private final double mass;//in kilograms
    private final double radius;//In meters
    private final double surfaceGravity;//In m/s^2
    private static final double G = 6.67300E-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass() {
        return mass;
    }

    public double radius() {
        return radius;
    }

    public double surfaceGravity() {
        return surfaceGravity;
    }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity; //F=ma
    }

}
