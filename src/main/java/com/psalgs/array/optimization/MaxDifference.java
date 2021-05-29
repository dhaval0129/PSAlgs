/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.optimization;

import java.util.Arrays;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/minimize-the-maximum-difference-between-the-heights/
 *
 * Minimize the maximum difference between the heights
 *
 * Time Complexity O(n*log n)
 *
 */
public class MaxDifference {

    private static int getMinDiff(int[] arr, int n, int k) {
        if (n == 1) {
            return 0;
        }

        // Sort all elements
        Arrays.sort(arr);

        // Initialize result
        int ans = arr[n - 1] - arr[0];

        // Handle corner elements
        int small = arr[0] + k;
        int big = arr[n - 1] - k;
        int temp = 0;

        if (small > big) {
            temp = small;
            small = big;
            big = temp;
        }

        //Traverse middle elements
        for (int i = 1; i < n - 1; i++) {
            int subtract = arr[i] - k;
            int add = arr[i] + k;

            //If both substraction and addition do not change diff
            if (subtract >= small || add <= big) {
                continue;
            }

            // Either subtraction causes a smaller number or addition causes a greater
            // number. Update small or big using greedy approach (If big - subtract
            // causes smaller diff, update small else update big)
            if (big - subtract <= add - small) {
                small = subtract;
            } else {
                big = add;
            }
        }

        return Math.min(ans, big - small);
    }

    public static void main(String args[]) {
        int arr[] = {1, 10, 14, 14, 14, 15};
        int n = arr.length;
        int k = 6;
        System.out.println("Maximum difference is " + getMinDiff(arr, n, k));
    }
}
