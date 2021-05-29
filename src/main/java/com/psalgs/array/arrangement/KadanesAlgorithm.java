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
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 *
 * Largest Sum Contiguous Sub-array ( Kadane's Algorithm )
 *
 * Time Complexity O(n)
 * 
 */
public class KadanesAlgorithm {

    private static int maxSubArraySum(int[] a) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here += a[i];
            
            if(max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }
            
            if(max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        
        return max_so_far;
    }

    public static void main(String args[]) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
    }

}
