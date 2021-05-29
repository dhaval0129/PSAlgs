/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.stack;

/**
 *
 * @author djoshi
 * 
 * http://www.geeksforgeeks.org/find-the-maximum-of-minimums-for-every-window-size-in-a-given-array/
 * 
 * Time Complexity O(n ^ 3)
 */
public class WindowSize {

    static int arr[] = {10, 20, 30, 50, 10, 70, 30};

    private static void printMaxOfMin(int n) {
        // Consider all windows of different sizes starting
        // from size 1
        for (int k = 1; k <= n; k++) {
            int maxOfMin = arr[0];
            int h = n - k;
            for (int i = 0; i <= h; i++) {
                int min = arr[i];
                for (int j = 1; j < k; j++) {
                    if (arr[i + j] < min) {
                        min = arr[i + j];
                    }
                }
                // Update maxOfMin if required
                if (min > maxOfMin) {
                    maxOfMin = min;
                }
            }

            // Print max of min for current window size
            System.out.print(maxOfMin + " ");
        }
    }

    public static void main(String args[]) {
        printMaxOfMin(arr.length);
    }

}
