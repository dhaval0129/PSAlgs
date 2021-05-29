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
 * http://www.geeksforgeeks.org/lexicographic-rank-of-a-string/
 *
 * Lexicographic rank of a string
 *
 * Time Complexity O(n^2)
 */
public class LexicographicRank {

    // A utility function to find factorial of n
    private static int fact(int n) {
        return (n <= 1) ? 1 : n * fact(n - 1);
    }

    // A utility function to count smaller 
    // characters on right of arr[low]
    private static int findSmallerInRight(String str, int low,
            int high) {
        int countRight = 0, i;

        for (i = low + 1; i <= high; ++i) {
            if (str.charAt(i) < str.charAt(low)) {
                ++countRight;
            }
        }

        return countRight;
    }

    private static int findRank(String str) {
        int len = str.length();
        int mul = fact(len);
        int rank = 1;
        int countRight;

        for (int i = 0; i < len; i++) {
            mul /= len - i;

            // count number of chars smaller 
            // than str[i] from str[i+1] to
            // str[len-1]
            countRight = findSmallerInRight(str, i, len - 1);

            rank += countRight * mul;
        }
        return rank;
    }

    public static void main(String args[]) {
        String str = "string";
        System.out.println(findRank(str));
    }
}
