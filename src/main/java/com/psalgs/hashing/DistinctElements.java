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
 * http://www.geeksforgeeks.org/print-distinct-elements-given-integer-array/
 *
 * Print All Distinct Elements of a given integer array
 *
 */
public class DistinctElements {

    private static void printDistinct(int[] arr) {
        // Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            //If not present then put it in hashset and print it
            if (!set.contains(arr[i])) {
                System.out.print(arr[i] + " ");
                set.add(arr[i]);
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {10, 5, 3, 4, 3, 5, 6};
        printDistinct(arr);
    }
}
