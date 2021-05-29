/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.statistics;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
 *
 * Longest Increasing Subsequence Size
 *
 * Time Complexity: (N log N)
 *
 */
public class LIS2 {

    private static int CeilIndex(int[] table, int l, int h, int key) {
        
        while (l < h) {
            int m = (l + h) / 2;
            // value at mid is less then key
            if (table[m] < key) {
                // increase l to mid + 1
                l = m + 1;
            } else {
                // values at mid greater or equal then key
                h = m;
            }
        }

        return h;
    }

    private static int LIS2(int[] A, int n) {
        int[] tailTable = new int[n];
        int len; 

        tailTable[0] = A[0];
        len = 1;

        for (int i = 1; i < n; i++) {
            if (A[i] < tailTable[0]) {
                // new smallest value.
                tailTable[0] = A[i];
            } else if (A[i] > tailTable[len - 1]) {
                // A[i] wants to extend largest subsequence.
                tailTable[len++] = A[i];
            } else {
                // A[i] wants to be current end candidate of an existing subsequence.
                // It will replace ceil value in tailTable.
                tailTable[CeilIndex(tailTable, 0, len - 1, A[i])] = A[i];
            }
        }

        return len;
    }

    public static void main(String args[]) {
        int A[] =  {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int n = A.length;
        System.out.println("Length of Longest Increasing Subsequence is " + LIS2(A, n));
    }
}
