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
 * http://www.geeksforgeeks.org/?p=9755
 *
 * Find elements in array which are repeated only twice
 *
 */
public class TwoRepeating {

    private static void printRepeating(int arr[], int size) {
        int i;
        System.out.print("The repeating elements: ");

        for (i = 0; i < size; i++) {
            if (arr[Math.abs(arr[i])] >= 0) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            } else {
                System.out.print(Math.abs(arr[i]) + " ");
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 4, 5, 2, 3, 1};
        int n = arr.length;
        printRepeating(arr, n);
    }
}
