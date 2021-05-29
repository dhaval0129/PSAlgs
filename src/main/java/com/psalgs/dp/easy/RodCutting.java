/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp.easy;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 *
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CuttingRod.java
 *
 * https://www.youtube.com/watch?v=IRwVmTmN6go
 *
 * Cut the rod in such a way that it will get the maximum price
 *
 * Time Complexity O( n ^ 2 )
 */
public class RodCutting {

    // Recursion technique
    private static int cutRod_Rec(int price[], int n) {
        if (n <= 0) {
            return 0;
        }

        int max_value = Integer.MIN_VALUE;
        // Recursively cut the rod in different pieces and
        // compare different configurations
        for (int i = 0; i < n; i++) {
            max_value = Math.max(max_value,
                    price[i] + cutRod_Rec(price, n - i - 1));
        }
        return max_value;
    }

    // Dynamic progamming technique
    private static int cutRod_DP(int price[], int n) {
        int value[] = new int[n + 1];
        value[0] = 0;

        for (int i = 1; i <= n; i++) {
            int max_value = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max_value = Math.max(max_value, price[j] + value[i - j - 1]);
            }
            value[i] = max_value;
        }
        return value[n];
    }

    public static void main(String args[]) {
//        int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int arr[] = {2, 5, 7, 8};
        int size = arr.length;
//        System.out.println("Maximum Obtainable Value is: " + cutRod_Rec(arr, size));
        System.out.println("Maximum Obtainable Value is: " + cutRod_DP(arr, size));
    }
    
// Trace
//    i = 1, j = 0      
//        value = 0, 2
//    
//    i = 2, j = 0
//        max = 4
//        j = 1
//        max (4,5)
//        value = 0,2,5
//    
//    i = 3, j = 0
//        max = 7
//        j =1
//        max (7,7) = 7
//        j = 2
//        max (7, 7) = 7
//        value = 0,2,5,7
//                
//   i = 4, j = 0
//        max = 7
//        j = 1
//        max (7, 10) = 10
//        j = 2
//        max (10, 9) = 10
//        j = 3
//        max(10, 8) = 10
//        value = 0,2,5,7,10
}
