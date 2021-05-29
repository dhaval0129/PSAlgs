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
 * http://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
 *
 * In-place rotate square matrix by 90 degrees
 *
 * Time Complexity O(n/2 ^ n)
 * Space Complexity O(1)
 *
 */
public class Rotate90 {

    private static void rotateMatrix(int N, int matrix[][]) {
        // Consider all squares one by one
        // Since we are rotating end to end it will half the size at matrix
        for (int i = 0; i < N / 2; i++) {

            // Consider elements in group of 4 in current square            
            for (int j = i; j < N - i - 1; j++) {

                // store current cell in temp variable
                int temp = matrix[i][j];

                // move values from right to top
                matrix[i][j] = matrix[j][N - 1 - i];

                // move values from bottom to right
                matrix[j][N - 1 - i] = matrix[N - 1 - i][N - 1 - j];

                // move values from left to bottom
                matrix[N - 1 - i][N - 1 - j] = matrix[N - 1 - j][i];

                // assign temp to left
                matrix[N - 1 - j][i] = temp;
            }
        }
    }

    private static void displayMatrix(int N, int matrix[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int N = 4;

        // Test Case 1
        int matrix[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        // Tese Case 2
//        int mat[][] = {
//            {1, 2, 3},
//            {4, 5, 6},
//            {7, 8, 9}
//        };
        // Tese Case 3
//        int mat[][] = {
//            {1, 2},
//            {4, 5}
//        };
        rotateMatrix(N, matrix);

        // Print rotated matrix
        displayMatrix(N, matrix);
    }
}
