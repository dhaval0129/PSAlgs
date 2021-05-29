/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.optimization;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/
 *
 * Find the minimum distance between two numbers
 *
 */
public class MinDist {

    private static int minDist(int[] arr, int n, int x, int y) {
        int min_dist = Integer.MAX_VALUE;
        int prev = 0;

        // Find the first occurence of any of the two numbers (x or y)
        // and store the index of this occurence in prev
        for (int i = 0; i < n; i++) {
            if (arr[i] == x || arr[i] == y) {
                prev = i;
                break;
            }
        }

        // Traverse after the first occurence
        for (int i = prev; i < n; i++) {
            // If the current element matches with any of the two then
            // check if current element and prev element are different
            // Also check if this value is smaller than minimum distance 
            // so far
            if (arr[i] == x || arr[i] == y) {
                min_dist = i - prev;
                prev = i;
            }
        }

        return min_dist;
    }

    public static void main(String args[]) {
        int arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
        int n = arr.length;
        int x = 3;
        int y = 6;

        System.out.println("Minimum distance between " + x + " and " + y
                + " is " + minDist(arr, n, x, y));
    }
}
