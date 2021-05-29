/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.optimization;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/find-minimum-number-of-merge-operations-to-make-an-array-palindrome/
 *
 * Find minimum number of merge operations to make an array palindrome
 *
 * Time Complexity O(n)
 */
public class PalindromeArray {

    private static int findMinOps(int[] arr, int n) {
        int ans = 0;

        for (int i = 0, j = n - 1; i <= j;) {
            // If corner elements are same,
            // problem reduces arr[i+1..j-1]
            if (arr[i] == arr[j]) {
                i++;
                j--;
            } else if (arr[i] > arr[j]) {
                // If left element is greater, then we merge right two elements
                j--;
                arr[j] += arr[j + 1];
                ans++;
            } else {
                // else we merge left two elements, since right is greater then left
                i++;
                arr[i] += arr[i - 1];
                ans++;
            }
        }
        
        return ans;
    }

    public static void main(String args[]) {
        int[] arr = {1, 4, 5, 9, 1};
        int n = arr.length;
        System.out.println("Count of minimum operations is: " + findMinOps(arr, n));
    }
}
