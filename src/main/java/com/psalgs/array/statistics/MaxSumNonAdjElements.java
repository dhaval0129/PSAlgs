/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.statistics;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 *
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/MaxSumForNonAdjacentElements.java
 *
 * https://www.youtube.com/watch?v=UtGtF6nc35g
 *
 * Maximum sum such that no two elements are adjacent to each other
 *
 * Time Complexity: O(n)
 *
 */
public class MaxSumNonAdjElements {

    private int FindMaxSum(int arr[], int n) {
        int incl = arr[0];
        int excl = 0;
        int excl_new;

        for (int i = 1; i < n; i++) {
            // current max excluding i
            excl_new = Math.max(incl, excl);

            // current max including i
            incl = excl + arr[i];
            excl = excl_new;
        }

        // return max of incl and excl
        return Math.max(incl, excl);
    }

    public static void main(String[] args) {
        MaxSumNonAdjElements sum = new MaxSumNonAdjElements();
        int arr[] = {5, 5, 10, 100, 10, 5};
        System.out.println(sum.FindMaxSum(arr, arr.length));
    }
}
