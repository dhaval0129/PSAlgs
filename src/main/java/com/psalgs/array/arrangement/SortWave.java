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
 * http://www.geeksforgeeks.org/sort-array-wave-form-2/
 *
 * Given an unsorted array of integers, sort the array into a wave like array
 *
 * 1] sort and array 2] swap alternate values between i and i+1
 */
public class SortWave {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void sortWave(int arr[], int n) {
        // sort
        Arrays.sort(arr);

        // swap
        for (int i = 0; i < n - 1; i += 2) {
            swap(arr, i, i + 1);
        }
    }

    public static void main(String args[]) {
        int arr[] = {10, 90, 49, 2, 1, 5, 23};
        int n = arr.length;
        sortWave(arr, n);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
