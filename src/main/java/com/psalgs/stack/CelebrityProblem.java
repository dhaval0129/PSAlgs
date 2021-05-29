/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.stack;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/the-celebrity-problem/
 *
 * The Celebrity Problem
 * 
 * Note: Celebrity has to be in 2nd or 3rd row
 *
 */
public class CelebrityProblem {

    // Person with 2 is celebrity
    static int MATRIX[][] =
           {{0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0}};

    // Returns true if a knows b, false otherwise
    private static boolean knows(int a, int b) {
        boolean res = (MATRIX[a][b] == 1) ? true : false;
        return res;
    }

    private static int findCelebrity(int n) {
        // Initialize two pointers as two corners
        int a = 0;
        int b = n - 1;

        // Keep moving while the two pointers
        // don't become same.
        while (a < b) {
            if (knows(a, b)) {
                a++;
            } else {
                b--;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != a && (knows(a, i) || !knows(i, a))) {
                return -1;
            }
        }

        return a;
    }

    public static void main(String args[]) {
        int n = 4;
        int result = findCelebrity(n);
        
        if (result == -1) {
            System.out.println("No Celebrity");
        } else {
            System.out.println("Celebrity ID: " + result);
        }
    }

}
