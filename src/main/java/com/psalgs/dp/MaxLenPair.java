/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp;

/**
 *
 * @author djoshi
 *
 * (Maximum Length Chain of Pairs)
 *
 * Reference:
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-20-maximum-length-chain-of-pairs/
 *
 */
public class MaxLenPair {

    int a;
    int b;

    public MaxLenPair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    static int MaxLenPair(MaxLenPair arr[], int n) {
        int i, j, max = 0;
        int mcl[] = new int[n];

        /* Initialize MCL (max chain length) values for all indexes */
        for (i = 0; i < n; i++) {
            mcl[i] = 1;
        }

        /* Compute optimized chain length values in bottom up manner */
        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (arr[i].a > arr[j].b && mcl[i] < mcl[j] + 1) {
                    mcl[i] = mcl[j] + 1;
                }
            }
        }

        // mcl[i] now stores the maximum chain length ending with pair i
        /* Pick maximum of all MCL values */
        for (i = 0; i < n; i++) {
            if (max < mcl[i]) {
                max = mcl[i];
            }
        }

        return max;
    }

    public static void main(String args[]) {
        MaxLenPair arr[] = new MaxLenPair[]{new MaxLenPair(5, 24), new MaxLenPair(15, 25),
            new MaxLenPair(27, 40), new MaxLenPair(50, 60)};
        System.out.println("Length of maximum size chain is "+ MaxLenPair(arr, arr.length));
    }

}
