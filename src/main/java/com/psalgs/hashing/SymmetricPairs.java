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
 * http://www.geeksforgeeks.org/given-an-array-of-pairs-find-all-symmetric-pairs-in-it/
 *
 * Given an array of pairs, find all symmetric pairs in it
 *
 * Time Complexity of this solution is O(n) under the assumption that hash
 * search and insert methods work in O(1) time.
 *
 */
public class SymmetricPairs {

    private static void findSymPairs(int arr[][]) {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<>();

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {
            // First and second elements of current pair
            int first = arr[i][0];
            int sec = arr[i][1];

            // Look for second element of current pair
            Integer val = hM.get(sec);

            // If found and value in hash matches with first
            // element of this pair, we found symmetry
            if (val != null && val == first) {
                System.out.println("(" + sec + "," + first + ")");
            } else {
                hM.put(first, sec);
            }
        }
    }

    public static void main(String args[]) {
        int arr[][] = new int[5][2];
        arr[0][0] = 11;
        arr[0][1] = 20;
        arr[1][0] = 30;
        arr[1][1] = 40;
        arr[2][0] = 5;
        arr[2][1] = 10;
        arr[3][0] = 40;
        arr[3][1] = 30;
        arr[4][0] = 10;
        arr[4][1] = 5;
        findSymPairs(arr);
    }
}
