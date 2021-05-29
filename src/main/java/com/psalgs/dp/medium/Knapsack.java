/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp.medium;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/knapsack-problem/
 *
 * https://www.youtube.com/watch?v=8LusJS5-AGo
 *
 * 0-1 Knapsack Problem
 *
 */
public class Knapsack {

    // O( 2 ^ n )
    // Overlapping sub problems and Optimal substructure property
    private static int knapSack_Rec(int wt[], int val[], int W, int n) {

        // base case ( if there are no items )
        if (W == 0 || n == wt.length) {
            return 0;
        }

        // If weight of item exceeds the W capacity
        if (wt[n] > W) {
            return knapSack_Rec(wt, val, W, n + 1);
        }

        // two cases
        // nth item included and nth item not included
        // return whichever value is greater
        int rMax = val[n] + knapSack_Rec(wt, val, W - wt[n], n + 1);
        int lMax = knapSack_Rec(wt, val, W, n + 1);
        return Math.max(rMax, lMax);
    }

    // O( n * w )
    // Dynamic programming solution
    private static int knapSack_DP(int wt[], int val[], int W, int n) {

        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (int i = 0; i <= n; i++) {

            for (int w = 0; w <= W; w++) {

                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    K[i][w] = Math.max(
                        val[i - 1] + K[i - 1][w - wt[i - 1]], // including weight
                        K[i - 1][w]);   // excluding weight
                } else {
                    K[i][w] = K[i - 1][w];
                }

            }
        }
        return K[n][W];
    }

    public static void main(String args[]) {
        int val[] = {1, 4, 5, 7};
        int wt[] = {1, 3, 4, 5};
        int W = 7;
        int n = val.length;
//        System.out.println(knapSack_Rec(wt, val, W, 0));
        System.out.println(knapSack_DP(wt, val, W, n));
    }

}
