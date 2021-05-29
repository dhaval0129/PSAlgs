/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.misc;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/recursively-print-all-sentences-that-can-be-formed-from-list-of-word-lists/
 *
 * Recursively print all sentences that can be formed from list of word lists 
 * (backtracking example )
 */
public class RecursiveSentences {

    private static int R;
    private static int C;

    // A recursive function to print all possible sentences that can be formed
    // from a list of word list
    private static void printUtil(String arr[][], int m, int n, String[] output) {
        // Add current word to output array
        output[m] = arr[m][n];

        // If this is last word of current output sentence, then print the output sentence
        if (m == R - 1) {
            for (int i = 0; i < R; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }

        // Recur to next row
        for (int i = 0; i < C; i++) {
            if (arr[0][i] != null && !arr[m + 1][i].equals("")) {
                printUtil(arr, m + 1, i, output);
            }
        }
    }

    private static void print(String[][] arr) {
        R = arr.length;
        C = arr[0].length;
        String[] output = new String[R];

        //consider all words for first row as starting points and print all sentances 
        for (int i = 0; i < C; i++) {
            if (arr[0][i] != null && !arr[0][i].equals("")) {
                printUtil(arr, 0, i, output);
            }
        }
    }

    public static void main(String args[]) {
        String arr[][] = {{"you", "we"},
                          {"have", "are"},
                          {"sleep", "eat"}
                        };
        print(arr);
    }
}
