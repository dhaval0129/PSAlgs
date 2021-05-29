/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.hashing;

import java.util.HashSet;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/longest-consecutive-subsequence/
 *
 * Longest Consecutive Subsequence
 *
 * Time Complexity O(n)
 *
 */
public class LCS {

    private static int findLongestConseqSubseq(int[] arr, int n) {
        HashSet<Integer> S = new HashSet<>();
        int ans = 0;

        // Hash all the array elements
        for (int i = 0; i < n; ++i) {
            S.add(arr[i]);
        }

        // check each possible sequence from the start
        // then update optimal length
        for (int i = 0; i < n; ++i) {
            // if current element is the starting
            // element of a sequence
            if (!S.contains(arr[i] - 1)) {
                // Then check for next elements in the sequence
                int j = arr[i];
                while (S.contains(j)) {
                    j++;
                }

                // update optimal length if this length is more
                if (ans < j - arr[i]) {
                    ans = j - arr[i];
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int arr[] = {1, 9, 3, 10, 4, 20, 2};
        int n = arr.length;
        System.out.println("Length of the Longest consecutive subsequence is "
                + findLongestConseqSubseq(arr, n));
    }

}
