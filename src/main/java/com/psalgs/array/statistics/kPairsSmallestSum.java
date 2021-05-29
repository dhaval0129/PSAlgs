/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.statistics;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/find-k-pairs-smallest-sums-two-arrays/
 *
 * Find k pairs with smallest sums in two arrays
 *
 * Time Complexity : O(k*n1)
 *
 */
public class kPairsSmallestSum {

    private static void kSmallestPair(int arr1[], int n1,
            int arr2[], int n2, int k) {

        if (k > n1 * n2) {
            System.out.print("k pairs don't exist");
            return;
        }

        // Stores current index in arr2[] for every element of arr1[].
        // Initially all values are considerd 0. Here current index is the index before
        // which all elements are considerd part of output.
        int[] index = new int[n1];

        while (k > 0) {
            //Initialize current pair sum as infinite
            int min_sum = Integer.MAX_VALUE;
            int min_index = 0;

            // To pick next pair, traverse for all elements of arr1[]
            // for every element find corresponding current element in arr2[] and 
            // pick minimum of all formed pairs;
            for (int i = 0; i < n1; i++) {
                
                // Check if current element of arr1[] plus
                // element of array2 to be used gives minimum sum
                int j = index[i];
                if (j < n2 && arr1[i] + arr2[j] < min_sum) {
                    // Update index that gives min sum
                    min_index = i;
                    // Update minimum sum
                    min_sum = arr1[i] + arr2[j];
                }
            }

            // print min sum
            System.out.print("(" + arr1[min_index] + ", " + arr2[index[min_index]] + ") ");
            // update index array to start with next number and skip this number
            // when we start next array
            index[min_index]++;
            k--;
        }
    }

    public static void main(String args[]) {
        int arr1[] = {1, 3, 11};
        int n1 = arr1.length;

        int arr2[] = {2, 4, 8};
        int n2 = arr2.length;

        int k = 4;
        kSmallestPair(arr1, n1, arr2, n2, k);
    }
}
