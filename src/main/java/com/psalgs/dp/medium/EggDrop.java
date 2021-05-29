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
 * http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 *
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/EggDropping.java
 * 
 * https://www.youtube.com/watch?v=KVfxgpI3Tv0
 *
 * https://www.youtube.com/watch?v=3hcaVyX00_4
 *
 * Egg Dropping Puzzle
 *
 * Given some number of floors and some number of eggs, what is the minimum
 * number of attempts it will take to find out from which floor egg will break.
 *
 */
class EggDrop {

    private static int eggDrop_Rec(int eggs, int floors) {
        if (eggs == 1) {
            return floors;
        }
        if (floors == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        // Consider all droppings from 1st floor to kth floor and 
        // return the minimum of these values plus 1. 
        for (int i = 1; i <= floors; i++) {

            // max for highest floor
            int val = 1 + Math.max(
                    eggDrop_Rec(eggs - 1, i - 1), // eggs breaks and we go to one lower floor
                    eggDrop_Rec(eggs, floors - i)); // egg does not break and we go to lower ith floor lower

            // minimum no. of attempts
            if (val < min) {
                min = val;
            }
        }
        return min;
    }

    /**
     *
     * @param n // total eggs
     * @param k // total floors
     * @return
     *
     * Function to get minimum number of trials needed in worst case with n eggs
     * and k floors
     */
    private static int eggDrop_DP(int n, int k) {
        /* A 2D table where entery eggFloor[i][j] will represent minimum
       number of trials needed for i eggs and j floors. */
        int eggFloor[][] = new int[n + 1][k + 1];
        int res;
        int i, j, x;

        // We need one trial for one floor and 0 trials for 0 floors
        for (i = 1; i <= n; i++) {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }

        // We always need j trials for one egg from jth floors.
        for (j = 1; j <= k; j++) {
            eggFloor[1][j] = j;
        }

        // Fill rest of the entries in table using optimal substructure property
        for (i = 2; i <= n; i++) { // no. of eggs
            for (j = 2; j <= k; j++) { // no. of floors
                eggFloor[i][j] = Integer.MAX_VALUE;

                for (x = 1; x <= j; x++) {  // start with first floor to xth current floor
                    res = 1 + Math.max(
                            eggFloor[i - 1][x - 1], // check result for same floor for last egg
                            eggFloor[i][j - x]);    // check result for last jth floor for current egg

                    if (res < eggFloor[i][j]) {
                        eggFloor[i][j] = res;
                    }
                }
            }
        }
        // eggFloor[n][k] holds the result
        return eggFloor[n][k];

    }

    public static void main(String args[]) {
        int n = 2;  // Total no. of eggs 
        int k = 10; // Total no. of floors

        System.out.println("Minimum number of trials in worst case with " + n + " eggs and " + k
                + " floors is " + eggDrop_DP(n, k));
    }
}
