/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp.easy;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 *
 * https://www.youtube.com/watch?v=_fgjrs570YE
 *
 * https://www.youtube.com/watch?v=F28xN-S1SmI
 *
 * https://www.youtube.com/watch?v=NJuKJ8sasGk
 *
 * Coin Change problem
 *
 * Given value of N, How many possible ways we make the change of N cents if we
 * have infinite supply of coins S {s1,s2,s3...sn}
 *
 * Time Complexity O(m * n) Space Complexity O(n)
 *
 */
public class CoinChange {

    private static int countWays_Rec(int S[], int m, int n) {
        // If n is 0 then is 1 solution
        if (n == 0) {
            return 1;
        }

        // If n is less then 0 then no solution exists
        if (n < 0) {
            return 0;
        }

        //If there are no coins and n is greater than 0, then no solution exists
        if (m <= 0 && n >= 1) {
            return 0;
        }

        // count is sum of solutions (i)  
        // including S[m-1] (ii) excluding S[m-1] 
        return countWays_Rec(S, m - 1, n) + countWays_Rec(S, m, n - S[m - 1]);
    }

    //Time complexity of this function: O(mn)
    //Space Complexity of this function: O(n)
    private static int countWays_DP(int S[], int m, int n) {

        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        int[] table = new int[n + 1];

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[] values 
        // after the index greater than or equal to the value of the 
        // picked coin 
        for (int i = 0; i < m; i++) {
            for (int j = S[i]; j <= n; j++) {
                table[j] += table[j - S[i]];
            }
        }

        return table[n];
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        int n = 4; // total coin value target
        System.out.println(countWays_DP(arr, m, n));
    }

}
