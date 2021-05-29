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
 * http://www.geeksforgeeks.org/count-number-of-ways-to-cover-a-distance/
 *
 * Count number of ways to cover a distance
 *
 */
public class CoverDistance {

    private static int printCount_Rec(int dist) {
        // Base cases
        if (dist < 0) {
            return 0;
        }
        if (dist == 0) {
            return 1;
        }

        return printCount_Rec(dist - 1)
                + printCount_Rec(dist - 2)
                + printCount_Rec(dist - 3);

    }

    private static int printCount_DP(int dist, int[] arr) {
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= dist; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }

        return arr[dist];
    }

    public static void main(String args[]) {
        int dist = 4;
        int[] arr = new int[dist + 1];

//        System.out.println(printCount_Rec(dist));
        System.out.println(printCount_DP(dist, arr));
    }
}
