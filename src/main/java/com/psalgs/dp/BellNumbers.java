/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp;

/**
 *
 * Bell Numbers (Number of ways to Partition a Set)
 *
 * @author djoshi
 *
 * Input: n = 2 Output: Number of ways = 2 Explanation: 
 * Let the set be {1,2} { {1},{2} } { {1,2} }
 * 
 * Reference: http://www.geeksforgeeks.org/bell-numbers-number-of-ways-to-partition-a-set/
 * 
 */
public class BellNumbers {

    static int bellNumber(int n) {
        int bell[][] = new int[n + 1][n + 1];
        bell[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            // Explicitly fill for j = 0 for rows
            bell[i][0] = bell[i - 1][i - 1];

            // Fill for remaining values of j
            for (int j = 1; j <= i; j++) {
                bell[i][j] = bell[i - 1][j - 1] + bell[i][j - 1];
            }
        }
        return bell[n][0];

    }

    public static void main(String args[]) {
        for (int n = 0; n <= 5; n++) {
            System.out.println("Bell Number " + n + " is " + bellNumber(n));
        }
    }
}
