package com.rockydang.service.springdemo.common.callback.example3;

public class Student
{
    private String name = null;

    public Student(String name)
    {
        // TODO Auto-generated constructor stub
        this.name = name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public class doHomeWork implements DoJob
    {

        @Override
        public void fillBlank(int a, int b, int result)
        {
            // TODO Auto-generated method stub
            System.out.println(name + "求助小红计算:" + a + " + " + b + " = " + result);
        }

    }

    public void callHelp (int a, int b)
    {
        new SuperCalculator().add(a, b, new doHomeWork());
    }
}