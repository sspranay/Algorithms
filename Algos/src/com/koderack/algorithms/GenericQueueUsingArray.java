package com.koderack.algorithms;


import java.lang.reflect.Array;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pranay
 */
public class GenericQueueUsingArray<T> {

    private T[] queue;
    private int currentSize;
    private final int MAX_SIZE = 10;

    public GenericQueueUsingArray(Class<T> c) {
        queue = (T[]) Array.newInstance(c, MAX_SIZE);
        currentSize = 0;
    }

    public boolean add(T e) {
        if (currentSize < MAX_SIZE) {
            queue[currentSize++] = e;
            return true;
        } else {
            throw new UnsupportedOperationException("Queue size maxed out");
        }
    }

    public T remove() {
        if (currentSize > 0) {
            T temp = queue[0];
            for (int i = 1; i < currentSize; i++) {
                queue[i - 1] = queue[i];
            }
            currentSize--;
            return temp;
        } else {
            throw new UnsupportedOperationException("Queue is already empty, can't dequeue further");
        }

    }
}
class DemoGenericQueueUsingArray {

    public static void main(String[] args) {
        GenericQueueUsingArray<Student> studentQ = new GenericQueueUsingArray<>(Student.class);
        studentQ.add(new Student("Pramod", 1));
        studentQ.add(new Student("Zulu", 2));
        try {
            System.out.println(studentQ.remove().toString());
            System.out.println(studentQ.remove().toString());
            System.out.println(studentQ.remove().toString());
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}