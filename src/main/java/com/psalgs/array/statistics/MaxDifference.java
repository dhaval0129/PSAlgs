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
 * http://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 *
 * Maximum difference between two elements such that larger element appears
 * after the smaller number
 *
 * Hint: keep track of min element and subtract min element from current and
 * check with the max difference
 *
 * Time Complexity: O(n) 
 * Auxiliary Space: O(1)
 */
public class MaxDifference {

    private static int maxDiff(int[] arr, int n) {
        int max_diff = arr[1] - arr[0];
        int min_element = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] - min_element > max_diff) {
                max_diff = arr[i] - min_element;
            }

            if (arr[i] < min_element) {
                min_element = arr[i];
            }
        }

        return max_diff;
    }

    public static void main(String args[]) {
        int[] arr = {1, 2, 90, 10, 110};
        int n = arr.length;
        System.out.println("Maximum difference is: " + maxDiff(arr, n));
    }
}
