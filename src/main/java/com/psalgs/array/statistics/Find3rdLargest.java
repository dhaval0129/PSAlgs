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
 * http://www.geeksforgeeks.org/find-the-largest-three-elements-in-an-array/
 *
 * Find the largest three elements in an array
 * 
 * Time Complexity O(n)
 *
 */
public class Find3rdLargest {

    private static void print2Largest(int[] arr, int n) {
        int first, second, third;

        if (n < 3) {
            System.out.println("Invalid input");
            return;
        }

        third = first = second = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            } else if (arr[i] > second) {
                third = second;
                second = arr[i];
            } else {
                third = arr[i];
            }
        }
        System.out.println("Three largest elements are " + first + " " + second + " " + third);
    }

    public static void main(String args[]) {
        int arr[] = {12, 13, 1, 10, 34, 1};
        int n = arr.length;
        print2Largest(arr, n);
    }
}
