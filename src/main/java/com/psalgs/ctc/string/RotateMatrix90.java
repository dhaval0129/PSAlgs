/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.ctc.string;

/**
 *
 * @author djoshi
 *
 * Given an image represented by an NxN matrix, where each pixel in the image is
 * 4 bytes, write a method to rotate the image by 90 degrees.
 *
 * Can you do this in place ?
 *
 * https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
 * 
 * Rotate 180 degrees ( transpose and reverse matrix solutions)
 * 
 * https://www.geeksforgeeks.org/rotate-matrix-90-degree-without-using-extra-space-set-2/
 *
 */
public class RotateMatrix90 {

    private static void rotateMatrix(int N, int mat[][]) {

        // Consider all squares one by one 
        for (int x = 0; x < N / 2; x++) {

            // Consider elements in group 
            // of 4 in current square
            for (int y = x; y < N - 1 - x; y++) {

                // store top left cell in temp
                int temp = mat[x][y];

                // copy top right cell in top left cell
                mat[x][y] = mat[y][N - x - 1];

                // copy bottom right cell to top right cell
                mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y];

                // copy bottom left cell to bottom right cell
                mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];

                // copy bottom temp value stored from top left cell 
                // to bottom left cell
                mat[N - 1 - y][x] = temp;
            }

        }

    }

    private static void displayMatrix(int N, int mat[][]) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String args[]) {

        int N = 4;

        int mat[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        rotateMatrix(N, mat);

        displayMatrix(N, mat);
    }

}
