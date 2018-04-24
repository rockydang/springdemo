package com.rockydang.service.springdemo.common.util.arith;

/**
 * Created by yanxiao on 2018/4/24.
 */
public enum Operator {
    PLUS {
        @Override
        public int priority() {
            return 1;
        }

        @Override
        public double compute(double num1, double num2) {
            return num1 + num2;
        }
    },

    MINUS {
        @Override
        public int priority() {
            return 1;
        }

        @Override
        public double compute(double num1, double num2) {
            return num1 - num2;
        }
    },

    MULTIPLY {
        @Override
        public int priority() {
            return 2;
        }

        @Override
        public double compute(double num1, double num2) {
            return num1 * num2;
        }
    },

    DIVIDE {
        @Override
        public int priority() {
            return 2;
        }

        @Override
        public double compute(double num1, double num2) {
            return num1 / num2;
        }
    },

    BRACKETS {
        @Override
        public int priority() {
            return 0;
        }

        @Override
        public double compute(double num1, double num2) {
            return 0;
        }
    };

    public abstract int priority();

    public abstract double compute(double num1, double num2);
}
