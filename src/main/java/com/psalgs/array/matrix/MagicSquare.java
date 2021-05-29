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
 * http://www.geeksforgeeks.org/magic-square/
 *
 * Create magic square matrix.
 *
 * Magic square is one whose all values add up to same number horizontally and
 * vertically
 *
 * Formula to get magic number is: n * ((n * n + 1) / 2), If n = 3 then magic
 * number if 15
 * 
 * Time Complexity O(n ^ 2)
 */
public class MagicSquare {

    private static void generateSquare(int n) {
        int[][] magicSquare = new int[n][n];

        // Initialize position for num = 1
        int i = n / 2; // divide i / 2 ( 3/2 = 1)
        int j = n - 1; // decrement j - 1 ( 3-1 = 2)

        // If both values are out of bounds at same time reset them both
        // If one which above or equal to n bring to 0 or n - 2
        // If one which is lower than 0 bring to n - 1
        for (int num = 1; num <= n * n;) {

            // If values of both i and j are out of bounds then 
            // always decrement j by n - 2 and i = 0 
            if (i == -1 && j == n) {
                j = n - 2;
                i = 0;
            } else {
                // 1st condition helper if next number goes to out of square's right side
                // If only j is out of bounds then reset j = 0;
                if (j == n) {
                    j = 0;
                }
                // 1st condition helper if next number is goes to out of square's upper side
                // If i is out of bounds then rest i to n - 1;
                if (i < 0) {
                    i = n - 1;
                }
            }

            // If array cell already has value in it than decrement j by 2 and increment i by 1
            // continue to (i,j) cell no need to increment number, find appropriate cell for that number
            if (magicSquare[i][j] != 0) {
                j -= 2;
                i++;
                continue; // find right cell for this num
            } else {
                //set it to current number and increment the number
                magicSquare[i][j] = num++;
            }

            //finally go to next cell
            j++;
            i--;
        }

        // Print magic square
        System.out.println("The Magic Square for " + n + ":");
        System.out.println("Sum of each row or column: " + n * ((n * n + 1) / 2));

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(magicSquare[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int n = 3;
        generateSquare(n);
    }
}
