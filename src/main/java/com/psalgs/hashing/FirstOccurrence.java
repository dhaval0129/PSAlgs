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
 * http://www.geeksforgeeks.org/group-multiple-occurrence-of-array-elements-ordered-by-first-occurrence/
 *
 * Group multiple occurrence of array elements ordered by first occurrence
 *
 * Time Complexity O(n), insert, search and delete operation is O(1)
 *
 */
public class FirstOccurrence {

    private static void orderedGroup(int arr[]) {
        // Creates an empty hashmap
        HashMap<Integer, Integer> hM = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            // Check if element is already in HashMap
            Integer prevCount = hM.get(arr[i]);
            if (prevCount == null) {
                prevCount = 0;
            }

            // Increment count of element in HashMap
            hM.put(arr[i], ++prevCount);
        }

        // Traverse array again 
        for (int i = 0; i < arr.length; i++) {
            // Check if this is first occurrence
            Integer count = hM.get(arr[i]);
            if (count != null) {
                // If yes, then print the element 'count' times
                for (int j = 0; j < count; j++) {
                    System.out.print(arr[i] + " ");
                }
                // And remove the element from HashMap
                hM.remove(arr[i]);
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {10, 5, 3, 10, 10, 4, 1, 3};
        orderedGroup(arr);
    }

}
