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
 * http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
 *
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/SubsetSum.java
 *
 * Partition problem is to determine whether a given set can be partitioned into
 * two subsets such that the sum of elements in both subsets is same.
 *
 *
 * Time Complexity: O(sum * n)
 */
public class SubsetSum2 {

    // Time Complexity: O(2^n)
    private static boolean isSubsetSum_Rec(int[] arr, int n, int sum) {
        // Base Cases
        if (sum == 0) {
            return true;
        }
        if (n == 0 && sum != 0) {
            return false;
        }

        // If last element is greater than sum, then ignore it
        if (arr[n - 1] > sum) {
            return isSubsetSum_Rec(arr, n - 1, sum);
        }

        /* else, check if sum can be obtained by any of the following
          1] including last element 
          2] excluding last element
         */
        return isSubsetSum_Rec(arr, n - 1, sum)
                || isSubsetSum_Rec(arr, n - 1, sum - arr[n - 1]);
    }

    private static boolean findPartition(int arr[], int n) {
        // Calculate sum of the elements in array
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        // If sum is odd, there cannot be two subsets with equal sum
        if (sum % 2 != 0) {
            return false;
        }

        // Find if there is subset with sum equal to half of total sum
        return isSubsetSum_Rec(arr, n, sum / 2);
    }

    private static boolean findPartition_DP(int arr[], int n) {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        boolean subset[][] = new boolean[sum / 2 + 1][n + 1];

        // For empty set which is {0},If sum is 0, then answer is true
        for (int i = 0; i <= n; i++) {
            subset[0][i] = true;
        }

        // If set is not empty, then answer is false as sum is not 0
        for (int i = 0; i < sum / 2; i++) {
            subset[i][0] = false;
        }

        //Fill table in bottom up manner
        for (int i = 1; i <= sum / 2; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= arr[j - 1]) {
                    subset[i][j] = subset[i][j] || subset[i - arr[j - 1]][j - 1];
                }
            }
        }

        return subset[sum / 2][n];
    }

    public static void main(String args[]) {
//        int arr[] = {2, 3, 7, 8};
        int arr[] = {3, 1, 1, 2, 2, 1};
        int n = arr.length;

        if (findPartition_DP(arr, n)) {
            System.out.println("Can be divided into two subsets of equal sum");
        } else {
            System.out.println("Can not be divided into two subsets of equal sum");
        }
    }
}
