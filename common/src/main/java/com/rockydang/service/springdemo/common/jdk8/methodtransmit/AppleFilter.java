package com.rockydang.service.springdemo.common.jdk8.methodtransmit;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanxiao on 2017/2/15.
 */
public class AppleFilter {

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavent(Apple apple) {
        return 150 < apple.getWeight();
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();

        Apple apple = new Apple();
        apple.setColor("green");
        apple.setWeight(110);
        apples.add(apple);

        apple = new Apple();
        apple.setColor("red");
        apple.setWeight(110);
        apples.add(apple);

        apple = new Apple();
        apple.setColor("red");
        apple.setWeight(160);
        apples.add(apple);

        apple = new Apple();
        apple.setColor("green");
        apple.setWeight(170);
        apples.add(apple);

//        filterApples(apples, A);
//        filterApples(apples,(Apple) a -> "green".equals(""));
    }

}

interface Predicate<T> {
    boolean test(T t);
}

@Data
class Apple {
    private String color;
    private int weight;
}
