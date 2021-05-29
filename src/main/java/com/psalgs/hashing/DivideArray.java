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
 * http://www.geeksforgeeks.org/check-if-an-array-can-be-divided-into-pairs-whose-sum-is-divisible-by-k/
 *
 * Check if an array can be divided into pairs whose sum is divisible by k
 *
 */
public class DivideArray {

    private static boolean canPairs(int[] arr, int k) {
        // An odd length array cannot be divided into pairs
        if (arr.length % 2 == 1) {
            return false;
        }

        // Create a frequency array to count occurrences
        // of all remainders when divided by k.
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Count occurrences of all remainders
        for (int i = 0; i < arr.length; i++) {
            int rem = arr[i] % k;
            if (!hm.containsKey(rem)) {
                hm.put(rem, 0);
            }
            hm.put(rem, hm.get(rem) + 1);
        }

        // Traverse input array and use freq[] to decide
        // if given array can be divided in pairs
        for (int i = 0; i < arr.length; i++) {
            // Remainder of current element
            int rem = arr[i] % k;

            // If remainder with current element divides
            // k into two halves.
            if (2 * rem == k) {
                // Then there must be even occurrences of such remainder
                if (hm.get(rem) % 2 == 1) {
                    return false;
                }
            } else if (rem == 0) {
                // Then there must be even occurrences of such remainder
                if (hm.get(rem) % 2 == 1) {
                    return false;
                }
            } else if (hm.get(k - rem) != hm.get(rem)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        int arr[] = {92, 75, 65, 48, 45, 35};
        int k = 10;
        boolean ans = canPairs(arr, k);
        if (ans) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
