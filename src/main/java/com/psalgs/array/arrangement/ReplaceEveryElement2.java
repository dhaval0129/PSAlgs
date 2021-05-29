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
public class ReplaceEveryElement2 {

    private static void modify(int[] arr, int n) {
        int prev = arr[0];
        arr[0] = prev * arr[1];

        for (int i = 1; i < n - 1; i++) {
            int curr = arr[i];
            int next = arr[i + 1];
            arr[i] = prev * next;
            prev = curr;
        }

        arr[n - 1] = arr[n - 1] * prev;
    }

    public static void main(String args[]) {
        int arr[] = {2, 3, 4, 5, 6};
        int n = arr.length;
        modify(arr, n);

        System.out.println(Arrays.toString(arr));
    }
}
