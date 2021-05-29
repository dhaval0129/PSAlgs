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
 * http://www.geeksforgeeks.org/rotate-matrix-90-degree-without-using-extra-space-set-2/
 *
 * Transpose and Reverse the Matrix
 * 
 * To Rotate 90 degrees, first transpose and reverse matrix
 *
 */
public class TransposeReverse {

    private static void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {

                if (i == j) {
                    continue;
                }

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static void reverse(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[1].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j]  = temp;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    
    
    public static void main(String args[]) {
        int[][] arr = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        System.out.println("Transpose Matrix");
        transpose(arr);
        printMatrix(arr);
        System.out.println("\n\n Reverse Matrix");
        reverse(arr);
        printMatrix(arr);
    }
}
