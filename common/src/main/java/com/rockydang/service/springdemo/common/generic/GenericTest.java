package com.rockydang.service.springdemo.common.generic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class GenericTest {

    public static void main(String[] args){

        //example1...
        List<String> strings = new ArrayList<String>();
        unsafeAdd(strings,new Integer("1"));
        System.out.println(strings.get(0));

        //example2...
       /* List<String> strings = new ArrayList<String>();
        unsafeAdd(strings,new Integer("1"));
        System.out.println(strings.get(0));*/



        Set<String> set1 = new HashSet<String>();
        set1.add("2");

        Set<Integer> set2 = new HashSet<Integer>();
        set2.add(2);
        set2.add(3);


        System.out.println(numElementsInCommon(set1, set2));

        @SuppressWarnings("unchecked") List list = new ArrayList();
        list.add("123s");

/*
        @SuppressWarnings("unchecked") String aa = (String)list.get(0);
        System.out.println(aa);*///

    }


    @SuppressWarnings("unchecked")
    private static void unsafeAdd(List list ,Object object){
        list.add(object);
    }

    static int numElementsInCommon(Set<?> s1,Set<?>s2){
        int result = 0;
        for(Object o1:s1)
            if(s2.contains(o1))
                result++;
        return result;
    }

    static <E> E reduce(List<? extends E> list,Function<E>f,E initVal){
        List<E> snapshot ;
        synchronized (list){
            snapshot = new ArrayList<E>(list);
        }
        E result = initVal;

        for (E e:snapshot)
            result = f.apply(result,e);
        return result;
    }

    interface  Function<T>{
        T apply(T arg1,T arg2);
    }


}
