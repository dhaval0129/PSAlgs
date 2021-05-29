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
 * http://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-within-k-distance/
 *
 * Check if a given array contains duplicate elements within k distance from
 * each other
 *
 */
public class kDistDuplicates {

    private static boolean kDistDuplicates(int arr[], int k) {
        // Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();

        // Traverse the input array
        for (int i = 0; i < arr.length; i++) {

            // If already present n hash, then we found 
            // a duplicate within k distance
            if (set.contains(arr[i])) {
                return true;
            }

            // Add this item to hashset
            set.add(arr[i]);

            // Remove the k+1 distant item
            if (i >= k) {
                set.remove(arr[i - k]);
            }
        }

        return false;
    }

    public static void main(String args[]) {
        int arr[] = {10, 5, 3, 4, 3, 5, 6};

        if (kDistDuplicates(arr, 3)) {
            System.out.println("There are duplicates within k distance");
        } else {
            System.out.println("No Duplicates within k distance");
        }
    }
}
