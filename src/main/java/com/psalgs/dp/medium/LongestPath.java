/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp.medium;

/**
 *
 * http://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/
 *
 * Find the longest path in a matrix such that all cells
 * along the path are in increasing order with a difference of 1.
 *
 * Input: mat[][] = {{1, 2, 9} {5, 3, 8} {4, 6, 7}} 
 * Output: 4 The longest path in increasing order is 6-7-8-9.
 *
 * Time Complexity O(n^2)
 *
 * @author djoshi
 */
public class LongestPath {

    private static int findLongestFromACell(int i, int j, int mat[][], int dp[][]) {
        int n = mat.length;

        if (i < 0 || i >= n || j < 0 || j >= n) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        if (j < n - 1 && ((mat[i][j] + 1) == mat[i][j + 1])) {
            return dp[i][j] = 1 + findLongestFromACell(i, j + 1, mat, dp);
        }

        if (j > 0 && (mat[i][j] + 1 == mat[i][j - 1])) {
            return dp[i][j] = 1 + findLongestFromACell(i, j - 1, mat, dp);
        }

        if (i > 0 && (mat[i][j] + 1 == mat[i - 1][j])) {
            return dp[i][j] = 1 + findLongestFromACell(i - 1, j, mat, dp);
        }

        if (i < n - 1 && (mat[i][j] + 1 == mat[i + 1][j])) {
            return dp[i][j] = 1 + findLongestFromACell(i + 1, j, mat, dp);
        }

        return dp[i][j] = 1;
    }

    private static int finLongestOverAll(int mat[][]) {
        int result = 1;
        int n = mat.length;

        int dp[][] = new int[n][n];

        // Compute longest path beginning from all cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) {
                    findLongestFromACell(i, j, mat, dp);
                }
                //  Update result if needed
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int mat[][] = {
            {1, 2, 9},
            {5, 3, 8},
            {4, 6, 7}
        };

        System.out.println(finLongestOverAll(mat));

    }

}
