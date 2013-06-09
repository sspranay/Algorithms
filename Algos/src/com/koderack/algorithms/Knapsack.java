package com.koderack.algorithms;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ppramod
 */
public class Knapsack {

    public static void main(String[] args) {
        int N; // total items 
        int W; // Knapsack capacity
        
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Knapsack capacity?");
            W = Integer.parseInt(br.readLine()); // why not read()?

            System.out.println("Number of Items?");
            N = Integer.parseInt(br.readLine()); // why not read()?
            
            System.out.println("Enter weight profit values for each item");
            int[] weight = new int[N+1]; // N weights, starting at 1
            int[] profit = new int[N+1]; //// corresponding N profits
            
            for (int lines = 0; lines < N; lines++) {
                String weightAndValue = br.readLine(); // why not read()?
                String[] both = weightAndValue.split(" ");
                weight[lines + 1] = Integer.parseInt(both[0]);
                profit[lines + 1] = Integer.parseInt(both[1]);
            }
            
            int[][] optimalWeight = new int[N + 1][W + 1];
           boolean[][] selectedWeights= new boolean[N + 1][W + 1];
           
            // picking no item of whatever weight doesn't add to solution, thus initialized to 0
            for (int i = 0; i <= W; i++) {
                optimalWeight[0][i] = 0;
            }

            // for each item, calculate the optimal weight, considering each unitOfWeight 1- W
            for (int item = 1; item <= N; item++) {
                for (int jUnitsOfWeight = 0; jUnitsOfWeight <= W; jUnitsOfWeight++) {
                    if (weight[item] <= jUnitsOfWeight) {
                        int previousBest = optimalWeight[item - 1][jUnitsOfWeight];
                        int currentBest = optimalWeight[item - 1][jUnitsOfWeight - weight[item]] + profit[item];
                        
                        optimalWeight[item][jUnitsOfWeight] = Math.max(previousBest, currentBest);
                        
                        selectedWeights[item][jUnitsOfWeight] = currentBest > previousBest;
                    } else {
                        optimalWeight[item][jUnitsOfWeight] = optimalWeight[item - 1][jUnitsOfWeight];
                    }
                }
            }

            // pretty print the cost matrix
            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= W; j++) {
                    System.out.print(" " + optimalWeight[i][j]);
                }
                System.out.println();
            }
            
            // pretty print the selection matrix
            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= W; j++) {
                    System.out.print(" " + selectedWeights[i][j]);
                }
                System.out.println();
            }
            
            // print the selected items, final
            boolean[] selected = new boolean[N + 1];
            System.out.println("selected weights - ");
            for(int n=N, w=W; n>0; n--){
                if(selectedWeights[n][w]){
                    selected[n] = true;
                    System.out.print(n + " ");
                    w = W - weight[n];
                }
                else 
                    selected[n] = false;
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Knapsack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

/**
 * Knapsack capacity?
5
Number of Items?
3
Enter weight profit values for each item
3 5
2 3
1 4
 0 0 0 0 0 0
 0 0 0 5 5 5
 0 0 3 5 5 8
 0 4 4 7 9 9
 */