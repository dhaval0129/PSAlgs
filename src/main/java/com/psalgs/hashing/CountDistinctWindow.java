/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.hashing;

import java.util.Arrays;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
 *
 * Count distinct elements in every window of size k
 *
 *
 */
public class CountDistinctWindow {

    private static int countWindowDistinct(int win[], int k) {
        int dist_count = 0;

        // Traverse the window
        for (int i = 0; i < k; i++) {
            // Check if element arr[i] exists in arr[0..i-1]
            int j;
            for (j = 0; j < i; j++) {
                if (win[i] == win[j]) {
                    break;
                }
            }

            if (j == i) {
                dist_count++;
            }
        }

        return dist_count;
    }

    private static void countDistinct(int arr[], int n, int k) {
        for (int i = 0; i <= n - k; i++) {
            int ans = countWindowDistinct(Arrays.copyOfRange(arr, i, arr.length), k);
            System.out.println(ans);
        }
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        countDistinct(arr, arr.length, k);
    }
}
