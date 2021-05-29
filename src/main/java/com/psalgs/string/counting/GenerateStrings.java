/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.counting;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/count-strings-can-formed-using-b-c-given-constraints/
 *
 * Count of strings that can be formed using a, b and c under given constraints
 *
 * Given a length n, count the number of strings of length n that can be made
 * using ‘a’, ‘b’ and ‘c’ with at-most one ‘b’ and two ‘c’s allowed.
 */
public class GenerateStrings {

    private static int countStr_Rec(int n, int bCount, int cCount) {

        // Base cases
        if (bCount < 0 || cCount < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (bCount == 0 && cCount == 0) {
            return 1;
        }

        // Three cases, we choose, a or b or c
        // In all three cases n decreases by 1.
        int res = countStr_Rec(n - 1, bCount, cCount);
        res += countStr_Rec(n - 1, bCount - 1, cCount);
        res += countStr_Rec(n - 1, bCount, cCount - 1);

        return res;
    }

    private static int countStr_DP(int dp[][][], int n, int bCount, int cCount) {
       return 0;
    }

    public static void main(String args[]) {
        int n = 3;
        System.out.println(countStr_Rec(n, 1, 2));
//        int[][][] dp = new int[n+1][2][3];
//        System.out.println(countStr_DP(dp, n, 1, 2));
    }
}
