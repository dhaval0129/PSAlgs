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
 * http://www.geeksforgeeks.org/rotate-matrix-elements/
 *
 * Rotate Matrix Elements in Matrix ( clock-wise by 1 )
 *
 */
public class RotateElements {

    private static final int rows = 4;
    private static final int cols = 4;

    private static void rotateMatrix(int m, int n, int[][] matrix) {
        int row = 0, col = 0;
        int prev, curr;
        /*
            row - Staring row index
            m - ending row index
            col - starting column index
            n - ending column index
            i - iterator
         */

        while (row < m && col < n) {
            // if both new row and new column values are size 
            // original m  rows and n cols then exit loop
            if (row + 1 == m || col + 1 == n) {
                break;
            }

            // Store the first element of next row, this element will
            // replace first element of current row
            prev = matrix[row + 1][col];

            // Move elements of first row from the remaining rows
            // Here row is constant and column is moving
            for (int i = col; i < n; i++) {
                curr = matrix[row][i];
                matrix[row][i] = prev;
                prev = curr;
            }
            row++; // increment to next new row

            // Move elements of last column from the remaining columns
            // Here column is constant and row is incremented
            for (int i = row; i < m; i++) {
                curr = matrix[i][n - 1];
                matrix[i][n - 1] = prev;
                prev = curr;
            }
            n--; // decrement the original column value

            // Move elements of last row from remaining rows
            // Here is row is constant and column is decremented
            if (row < m) {
                for (int i = n - 1; i >= col; i--) {
                    curr = matrix[m - 1][i];
                    matrix[m - 1][i] = prev;
                    prev = curr;
                }
            }
            m--; // decrement the original row value

            // Move elements of first column from remaining rows
            if (col < n) {
                for (int i = m - 1; i >= row; i--) {
                    curr = matrix[i][col];
                    matrix[i][col] = prev;
                    prev = curr;
                }
            }
            col++; // increment to next new column

            // now keep continouing like this for internal top row, 
            // right column, bottom row and left column 
        }

        // Print rotated matrix
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int a[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        rotateMatrix(rows, cols, a);
    }
}
