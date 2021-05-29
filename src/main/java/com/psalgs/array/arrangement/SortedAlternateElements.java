/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.arrangement;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/generate-all-possible-sorted-arrays-from-alternate-elements-of-two-given-arrays/
 *
 * Generate all possible sorted arrays from alternate elements of two given
 * sorted arrays
 *
 */
public class SortedAlternateElements {

    private static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void altSortUtil(int[] A, int[] B, int[] C, int i, int j,
            int m, int n, int len, boolean flag) {
        // i is len of array A
        // j is len of array B
        // flag is first set to true by default from earlier call
        // len is 0 initially
        
        if (flag) { // include valid element from A
            // print output if there is at least one 'B' in output array 'C'
            if (len != 0) {
                printArray(C, len + 1);
            }

            // Recur for all elements of A after current index
            for (int k = i; k < m; k++) {
                if (len == 0) {
                    /* this block works for the very first call to include
                    the first element in the output array */
                    C[len] = A[k];
                    // don't increment len as B is included yet
                    altSortUtil(A, B, C, k + 1, j, m, n, len, !flag);
                } else if (A[k] > C[len]) {
                    // include valid elements from A and recur
                    C[len + 1] = A[k];
                    altSortUtil(A, B, C, k + 1, j, m, n, len + 1, !flag);
                }
            }
        } else { // include valid element from B and recur
            for (int l = j; l < n; l++) {
                if (B[l] > C[len]) {
                    C[len + 1] = B[l];
                    altSortUtil(A, B, C, i, l + 1, m, n, len + 1, !flag);
                }
            }
        }
    }

    private static void altSort(int[] A, int[] B, int m, int n) {
        int[] C = new int[m + n]; // combined array length
        altSortUtil(A, B, C, 0, 0, m, n, 0, true);
    }

    public static void main(String args[]) {
        int[] A = {10, 15, 25};
        int[] B = {5, 20, 30};

        int m = A.length; // length of first array
        int n = B.length; // length of second array
        altSort(A, B, m, n);
    }
}
