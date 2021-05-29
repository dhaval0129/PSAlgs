/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.hashing;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
 *
 * Given an array A[] and a number x, check for pair in A[] with sum as x
 *
 *  Time Complexity O(n) using hashing (hash set)
 */
public class PairSum {

    private static final int MAX = 100;

    private static void printPairs(int arr[], int sum) {
        // Declares and initializes the whole array as false
        boolean[] binmap = new boolean[MAX];

        for (int i = 0; i < arr.length; ++i) {
            int temp = sum - arr[i];

            // checking for condition
            if (temp >= 0 && binmap[temp]) {
                System.out.println("Pair with given sum " + sum + " is (" + arr[i] + "," + temp + ")");
            }
            binmap[arr[i]] = true;
        }
    }

    public static void main(String args[]) {
        int A[] = {1, 4, 45, 6, 10, 8};
        int n = 16;
        printPairs(A, n);
    }

}
