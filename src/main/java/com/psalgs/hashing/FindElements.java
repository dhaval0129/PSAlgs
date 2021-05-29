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
 * http://www.geeksforgeeks.org/find-missing-elements-of-a-range/
 *
 * Find missing elements for a given range
 *
 * Input: arr[] = {10, 12, 11, 15} low = 10, hight = 15 Output: 13, 14
 *
 * Time Complexity O( n*Log n + k ) where k is number of missing elements
 * 
 * 1] Push all elements from array to hash set.
 * 2] start a for loop, initialize from lower range to high range.
 * 3] check if value exists in hash set, if it does not exist then print value.
 * 4] increment the loop, repeat step 3 with incremented value.
 */
public class FindElements {

    private static void printMissing(int arr[], int low, int high) {
        HashSet<Integer> hs = new HashSet<>();

        // Insert all elements of arr[] in set
        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }

        // Traverse throught the range an print all
        // missing elements
        for (int i = low; i <= high; i++) {
            if (!hs.contains(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {1, 3, 5, 4};
        int low = 1, high = 10;

        printMissing(arr, low, high);
    }
}
