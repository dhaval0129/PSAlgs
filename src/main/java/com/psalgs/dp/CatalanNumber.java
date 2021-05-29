/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp;

/**
 *
 * @author djoshi
 */
public class CatalanNumber {

    static int catalan_rec(int n) {
        int res = 0;

        // Base case
        if (n <= 1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            res += catalan_rec(i) * catalan_rec(n - i - 1);
        }
        return res;
    }

    static int catalan_dp(int n) {
        int catalan[] = new int[n + 1];
        catalan[0] = catalan[1] = 1;

        for (int i = 2; i <= n; i++) {

            for (int j = 0; j < i; j++) {
                catalan[i] = catalan[j] + catalan[i - j - 1];
            }
        }

        return catalan[n];
    }

    public static void main(String args[]) {
        for (int i = 0; i < 10; i++) {
            System.out.print(catalan_rec(i) + " ");
        }
        System.out.println();
    }

}
