/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp.hard;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
 *
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/MatrixMultiplicationCost.java
 *
 * https://www.youtube.com/watch?v=vgLJZMUfnsU
 * 
 * https://www.youtube.com/watch?v=prx1psByp7U
 *
 * Matrix Chain Multiplication
 *
 * Given a sequence of matrices, find the most efficient way to multiply these
 * matrices together. ( minimize cost of multiplication )
 *
 * Time Complexity: O(n^3) 
 * Auxiliary Space: O(n^2)
 *
 */
public class MatrixChainMultiplication {

    private static int MatrixChainOrder_Rec(int p[], int i, int j) {
        if (i == j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        // place parenthesis at different places between first
        // and last matrix, recursively calculate count of
        // multiplications for each parenthesis placement and
        // return the minimum count
        for (int k = i; k < j; k++) {
            int count = MatrixChainOrder_Rec(p, i, k)
                    + MatrixChainOrder_Rec(p, k + 1, j)
                    + p[i - 1] * p[k] * p[j];

            if (count < min) {
                min = count;
            }
        }
        return min;
    }

    private static int MatrixChainOrder_DP(int p[], int n) {

        int m[][] = new int[n][n];

        // L is chain length
        for (int L = 2; L < n; L++) {
            // start with length 2 and till n-L
            for (int i = 0; i < n - L; i++) {
                // set limit for length for total matrix from starting point i
                int j = i + L;
                // init the cell to max value
                m[i][j] = Integer.MAX_VALUE; 

                // calculate all possible combinations between i and j 
                for (int k = i + 1; k < j; k++) {
                    // q = cost/scalar multiplications
                    int q = m[i][k] + m[k][j] + p[i] * p[k] * p[j];

                    if (q < m[i][j]) {
                        m[i][j] = q;
                    }
                }
            }
        }

        return m[0][n - 1];
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4};
        int n = arr.length;

//        System.out.println("Minimum number of multiplications: "+ MatrixChainOrder_Rec(arr, 1, n - 1));
        System.out.println("Minimum number of multiplications: " + MatrixChainOrder_DP(arr, n));
    }
}
