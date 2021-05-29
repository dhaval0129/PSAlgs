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
 * http://www.geeksforgeeks.org/find-the-first-missing-number/
 *
 * Find the smallest missing number. ( Hint: Use Binary Search )
 *
 * Time Complexity: O(Log (n))
 *
 */
public class SmallestMissingNumber {

    private int findFirstMissing(int arr[], int start, int end) {
        if (start > end) {
            return end + 1;
        }

        if (start != arr[start]) {
            return start;
        }

        int mid = (start + end) / 2;
        
        // Left half has all elements from 0 to mid
        // Left half has all elements from 0 to mid
        if (arr[mid] == mid) {
            return findFirstMissing(arr, mid + 1, end);
        }
        
        return findFirstMissing(arr, start, mid);
    }

    public static void main(String[] args) {
        SmallestMissingNumber small = new SmallestMissingNumber();
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 10};
        int n = arr.length;
        System.out.println("First Missing element is : " + small.findFirstMissing(arr, 0, n - 1));
    }
}
