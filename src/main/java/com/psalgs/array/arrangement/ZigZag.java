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
 * http://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
 *
 * http://www.geeksforgeeks.org/converting-an-array-of-integers-into-zig-zag-fashion/
 *
 * Convert array into Zig-Zag fashion
 *
 * Hint: The converted array should be in form a < b > c < d > e < f.
 *
 * Time Complexity O(n) Space Complexity O(1)
 *
 */
public class ZigZag {

    private static int arr[] = {4, 3, 7, 8, 6, 2, 1};

    private static void zigZag() {
        int n = arr.length;
        boolean flag = true;
        int temp = 0;

        for (int i = 0; i < n - 1; i++) {
            if (flag) {
                // "<" relation expected 
                /* 
                   If we have a situation like A > B > C,
                   we get A > B < C by swapping B and C 
                 */
                if (arr[i] > arr[i + 1]) {
                    swap(i);
                }
            } else { // ">" relation expected
            /* 
                       If we have a situation like A < B < C,
                       we get A < C > B by swapping B and C 
             */ 
                if (arr[i] < arr[i + 1]) {
                    swap(i);
                }
            }
            flag = !flag;
        }
    }

    private static void swap(int k) {
        int temp = arr[k];
        arr[k] = arr[k + 1];
        arr[k + 1] = temp;
    }

    public static void main(String args[]) {
        zigZag();
        System.out.println(Arrays.toString(arr));
    }
}
