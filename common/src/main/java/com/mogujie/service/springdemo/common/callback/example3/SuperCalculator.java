package com.mogujie.service.springdemo.common.callback.example3;

public class SuperCalculator
{
    public void add(int a, int b, DoJob  customer)
    {
        int result = a + b;
        customer.fillBlank(a, b, result);
    }
}