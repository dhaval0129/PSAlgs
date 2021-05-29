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
 * http://www.geeksforgeeks.org/program-print-lower-triangular-upper-triangular-matrix-array/
 *
 * Program to print Lower triangular and Upper triangular matrix of an array
 *
 */
public class LowerUppertriangular {

    private static void lower(int matrix[][], int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i < j) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void upper(int matrix[][], int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i > j) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int matrix[][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int row = 3, col = 3;
        System.out.println("Lower triangular matrix: ");
        lower(matrix, row, col);
        System.out.println("");
        System.out.println("Upper triangular matrix: ");
        upper(matrix, row, col);
    }
}
