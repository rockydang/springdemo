package com.rockydang.service.springdemo.common.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @param <E>
 */
public class Stack<E> {
    //    private E[] elements;
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
//        elements = new E[DEFAULT_INITIAL_CAPACITY];
//        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
        elements = (Object[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {

        @SuppressWarnings("unchecked")
        E result = (E) elements[--size];

        return result;
    }

    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }

    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

        Stack<Number> numberStack = new Stack<Number>();
        Iterable<Integer> i = new ArrayList<Integer>();
        numberStack.pushAll(i);

        Collection<Object> objects = new ArrayList<Object>();
        numberStack.popAll(objects);

    }
}
