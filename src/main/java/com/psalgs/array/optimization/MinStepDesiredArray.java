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
 * http://www.geeksforgeeks.org/count-minimum-steps-get-given-desired-array/
 *
 * Count minimum steps to get the given desired array
 *
 */
public class MinStepDesiredArray {

    private static int arr[] = {16, 16, 16};

    private static int countMinOperations(int n) {
        int result = 0;

        while (true) {
            // store count of zeroes in current array
            int zero_count = 0;

            int i;
            for (i = 0; i < n; i++) {
                // If odd number found
                if (arr[i] % 2 == 1) {
                    break;
                } else if (arr[i] == 0) {
                    zero_count++;
                }
            }

            // All numbers are 0
            if (zero_count == n) {
                return result;
            }

            // All numbers are even
            if (i == n) {
                // Divide the whole array by 2 and increment result
                for (int j = 0; j < n; j++) {
                    arr[j] = arr[j] / 2;
                }
                result++;
            }

            // Make all odd numbers even by substracting one and increment result
            for (int j = i; j < n; j++) {
                if (arr[j] % 2 == 1) {
                    arr[j]--;
                    result++;
                }
            }
        }
    }

    public static void main(String args[]) {
        System.out.println("Minimum number of steps required to "
                + "get the given target array is " + countMinOperations(arr.length));
    }
}
