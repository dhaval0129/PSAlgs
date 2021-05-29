/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.hashing;

import java.util.HashMap;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/count-pairs-with-given-sum/
 *
 * Count pairs with given sum ( total pairs )
 *
 * Time Complexity O(n)
 *
 */
public class CountPairSum {

    private static int getPairsCount(int[] arr, int sum) {
        int n = arr.length;
        HashMap<Integer, Integer> hm = new HashMap<>();

        // store counts of all elements  in map hm
        for (int i = 0; i < n; i++) {
            // initializing value to 0, if key not found
            if (!hm.containsKey(arr[i])) {
                hm.put(arr[i], 0);
            }

            hm.put(arr[i], hm.get(arr[i]) + 1);
        }

        int twice_count = 0;

        // Iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for (int i = 0; i < n; i++) {
            if (hm.get(sum - arr[i]) != null) {
                twice_count += hm.get(sum - arr[i]);

                // if (arr[i], arr[i]) pair satisfies the condition,
                // then we need to ensure that the count is
                // decreased by one such that the (arr[i], arr[i])
                // pair is not considered
                if (sum - arr[i] == arr[i]) {
                    twice_count--;
                }
            }
        }

        // return the half of twice_count
        return twice_count / 2;
    }

    public static void main(String args[]) {
        int[] arr = {1, 5, 7, -1, 5};
        int sum = 6;

        getPairsCount(arr, sum);
    }
}
