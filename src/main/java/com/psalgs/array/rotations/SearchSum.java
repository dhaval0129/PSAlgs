/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.rotations;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/
 *
 * Given a sorted and rotated array, find if there is a pair with a given sum
 *
 */
public class SearchSum {

    private static boolean pairInSortedRotated(int arr[], int n, int x) {
        // Find the pivot element
        int i;
        for (i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                break;
            }
        }

        int l = (i + 1) % n; // l is now index of minimum element
        int r = i;           // r is now index of maximum element

        // Keep moving either l or r till they meet
        // Keep moving either l or r till they meet
        while (l != r) {
            // If we find a pair with sum x, we
            // return true
            if (arr[l] + arr[r] == x) {
                return true;
            }

            // If current pair sum is less, move to the higher sum
            if (arr[l] + arr[r] < x) {
                l = (l + 1) % n;
            } else { // Move to the lower sum side
                r = (n + r - 1) % n;
            }
        }
        
        return false;
    }

    public static void main(String args[]) {
        int arr[] = {10, 15, 6, 8, 9, 10};
        int sum = 17;
        int n = arr.length;

        if (pairInSortedRotated(arr, n, sum)) {
            System.out.print("Array has two elements with sum 16");
        } else {
            System.out.print("Array doesn't have two elements with sum 16 ");
        }
    }
}
