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
 * http://www.geeksforgeeks.org/find-four-elements-a-b-c-and-d-in-an-array-such-that-ab-cd/
 *
 * Find four elements a, b, c and d in an array such that a+b = c+d
 *
 */
public class PairSum2 {

    static class pair {

        int first, second;

        pair(int f, int s) {
            first = f;
            second = s;
        }
    }

    private boolean findPairs(int arr[]) {
        // Create an empty Hash to store mapping from sum to
        // pair indexes
        HashMap<Integer, pair> map = new HashMap<>();
        int n = arr.length;

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {

                // If sum of current pair is not in hash,
                // then store it and continue to next pair
                int sum = arr[i] + arr[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, new pair(i, j));
                } else {
                    pair p = map.get(sum);
                    // Since array elements are distinct, we don't
                    // need to check if any element is common among pairs
                    System.out.println("(" + arr[p.first] + ", " + arr[p.second]
                            + ") and (" + arr[i] + ", " + arr[j] + ")");
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int arr[] = {3, 4, 7, 1, 2, 9, 8};
        PairSum2 sum = new PairSum2();
        sum.findPairs(arr);
    }
}
