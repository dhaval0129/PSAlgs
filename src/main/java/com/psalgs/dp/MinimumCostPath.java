/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp;

/**
 *
 * @author djoshi
 *
 * Reference:
 * http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 */
public class MinimumCostPath {

    /* A utility function that returns minimum of 3 integers */
    private static int min(int x, int y, int z) {
        if (x < y) {
            return (x < z) ? x : z;
        } else {
            return (y < z) ? y : z;
        }
    }

    private static int minCost(int cost[][], int m, int n) {
        int tc[][] = new int[m + 1][n + 1];

        tc[0][0] = cost[0][0];

        /* Initialize first column of total cost(tc) array */
        for (int i = 1; i <= m; i++) {
            tc[i][0] = tc[i - 1][0] + cost[i][0];
        }

        /* Initialize first row of tc array */
        for (int j = 1; j <= n; j++) {
            tc[0][j] = tc[0][j - 1] + cost[0][j];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                tc[i][j] = min(tc[i - 1][j - 1], tc[i - 1][j], tc[i][j - 1]) + cost[i][j];
            }
        }

        return tc[m][n];
    }

    public static void main(String args[]) {
        int cost[][] = {{1, 2, 3},
                        {4, 8, 2},
                        {1, 5, 3} };
        System.out.println("minimum cost to reach (2,2) = " + minCost(cost, 2, 2));
    }

}
