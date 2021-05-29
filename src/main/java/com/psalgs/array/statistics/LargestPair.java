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
 * http://www.geeksforgeeks.org/find-the-largest-pair-sum-in-an-unsorted-array/
 *
 * Find the largest pair sum in an unsorted array
 *
 * Time Complexity: O(n)
 */
public class LargestPair {

    private static int findLargestSumPair(int[] arr) {
        int first, second;
        int n = arr.length;

        if (arr[0] > arr[1]) {
            first = arr[0];
            second = arr[1];
        } else {
            first = arr[1];
            second = arr[2];
        }

        // Traverse remaining element find first and second largest elements in array
        for (int i = 2; i < n; i++) {
            //If current element is greater than first then update both first and second 
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }
        return (first + second);
    }

    public static void main(String args[]) {
        int[] arr = {12, 34, 10, 6, 40};
        System.out.println("Max Pair Sum is " + findLargestSumPair(arr));
    }
}
