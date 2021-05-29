/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.palindrome;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-28-minimum-insertions-to-form-a-palindrome/
 *
 * Minimum insertions to form a palindrome
 */
public class MinCharInsert {

    private static int findMinInsert_rec(char str[], int l, int h) {
        // base case
        if (l > h) {
            return Integer.MAX_VALUE;
        }
        if (l == h) {
            return 0;
        }
        if (l == h - 1) {
            return (str[l] == str[h] ? 0 : 1);
        }

        // Check if the first and last characters
        // are same. On the basis of the  comparison
        // result, decide which sub problem(s) to call
        return ( str[l] == str[h] ? findMinInsert_rec(str, l + 1, h - 1)
                : Integer.min( 
                findMinInsert_rec(str, l, h - 1),  findMinInsert_rec(str, l + 1, h) ) 
                + 1 );
    }

    private static int findMinInsert_DP(char str[], int n) {
        // Create a table of size n*n. table[i][j]
        // will store minumum number of insertions
        // needed to convert str[i..j] to a palindrome.
        int[][] table = new int[n][n];

        for (int gap = 1; gap < n; ++gap) {
            for (int l = 0, h = gap; h < n; ++l, ++h) {
                table[l][h] = (str[l] == str[h] ? table[l + 1][h - 1]
                        : Integer.min( table[l][h - 1], table[l + 1][h] ) 
                        + 1);
            }
        }
        // Return minimum number of insertions
        // for str[0..n-1]
        return table[0][n - 1];
    }

    public static void main(String args[]) {
        String str = "abcd";
//        System.out.println(findMinInsert_rec(str.toCharArray(), 0, str.length() - 1));
        System.out.println(findMinInsert_DP(str.toCharArray(), str.length()));
    }

}
