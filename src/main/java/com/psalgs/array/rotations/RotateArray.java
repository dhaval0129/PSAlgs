/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.rotations;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/array-rotation/
 *
 * Program for array rotation
 *
 * Time Complexity O(n + d), where n is size of array and d no of rotations
 */
public class RotateArray {

    private static void rotateArray(int[] arr, int d) {
        for (int i = 0; i < d; i++) {
            leftRotateByOne(arr, arr.length);
        }
    }

    private static void leftRotateByOne(int arr[], int n) {
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = temp;
    }

    private static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        rotateArray(arr, 2);
        printArray(arr);
    }
}
