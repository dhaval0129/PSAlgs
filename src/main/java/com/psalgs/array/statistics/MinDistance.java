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
 * http://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/
 *
 * Find the minimum distance between two numbers
 *
 * Time Complexity: O(n)
 *
 */
public class MinDistance {

    private static int minDist(int[] arr, int n, int x, int y) {
        int min_dist = Integer.MAX_VALUE;
        int prev = 0;

        // Find the first occurence of any of the two numbers ( x or y)
        // and store the index of this occurence in prev
        for (int i = 0; i < n; i++) {
            if (arr[i] == x || arr[i] == y) {
                prev = i;
                break;
            }
        }

        // Traverse after the first occurrence 
        for (int i = prev; i < n; i++) {
            if (arr[i] == x || arr[i] == y) {
                // If the current element matches with any of the two then
                // check if current element and prev element are different 
                // Also check if this value os smaller than minimum distance fo far
                if (arr[prev] != arr[i] && (i - prev) < min_dist) {
                    min_dist = i - prev;
                    prev = i;
                } else {
                    prev = i;
                }
            }
        }
        return min_dist;
    }

    public static void main(String args[]) {
        int arr[] = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3};
        int n = arr.length;
        int x = 3;
        int y = 6;

        System.out.println("Minimum distance between " + x + " and " + y + " is " + minDist(arr, n, x, y));
    }
}
