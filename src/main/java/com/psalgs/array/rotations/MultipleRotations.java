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
 * http://www.geeksforgeeks.org/quickly-find-multiple-left-rotations-of-an-array/
 *
 * Quickly find multiple left rotations of an array
 * 
 * Time Complexity O(n)
 * Auxiliary Space : O (2n)
 */
public class MultipleRotations {

    private static void preprocess(int[] arr, int n, int[] temp) {
        for (int i = 0; i < n; i++) {
            temp[i] = temp[i + n] = arr[i];
        }
    }

    private static void leftRotate(int[] arr, int n, int k, int[] temp) {
        // Starting position of array after k
        // rotations in temp[] will be k % n
        int start = k % n;
        
        for(int i = start; i < start + n; i++){
            System.out.print(temp[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {1, 3, 5, 7, 9};
        int n = arr.length;

        int temp[] = new int[2 * n];
        preprocess(arr, n, temp);

        int k = 2;
        leftRotate(arr, n, k, temp);

        k = 3;
        leftRotate(arr, n, k, temp);

        k = 4;
        leftRotate(arr, n, k, temp);
    }
}
