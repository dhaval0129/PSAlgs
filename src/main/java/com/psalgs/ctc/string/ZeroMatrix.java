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
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column are set to 0
 *
 * https://www.geeksforgeeks.org/a-boolean-matrix-question/
 *
 *
 */
public class ZeroMatrix {

    public static void modifyMatrix(int mat[][]) {
        int R = mat.length;
        int C = mat[0].length;
        
        int row[] = new int[R];
        int col[] = new int[C];
        int i, j;

        /* Initialize all values of row[] as 0 */
        for (i = 0; i < R; i++) {
            row[i] = 1;
        }

        /* Initialize all values of col[] as 0 */
        for (i = 0; i < C; i++) {
            col[i] = 1;
        }

        /* Store the rows and columns to be marked as 
        1 in row[] and col[] arrays respectively */
        for (i = 0; i < R; i++) {
            for (j = 0; j < C; j++) {
                if (mat[i][j] == 0) {
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }

        /* Modify the input matrix mat[] using the 
        above constructed row[] and col[] arrays */
        for (i = 0; i < R; i++) {
            for (j = 0; j < C; j++) {
                if (row[i] == 0 || col[j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }
    }

    /* A utility function to print a 2D matrix */
    public static void printMatrix(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String args[]) {
        int mat[][] = {
            {0, 1, 1, 0},
            {1, 1, 0, 1},
            {1, 1, 1, 1}
        };

        System.out.println("Input Matrix :");
        printMatrix(mat);

        modifyMatrix(mat);

        System.out.println("Matrix After Modification :");
        printMatrix(mat);
    }
}
