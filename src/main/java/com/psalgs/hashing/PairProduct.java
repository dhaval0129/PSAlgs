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
 * http://www.geeksforgeeks.org/pair-with-given-product-set-1-find-if-any-pair-exists/
 *
 * Pair with given product
 *
 * Time Complexity O(n) using hashing
 *
 */
public class PairProduct {

    private static boolean isProduct(int arr[], int n, int x) {
        // Create an empty set and insert first
        // element into it
        HashSet<Integer> hset = new HashSet<>();

        // exceptional test cases
        if (n < 2) {
            return false;
        }

        //Traverse remaining elements
        for (int i = 0; i < n; i++) {
            
            // exceptional test cases
            if(arr[i] == 0) {
                if(x == 0){
                    return true;
                } else {
                    continue;
                }
            }
            
            if(x % arr[i] == 0) {
                if(hset.contains(x / arr[i])) {
                    return true;
                }
                // Insert arr[i]
                hset.add(arr[i]);
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int arr[] = {10, 20, 9, 40};
        int x = 400;
        int n = arr.length;

        if (isProduct(arr, n, x)) {
            System.out.println("Product exists");
        } else {
            System.out.println("Product does not exists");
        }
    }
}
