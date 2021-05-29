/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.binary;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/
 *
 * Count number of binary strings without consecutive 1’s
 *
 */
public class NonConsecutive1s {

    private static int countStrings(int n) {
        int[] a = new int[n];
        int[] b = new int[n];
        a[0] = b[0] = 1;

        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }

        return a[n - 1] + b[n - 1];
    }

    public static void main(String args[]) {
        System.out.println(countStrings(3));
    }
}
