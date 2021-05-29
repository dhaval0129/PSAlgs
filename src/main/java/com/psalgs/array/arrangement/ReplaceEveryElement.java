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
 * http://www.geeksforgeeks.org/replace-every-array-element-by-multiplication-of-previous-and-next/
 *
 * Replace every array element by multiplication of previous and next
 *
 */
public class ReplaceEveryElement {

    private static int[] modify(int[] arr, int n) {
        int temp[] = new int[n];
        
        for (int i = 0; i < n; i++) {
            int prev;
            int next;

            if (i == 0) {
                prev = arr[i];
                next = arr[i + 1];
            } else if (i == n - 1) {
                prev = arr[i - 1];
                next = arr[i];
            } else {
                prev = arr[i - 1];
                next = arr[i + 1];
            }
            temp[i] = prev * next;
        }
        
        return temp;
    }

    public static void main(String args[]) {
        int arr[] = {2, 3, 4, 5, 6};
        int n = arr.length;
        arr = modify(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}
