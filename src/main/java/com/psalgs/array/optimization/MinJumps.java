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
 * http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 *
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/MinJumpToReachEnd.java
 *
 * https://www.youtube.com/watch?v=cETfFsSTGJI
 *
 * https://www.youtube.com/watch?v=vBdo7wtwlXs
 * 
 * http://www.geeksforgeeks.org/minimum-number-jumps-reach-endset-2on-solution/
 *
 * Minimum number of jumps to reach end
 *
 * Time Complexity O(n)
 * 
 */
public class MinJumps {

    //O( 2 ^ n)
    private static int minJumps_Rec(int arr[], int l, int h) {
        // base case
        if (h == l) {
            return 0;
        }

        if (arr[l] == 0) {
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;
        for (int i = l + 1; i <= h && i <= l + arr[l]; i++) {

            int jumps = minJumps_Rec(arr, i, h);

            if (jumps != Integer.MAX_VALUE && jumps + 1 < min) {
                min = jumps + 1;
            }
        }

        return min;
    }

    // O(n ^ 2)
    private static int minJumps_DP(int arr[], int n) {
        int[] jump = new int[n]; // no. of jumps
        int[] result = new int[n]; // last jump from

        jump[0] = 0;

        for (int i = 1; i < arr.length; i++) {
            jump[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] + j >= i) {

                    if (jump[i] > jump[j] + 1) {
                        result[i] = j;
                        jump[i] = jump[j] + 1;
                    }
                }
            }
        }

        return jump[n - 1];
    }

    // O(n)
    private static int minJumps_Linear(int arr[], int n) {
        // base case 1
        if (n <= 1) {
            return 0;
        }
        // base case 2
        if(arr[0] == 0){
            return -1;
        }

        int ladder = arr[0];
        int stairs = arr[0];
        int jumps = 1;

        for (int level = 1; level < n; level++) {
            // check to see if we reached end of array
            // no need for this check though
            if (level == n - 1) {
                return jumps;
            }

            // check if to find higher ladder
            if (level + arr[level] > ladder) {
                ladder = level + arr[level];
            }
            stairs--;

            // if stairs are not left then get new ladder
            if (stairs == 0) {
                jumps++;
                stairs = ladder - level;
            }
        }
        
        return jumps;
    }

    public static void main(String args[]) {
        int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        int n = arr.length;

//        System.out.println("Minimum number of jumps to reach end is: "
//                + minJumps_Rec(arr, 0, n));
//        System.out.println("Minimum number of jumps to reach end is: "
//                + minJumps_DP(arr, n));
        System.out.println("Minimum number of jumps to reach end is: "
                + minJumps_Linear(arr, n));
    }
}
