/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.arrangement;

import java.util.Arrays;

/**
 *
 * @author djoshi
 *
 * Rearrange an array such that arr[i] = i
 *
 * https://www.geeksforgeeks.org/rearrange-array-arri/
 *
 */
public class RearrangeArray {

    public static int[] fix(int[] A) {

        int n = A.length;

        for (int i = 0; i < n; i++) {

            if (A[i] != -1 && A[i] != i) {

                int x = A[i];

                while (A[x] != -1 && A[x] != x) {

                    int y = A[x];
                    A[x] = x;
                    x = y;
                }

                A[x] = x;

                if (A[i] != i) {
                    A[i] = -1;
                }
            }
        }

        return A;
    }

    public static void main(String args[]) {
        int A[] = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        System.out.println(Arrays.toString(fix(A)));
    }
}
