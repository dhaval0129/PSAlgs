/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp;

/**
 *
 * @author djoshi
 *
 * Reference: http://www.geeksforgeeks.org/tiling-problem/
 *
 * https://www.careercup.com/question?id=5940697714655232
 *
 * Let “count(n)” be the count of ways to place tiles on a “2 x n” grid, we have
 * following two ways to place first tile.
 *
 * 1) If we place first tile vertically, the problem reduces to “count(n-1)” 2)
 * If we place first tile horizontally, we have to place second tile also
 * horizontally. So the problem reduces to “count(n-2)”
 */
public class TilingProblem {

    static int tilePlacementWays(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        while (n > 0) {
            int tmp = b;
            b = a + b;
            a = tmp;
            --n;
        }

        return b;
    }

    static long tilings(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        long prev = 1;
        long cur = 2;

        for (int i = 3; i <= n; i++) {
            cur += prev;
            prev = cur - prev;
        }

        return cur;
    }

    public static void main(String args[]) {

        for (int i = 1; i <= 10; i++)
            System.out.print(tilePlacementWays(i) + " ");        
        System.out.println();
        int n = 4;
        System.out.println("Tiling Problem: 2x" + n + " Answer: " + tilings(n));
    }

}
