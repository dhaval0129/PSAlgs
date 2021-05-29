/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.misc;

import java.util.Arrays;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/transform-one-string-to-another-using-minimum-number-of-given-operation/
 *
 * Transform One String to Another using Minimum Number of Given Operation
 *
 * Time Complexity: O(n)
 */
public class TransformString {

    private static int minOps(String A, String B) {
        int m = A.length();
        int n = B.length();

        if (n != m) {
            return -1;
        }

        int[] count = new int[128];
        Arrays.fill(count, -1);

        for (int i = 0; i < n; i++) {
            count[B.charAt(i)]++;
        }
        for (int j = 0; j < m; j++) {
            count[A.charAt(j)]++;
        }

        // If there is any character which is different
        for (int i = 0; i < 128; i++) {
            if (count[i] == 0) {
                return -1;
            }
        }

        // This part calculates the number of operations required
        int res = 0;
        for (int i = n - 1, j = n - 1; i >= 0;) {
            // If there is a mismatch, then keep incrementing
            // result 'res' until B[j] is not found in A[0..i]
            while (i >= 0 && A.charAt(i) != B.charAt(j)) {
                i--;
                res++;
            }
            //If A[i] and B[j] match then decrement 
            //the counters from end of string
            if (i >= 0) {
                i--;
                j--;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        String A = "EACBD";
        String B = "EABCD";
        System.out.println("Minimum number of operations required is: " + minOps(A, B));
    }
}
