/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp;

/**
 *
 * @author djoshi
 */
public class AssemblyLineScheduling {

    static int NUM_LINE = 2;
    static int NUM_STATION = 4;

    static int carAssembly(int a[][], int t[][], int e[], int x[]) {
        int i;
        int T1[] = new int[NUM_STATION];
        int T2[] = new int[NUM_STATION];

        T1[0] = e[0] + a[0][0]; // time taken to leave first station in line 1
        T2[0] = e[1] + a[1][0]; // time taken to leave first station in line 2

        // Fill tables T1[] and T2[] using the above given recursive relations
        for (i = 1; i < NUM_STATION; ++i) {
            T1[i] = Math.min(T1[i - 1] + a[0][i], T2[i - 1] + t[1][i] + a[0][i]);
            T2[i] = Math.min(T2[i - 1] + a[1][i], T1[i - 1] + t[0][i] + a[1][i]);
        }

        // Consider exit times and retutn minimum
        return Math.min(T1[NUM_STATION - 1] + x[0], T2[NUM_STATION - 1] + x[1]);
    }

    public static void main(String args[]) {
        int a[][] = { {4, 5, 3, 2},
                      {2, 10, 1, 4} };
        int t[][] = { {0, 7, 4, 5},
                      {0, 9, 2, 8} };
        int e[] = { 10, 12 };
        int x[] = { 18, 7 };

        System.out.println(carAssembly(a, t, e, x));
    }

}
