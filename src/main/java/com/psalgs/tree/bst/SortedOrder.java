/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bst;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/sorted-order-printing-of-an-array-that-represents-a-bst/
 *
 * Sorted order printing of a given array that represents a BST
 *
 * Time Complexity: O(n)
 *
 */
public class SortedOrder {

    private static void printSorted(int[] arr, int start, int end) {

        if (start > end) {
            return;
        }

        printSorted(arr, 2 * start + 1, end);

        System.out.print(arr[start] + " ");

        printSorted(arr, 2 * start + 2, end);
    }

    public static void main(String args[]) {
        int arr[] = {4, 2, 5, 1, 3};
        printSorted(arr, 0, arr.length - 1);
        System.out.println();
    }
}
