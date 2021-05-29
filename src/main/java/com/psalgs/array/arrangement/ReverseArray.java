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
 * http://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
 * 
 * Write a program to reverse an array or string
 * 
 * O(n / 2)
 * 
 */
public class ReverseArray {

    private static void reverseArray_Rec(int arr[], int start, int end) {

        if (start <= end) {
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray_Rec(arr, ++start, --end);
    }

    private static void reverseArray_Itr(int[] arr, int start, int end) {
        int len = arr.length;

        for (int i = start; i < (len / 2); ++i, --end) {
            int temp = arr[i];
            arr[i] = arr[end];
            arr[end] = temp;
        }
    }

    private static void printArray(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        printArray(arr, 6);
        reverseArray_Itr(arr, 0, arr.length - 1);
        System.out.println("Reverse array is ");
        printArray(arr, 6);
    }
}
