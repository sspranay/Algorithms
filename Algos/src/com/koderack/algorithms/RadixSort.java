package com.koderack.algorithms;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.LinkedList;
import java.util.Queue;


/**
 *
 * @author pranay
 */
public class RadixSort {

    public int[] sort(int[] arr, int digits) {
        Queue<Integer>[] buckets = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (int digit = 1; digit <= digits; digit++) {
            int modulo = (int) Math.pow(10, digit);
            int divisor = modulo / 10;

            for (int j = 0; j < arr.length; j++) {
                int index = (arr[j] % (modulo)) / divisor;
                buckets[index].add(arr[j]);
            }
            int index = 0;
            for (Queue<Integer> bucket : buckets) {
                while (!bucket.isEmpty()) {
                    arr[index++] = bucket.remove();
                }
            }
        }
        return arr;
    }
}
class DemoRadixSort {

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        int A[] = {2, 2345, 4, 102, 97, 0, 10, 111};
        int digits = 3; // hard coded
        System.out.println("Before sorting...");
        for (int a : A) {
            System.out.print(a + " ");
        }

        A = radixSort.sort(A, 3);

        System.out.println("\n After sorting...");
        for (int a : A) {
            System.out.print(a + " ");
        }
    }
}