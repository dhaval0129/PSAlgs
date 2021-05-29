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
 * http://www.geeksforgeeks.org/magic-square-even-order/
 *
 * Magic Square | Even Order
 *
 * Time Complexity: O(n ^ 2)
 *
 */
public class MagicSquareEven {

    private static void doublyEven(int n) {
        int[][] arr = new int[n][n];

        // filling matrix with its count value starting from 1
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = (n * i) + j + 1;
            }
        }

        // change value of Array elements
        // at fix location as per rule 
        // (n*n+1)-arr[i][j]
        
        // Top Left corner of Matrix (order (n/4)*(n/4))
        for(int i = 0; i < n / 4; i++) {
            for(int j = 0; j < n / 4; j++) {
                arr[i][j] = (n * n + 1) - arr[i][j];
            }
        }

        // Top Right corner of Matrix (order (n/4)*(n/4))
        for(int i = 0; i < n / 4; i++) {
            for(int j = 3 * (n / 4); j < n; j++) {
                arr[i][j] = (n * n + 1) - arr[i][j];
            }
        }

        // Bottom Left corner of Matrix (order (n/4)*(n/4))
        for(int i = 3 * n / 4; i < n; i++) {
            for(int j = 0; j < n / 4; j++) {
                arr[i][j] = (n * n + 1) - arr[i][j];
            }
        }

        // Bottom Right corner of Matrix (order (n/4)*(n/4))
        for(int i = 3 * n / 4; i < n; i++) {
            for(int j = 3 * n / 4; j < n; j++) {
                arr[i][j] = (n * n + 1) - arr[i][j];
            }
        }

        // Centre of Matrix (order (n/2)*(n/2))
        for(int i = n / 4; i < 3 * n / 4; i++) {
            for(int j = n / 4; j < 3 * n / 4; j++) {
                arr[i][j] = (n * n + 1) - arr[i][j];
            }
        }

        // Printing the magic-square
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int n = 8;
//        int n = 4;
        doublyEven(n);
    }
}
