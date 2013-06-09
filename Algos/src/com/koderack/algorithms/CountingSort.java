package com.koderack.algorithms;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author pranay
 */
public class CountingSort {
    
    /** Sort 'n' elements array with 'k' being distinct
     * Assumes A.length == n
     */
    public void sort(int A[], int n, int k){
        int B[] = new int[n];
        int C[] = new int[k + 1]; // to avoid jumping index n, C[0] never used?YES
        
        // first fill C with elements count
        for(int i=0; i<n; i++){
            C[A[i]] += 1;
        }
        System.out.println("Count of elements");
        for(int x: C)
            System.out.print( " : " + x);
        
      // increment the counts... current Y can say :X elements less than me!
        for(int j=1; j<=k; j++){
            C[j] += C[j-1];
        }
     
        System.out.println("\n Incremental Count of elements");
        for(int x: C)
            System.out.print(" : " + x);
        
        
        // finally populate elements in B
        for(int m = (n - 1); m >=0; m--){
            B[C[A[m]] - 1] = A[m];
            C[A[m]]--;
        }
        
        System.out.println("\n Sorted elements");
        for(int x: B)
            System.out.print(" : " + x);
    }
}
class Demo{

    public static void main(String[] args){
        CountingSort csort = new CountingSort();
        int A[] = {2,5,3,0,2,3,0,3};
        csort.sort(A, A.length, 5); // n=8 , k=5
    }
}
