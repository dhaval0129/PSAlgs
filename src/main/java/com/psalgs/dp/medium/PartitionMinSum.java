/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp.medium;

/**
 * Partition a set into two subsets such that the difference of subset sums is
 * minimum
 *
 * http://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
 * 
 * Refer: SubsetSum1 and SubsetSum2 firstly from dp.easy package
 * 
 * http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
 *
 * http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 *
 *
 * Input: arr[] = {1, 6, 11, 5} 
 * Output: 1
 * 
 * Explanation: 
 * Subset1 = {1, 5, 6}, sum of Subset1 = 12 
 * Subset2 = {11}, sum of subset 2 is 11 
 * so minimum value is 12 - 11 = 1
 *
 * Time Complexity = O(n * sum)
 * 
 * @author djoshi
 */
public class PartitionMinSum {

    public static int findMinSum_Rec(int[] arr, int i, int sumCalculated, int sumTotal) {

        if (i == 0) {
//            System.out.println(Math.abs((sumTotal - sumCalculated) - sumCalculated));
            return Math.abs((sumTotal - sumCalculated) - sumCalculated);
        }

        return Math.min(findMinSum_Rec(arr, i - 1, sumCalculated + arr[i - 1], sumTotal),
                findMinSum_Rec(arr, i - 1, sumCalculated, sumTotal));
    }

    private static int findMinSum_DP(int[] arr, int n, int sum) {
        // here we declare array of size [n][sum], in reference to this
        // example of subset sum we declared [sum][n], Example can be solved
        // in both ways, if condition needs to be modified if row and columns are swapped
        
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Initialize first column as true for all rows as 0 sum is possible with all elements.
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Initialize top row, except dp[0][0], as false. With
        // 0 elements (empty subset), no other sum except 0 is possible
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }

        // Fill the partition table in bottom up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // If i'th element is excluded
                dp[i][j] = dp[i - 1][j];

                // If i'th element is included
                if (arr[i - 1] <= j) {
                    dp[i][j] |= dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        int diff = Integer.MAX_VALUE;

        // Find the largest j such that dp[n][j]
        // is true where j loops from sum/2 to 0
        for (int j = sum / 2; j >= 0; j--) {
            // Find the 
            if (dp[n][j]) {
                diff = sum - 2 * j;
                break;
            }
        }
        return diff;
    }

    public static void main(String args[]) {
        int[] arr = {1, 7, 5};  // 13
        int n = arr.length;
        int sumTotal = 0;

        for (int i = 0; i < arr.length; i++) {
            sumTotal += arr[i];
        }

//        System.out.println(findMinSum_Rec(arr, n, 0, sumTotal));
        System.out.println(findMinSum_DP(arr, n, sumTotal));
    }

}
