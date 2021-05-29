/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp;

/**
 *
 * Count number of ways to reach a given score in a game
 *
 * @author djoshi
 *
 * Reference:
 * http://www.geeksforgeeks.org/count-number-ways-reach-given-score-game/
 */
public class ReachScore {

    static int countScore_DP(int n) {
        int[] table = new int[n + 1];

        // Base case (If given value is 0)
        table[0] = 1;

        // One by one consider given 3 moves and update the table[]
        // values after the index greater than or equal to the
        // value of the picked move
        // One by one consider given 3 moves and update the table[]
        // values after the index greater than or equal to the
        // value of the picked move
        for (int i = 3; i <= n; i++) {
            table[i] += table[i - 3];
        }
        for (int i = 5; i <= n; i++) {
            table[i] += table[i - 5];
        }
        for (int i = 10; i <= n; i++) {
            table[i] += table[i - 10];
        }

        return table[n];
    }

    public static void main(String args[]) {
        int n = 20;
        System.out.println("(Dynamic Programming) score: " + countScore_DP(n));
    }
}
