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
 * http://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/
 *
 * Rearrangement positive and negative numbers in O(n) and O(1) extra space
 *
 * An array contains both positive and negative numbers in random order.
 * Rearrange the array elements so that positive and negative numbers are placed
 * alternatively. Number of positive and negative numbers need not be equal. If
 * there are more positive numbers they appear at the end of the array. If there
 * are more negative numbers, they too appear in the end of the array.
 *
 * Time Complexity O(n)
 * Space Complexity O(1)
 * 
 */
public class PosNegAlternate {

    private static void rearrange(int arr[], int n) {
        int i = -1;

        // here we move all negative numbers on left hand side
        // and positive number right hand side of array
        for (int j = 0; j < n; j++) {
            if (arr[j] < 0) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // we declare postive start counter which is ++i and negative start counter which is 0
        int pos = ++i, neg = 0;

        // now we move negative no. to alternate position
        // increment neg counter by 2 and positive by 1
        // swap values between arr[neg] and arr[pos]
        while (pos < n && neg < pos && arr[neg] < 0) {
            int temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            pos++;
            neg += 2;
        }
    }

    private static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]) {
        int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        int n = arr.length;
        rearrange(arr, n);
        System.out.println("Array after rearranging: ");
        printArray(arr, n);
    }
}
