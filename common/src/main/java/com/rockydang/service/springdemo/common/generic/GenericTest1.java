package com.rockydang.service.springdemo.common.generic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * TEST
 *
 * @author YANXIAO
 * @since 1.0
 */
public class GenericTest1 {

    public static Set union(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    public static <E> Set<E> union1(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<Integer>();
        s1.add(1);
        Set<Integer> s2 = new HashSet<Integer>();
        s2.add(2);

        Set<Number> snumber = GenericTest1.<Number>union1(s1, s2);

        System.out.println("snumber==" + snumber);

    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<K, V>();
    }

    public void testHashMap() {
        Map<String, List<String>> args = new HashMap();
    }


    public static <T extends Comparable<? super T>> T max(List<? extends T> list) {
        Iterator<? extends T> i = list.iterator();
        T result = i.next();

        while (i.hasNext()) {
            T t = i.next();

            if (t.compareTo(result) > 0) {
                result = t;
            }
        }
        return result;
    }


    public static void swap(List<?> list, int i, int j) {
        //error...
        //list.set(i,list.set(j,list.get(i)));
        swapHelper(list, i, j);
    }

    public static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));

    }
}
