package com.rockydang.service.springdemo.common.util.arith;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * Created by yanxiao on 2018/4/24.
 */
public class Arithmetic {

    public static void main(String[] args) {
//        String str = "12 + 3 * (2 + 5) - 44 / (12 - 8) + 4 * ( 12 + 2 * (4 + 16) + 3)";

        /*StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 10000; i++) {
            String str = "12*(3*1)+" + i;
            double result = new Arithmetic().computeWithStack(str);
        }
        stopWatch.stop();
        System.out.println("Arithmetic cost:" + stopWatch.getTime() + "ms.");*/

        String str = "5/3";
        double result = new Arithmetic().computeWithStack(str);

        System.out.println(result);
    }

    public double computeWithStack(String computeExpr) {
        StringTokenizer tokenizer = new StringTokenizer(computeExpr, "+-*/()", true);
        Stack<Double> numStack = new Stack<Double>();
        Stack<Operator> operatorStack = new Stack<Operator>();
        Map<String, Operator> operatorMap = getOperatorMap();
        String current;
        while (tokenizer.hasMoreTokens()) {
            current = tokenizer.nextToken().trim();
            if (current == null || current.length() == 0) {
                continue;
            }

            if (this.isNum(current)) {
                numStack.push(Double.valueOf(current));
                continue;
            }

            Operator operator = operatorMap.get(current);
            if (operator != null) {
                while (!operatorStack.empty() && operatorStack.peek().priority() >= operator.priority()) {
                    compute(numStack, operatorStack);
                }

                operatorStack.push(operator);
            } else {
                if ("(".equals(current)) {
                    operatorStack.push(Operator.BRACKETS);
                } else {
                    while (!operatorStack.peek().equals(Operator.BRACKETS)) {
                        compute(numStack, operatorStack);
                    }
                    operatorStack.pop();
                }
            }
        }

        while (!operatorStack.empty()) {
            compute(numStack, operatorStack);
        }

        return numStack.pop();
    }

    private boolean isNum(String str) {
        String numRegex = "^\\d+(\\.\\d+)?$";
        return Pattern.matches(numRegex, str);
    }

    private Map<String, Operator> getOperatorMap() {
        Map<String, Operator> map = new HashMap<>();
        map.put("+", Operator.PLUS);
        map.put("-", Operator.MINUS);
        map.put("*", Operator.MULTIPLY);
        map.put("/", Operator.DIVIDE);
        return map;
    }

    private void compute(Stack<Double> numStack, Stack<Operator> operStack) {
        Double num2 = numStack.pop();
        Double num1 = numStack.pop();
        Double result = operStack.pop().compute(num1, num2);
        numStack.push(result);
    }
}
