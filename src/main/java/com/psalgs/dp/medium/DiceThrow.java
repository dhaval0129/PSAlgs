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
 * http://www.geeksforgeeks.org/dice-throw-problem/
 * 
 * http://techfollowers.com/2015/06/27/sum-of-dice-thrown-dynamic-programming/
 *
 * Given n dice each with m faces, numbered from 1 to m, find the number of ways
 * to get sum X
 *
 * Time Complexity O(m * n * sum)
 */
public class DiceThrow {

    private static int count = 0;

    private static int DiceThrowSum_Rec(int m, int n, int X) {
        int sum = 0;

        for (int i = 1; i <= m; i++) {
            if (n > 0) {
                sum += DiceThrowSum_Rec(m, n - 1, X - i);
            }
        }

        if (sum == X) {
            ++count;
        }
        return count;
    }

    private static int DiceThrowSum_DP(int m, int n, int sumX) {
        int[][] table = new int[n + 1][sumX + 1];

        for (int j = 1; j <= m && j <= sumX; j++) {
            table[1][j] = 1;
        }

        // no. of dice attempts
        for (int i = 2; i <= n; i++) {
            // total no. sum 
            for (int j = 1; j <= sumX; j++) {
                // values of dice faces and sum values 
                for (int k = 1; k <= m && k < j; k++) {                    
                    table[i][j] += table[i - 1][j - k];
                }
            }
        }
        
        return table[n][sumX];
    }

    public static void main(String args[]) {
        System.out.println("No. of ways: " + DiceThrowSum_DP(4, 3, 5));
    }

}
