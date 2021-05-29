/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp.easy;

/**
 *
 * http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 *
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/SubsetSum.java
 *
 * https://www.youtube.com/watch?v=s6FhG--P7z0
 *
 * Given a set of non-negative integers, and a value sum, determine if there is
 * a subset of the given set with sum equal to given sum.
 *
 *
 * Time Complexity: O(sum * n)
 *
 * Note: subset sum can be done in both way either we take row as sum and column
 * as size of array or vice-versa, If we do that then if condition will change to
 * opposite of cell values checking for condition will also change
 *
 * @author djoshi
 */
public class SubsetSum {

    // O(2 ^ n)
    private static boolean isSubsetSum_Rec(int set[], int n, int sum) {
        // Base Cases
        if (sum == 0) {
            return true;
        }
        if (n == 0 && sum != 0) {
            return false;
        }

        // If last element is greater than sum, then ignore it
        if (set[n - 1] > sum) {
            return isSubsetSum_Rec(set, n - 1, sum);
        }

        /* else, check if sum can be obtained by any of the following
          (a) including the last element
          (b) excluding the last element   
         */
        return isSubsetSum_Rec(set, n - 1, sum)
                || isSubsetSum_Rec(set, n - 1, sum - set[n - 1]);
    }

    // O(n^2)
    private static boolean isSubsetSum_DP(int set[], int n, int sum) {
        // The value of subset[i][j] will be true if there 
        // is a subset of set[0..j-1] with sum equal to i
        boolean subset[][] = new boolean[sum + 1][n + 1];

        // For empty set which is {0},If sum is 0, then answer is true
        for (int i = 0; i <= n; i++) {
            subset[0][i] = true;
        }

        // If set is not empty, then answer is false as sum is not 0
        for (int i = 1; i <= sum; i++) {
            subset[i][0] = false;
        }

        // Fill the subset table in botton up manner
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1]) {
                    subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
                }
            }
        }

        return subset[sum][n];
    }

    public static void main(String args[]) {
        int set[] = {2, 3, 7, 8};
        int sum = 11;
        int n = set.length;

        if (isSubsetSum_DP(set, n, sum)) {
            System.out.println("Found a subset with given sum");
        } else {
            System.out.println("Not subset with given sum");
        }
    }

}
