/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp.easy;

import java.util.ArrayList;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/longest-increasing-subsequence/
 *
 * https://www.programcreek.com/2014/04/leetcode-longest-increasing-subsequence-java/
 *
 * Longest Increasing subsequence { 5,2,7,4,3,8 } {2,7,8} which is of size 3
 *
 * Time Complexity O( n*log(n) ) // partial binary search implementation
 *
 */
class LIS {

    // Time Complexity : O(n^2)
    private static int LIS_DP(int[] arr) {
        // base cases
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[] max = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            max[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    max[i] = Math.max(max[i], max[j] + 1);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < max.length; i++) {
            if (max[i] > result) {
                result = max[i];
            }
        }
        return result;
    }

    // Time Complexity O(n log n)
    // Instead of array list you can also use array
    // just need to keep track of end value;
    private static int LIS_Optimized(int[] arr) {
        // base cases
        if (arr == null || arr.length == 0) {
            return 0;
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int num : arr) {
            // If number is greater then previous number
            if (list.isEmpty() || num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int i = 0;
                int j = list.size() - 1;

                while (i < j) {
                    int mid = (i + j) / 2;
                    // value at mid is less then given num
                    if (list.get(mid) < num) {
                        // increase the i = mid + 1
                        i = mid + 1;
                    } else {
                        // values at mid greater or equal to given num
                        // if (list.get(mid) > num)
                        // decrease j = mid
                        j = mid;
                    }
                }
                list.set(j, num);
            }
        }
        return list.size();
    }

    public static void main(String args[]) {
        int a[] = {1, 9, 3, 7, 5, 6, 20};
        System.out.println("Length of LIS is " + LIS_Optimized(a));
    }

}
