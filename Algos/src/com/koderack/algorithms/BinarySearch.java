package com.koderack.algorithms;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pranay
 */
public class BinarySearch {
    
    public static void main(String[] args){
        char[] input = {'a', 'b', 'c', 'd'};
        char needle = 's';
        
        System.out.println(BinarySearch.binarySearch(input, needle));
    }
    
    public static int binarySearch(char[] haystack, char needle){
        if(haystack.length == 0)
            return -1;
        else{
            int high = haystack.length;
            int low = 0;
            int middle  = (low + high) / 2;
            
            while(low < high){
                if(haystack[middle] == needle)
                    return middle;
                else if(needle < haystack[middle]){
                    high = middle - 1;
                }
                else{
                    low = middle + 1;
                }
                middle = (low + high) / 2;
            }
        }
        return -1;
    }
}
