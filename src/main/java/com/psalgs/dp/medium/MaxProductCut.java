/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp.medium;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-36-cut-a-rope-to-maximize-product/
 *
 * http://www.techiedelight.com/maximum-product-rod-cutting/
 *
 * Maximum Product Cutting
 *
 * Given product of length n and value n, cut the product in such way that it
 * maximize profit
 *
 */
public class MaxProductCut {

    private static int maxProductCut_Rec(int n) {
        // base cases
        if (n == 0 || n == 1) {
            return 0;
        }

        // Make a cut at different palces and take the maximum of all
        int max_val = n;

        for (int i = 1; i < n; i++) {
            max_val = Math.max(max_val, i * maxProductCut_Rec(n - i));
        }
        return max_val;
    }

    // Time Complexity O(n)
    private static int maxProductCut_DP(int n) {
        if (n == 2 || n == 3) {
            return (n - 1);
        }

        int res = 1;
        while (n > 4) {
            n -= 3;
            res *= 3;
        }
        return (n * res);
    }

    public static void main(String args[]) {
        System.out.println("Maximum Product is " + maxProductCut_DP(10));
    }
}
