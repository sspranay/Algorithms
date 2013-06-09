package com.koderack.algorithms;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *  Unfinished 
 * source
 * http://analgorithmaday.blogspot.com/2011/05/randomized-selection-algorithm.html
 * @author pranay
 */
public class SelectAlgorithm {
    
    public int select(int A[], int start, int end, int k){
        if(start == end)
            return A[start];
        if(start > end)
            return -1;
        
        int pivotIndex = random_partition(A, start, end);
        
        if(k < pivotIndex){
            end = pivotIndex - 1;
            return select(A, start, end, k);
        }
        else if( k > pivotIndex){
            start = pivotIndex + 1;
            k = k - pivotIndex;
            return select(A, start, end, k);
        }
        else // k == pivotIndex
            return A[pivotIndex];
    }
    
    public int random_partition(int A[], int start, int end){
        int pivotIndex = (int)(Math.random()*10);
        return pivotIndex;
    }
}
class DemoSelect {
    public static void main(String[] args){
        int[] A = {5,4,7,2,8,6,1};
        int k = 3;
        int start = 0;
        
        SelectAlgorithm select = new SelectAlgorithm();
        System.out.println(select.random_partition(A, start, k));
        
    }
}