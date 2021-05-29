/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.matrix;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/
 *
 * Find row with Maximum 1s ( Each row in matrix is sorted )
 *
 * Hint: Do the binary search since row is sorted
 *
 * Time Complexity: O(m + n)
 * 
 */
public class RowMax1s {

    private static int first1s(int[] arr, int low, int high) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            // check if the element at middle index is first 1
            if ((mid == 0 || arr[mid - 1] == 0) && arr[mid] == 1) {
                return mid;
            } else if (arr[mid] == 0) {
                // if the element is 0, recur to right side
                return first1s(arr, mid + 1, high);
            } else {
                // If element is not first 1, recur to left side
                return first1s(arr, low, mid - 1);
            }
        }

        return -1;
    }

    // O(m*log(n))
    private static int rowWithMax1s(int[][] matrix) {
        // Initialize max values
        int max_row_index = 0, max = -1;
        int row = matrix.length;
        int cols = matrix[1].length;

        // Traverse for each row and count number of 1s by finding the index of first 1
        for (int i = 0; i < row; i++) {
            int index = first1s(matrix[i], 0, cols - 1);

            if (index != -1 && cols - index > max) {
                max = cols - index; 
                max_row_index = i;
            }
        }

        return max_row_index;
    }

    // O(m + n)
    private static int rowWithMax1s_Optimized(int[][] matrix) {
        // Initialize first row as row with max 1s
        int max_row_index = 0;
        int rows = matrix.length;
        int cols = matrix[1].length;

        // The function first() returns index of first 1 in row 0.
        // Use this index to initialize the index of leftmost 1 seen so far
        int j = first1s(matrix[0], 0, cols - 1);

        if (j == -1) {
            // if 1 is not present in first row
            j = cols - 1;
        }

        for (int i = 1; i < rows; i++) {

            // Move left until a 0 is found
            while (j >= 0 && matrix[i][j] == 1) {
                j = j - 1;  // Update the index of leftmost 1 seen so far
                max_row_index = i; // update max_row_index
            }
        }

        return max_row_index;
    }

    public static void main(String args[]) {
        int matrix[][] = {
            {0, 0, 0, 1},
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 0}
        };

        System.out.println("Index of row with maximum 1s is n: " + rowWithMax1s(matrix));
    }
}
