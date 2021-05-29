/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.heap;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/how-to-check-if-a-given-array-represents-a-binary-heap/
 *
 * check if a given array represents a Binary Heap ( Max Heap )
 *
 */
public class ArrayIsHeap {

    private static boolean isHeap_Rec(int[] arr, int index, int n) {
        // Is leaf node
        if (index > (n - 2) / 2) {
            return true;
        }

        // If an internal node and is greater than its children, and
        // same is recursively true for the children
        if (arr[index] >= arr[2 * index + 1] && arr[index] >= arr[2 * index + 2]
                && isHeap_Rec(arr, 2 * index + 1, n) && isHeap_Rec(arr, 2 * index + 2, n)) {
            return true;
        }

        return false;
    }

    private static boolean isHeap_Itr(int[] arr,int n) {
        // Start from root and go till the last internal node
        // convert equation 2*i+1=n to i=(n-1)/2 and 2*i+2=n to i=(n-2)/2
        for (int i = 0; i <= (n - 2) / 2; i++) {
            // If left child is greater, return false
            if (arr[2 * i + 1] > arr[i]) {
                return false;
            }

            // If right child is greater, return false
            if (arr[2 * i + 2] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int arr[] = {90, 15, 10, 7, 12, 2, 7, 3};
        int n = arr.length;

        if (isHeap_Itr(arr, n - 1)) {
            System.out.println("Array is heap");
        } else {
            System.out.println("Is not heap");
        }
    }
}
