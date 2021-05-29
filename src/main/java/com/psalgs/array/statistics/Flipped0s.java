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
 * http://www.geeksforgeeks.org/find-zeroes-to-be-flipped-so-that-number-of-consecutive-1s-is-maximized/
 *
 * https://www.careercup.com/question?id=5106425965576192
 *
 * Find zeroes to be flipped so that number of consecutive 1’s is maximized.
 *
 * Hint: Increase the sliding windows and keep tracks of zeros and start & end
 * indexes
 *
 * Time Complexity: O(n)
 */
public class Flipped0s {

    // m is maximum no. of zeroes allowed to be flipped
    private static void findZeroes(int[] arr, int m) {
        int n = arr.length;

        // Left and Right indexes of current window
        int wL = 0, wR = 0;

        // Left start index of best windows and size of sliding widest window
        int bestL = 0, bestWindow = 0;

        // Count of zeroes in current window
        int zeroCount = 0;

        // While right boundary of current window does't cross right end
        while (wR < n) {
            // If zero count of current window is less than m, widen the windows toward right
            if (zeroCount <= m) {
                if (arr[wR] == 0) {
                    zeroCount++;
                }
                wR++;
            }

            // If zero count of current window is more than m, reduce the window from left
            if (zeroCount > m) {
                if (arr[wL] == 0) {
                    zeroCount--;
                }
                wL++;
            }

            // Update widest window if this window size is more
            if (wR - wL > bestWindow) {
                bestWindow = wR - wL;
                bestL = wL;
            }
        }

        // Print positions of zeroes in the widest window
        for (int i = 0; i < bestWindow; i++) {
            if (arr[bestL + i] == 0) {
                System.out.print(bestL + i + " ");
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
        int m = 2; // maximum no. of zeros allowed to be flipped
        System.out.print("Indexes of zeroes to be flipped are: ");
        findZeroes(arr, m);
        System.out.println();
    }
}
