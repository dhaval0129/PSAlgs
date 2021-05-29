/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.statistics;

import java.util.Arrays;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/k-th-smallest-absolute-difference-two-elements-array/
 *
 * k-th smallest absolute difference of two elements in an array
 *
 */
public class kSmallesAbsDiff {

    private static int countPairs(int[] a, int n, int mid) {
        int res = 0;
        for (int i = 0; i < n; ++i) {
            // Upper bound returns pointer to position of 
            // next higher number than a[i]+mid in
            // a[i..n-1]. We subtract (a + i + 1) from this position to count

        }

        return res;
    }

    private static int kthDiff(int[] a, int n, int k) {
        // sort array incase it is not sorted
        Arrays.sort(a);

        // minimum absolute difference 
        int low = a[1] - a[0];
        for (int i = 1; i < n - 2; i++) {
            low = Math.min(low, a[i + 1] - a[i]);
        }

        // maximum absoulute difference 
        int high = a[n - 1] - a[0];

        // Do binary search for k-th abolute difference
        while (low < high) {
            // this is similar to (low + high )/2 and (low + (high - low)/2))
            int mid = (low + high) >> 1;

            if (countPairs(a, n, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String args[]) {
        int k = 3;
        int a[] = {1, 2, 3, 4};
        int n = a.length;

        System.out.println(kthDiff(a, n, k));
    }
}
