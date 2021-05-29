/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.misc;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/check-if-a-given-sequence-of-moves-for-a-robot-is-circular-or-not/
 *
 * Check if a given sequence of moves for a robot is circular or not
 *
 * Time Complexity: O(n)
 *
 */
public class CircularMoves {

    private static final int N = 0;
    private static final int E = 1;
    private static final int S = 2;
    private static final int W = 3;

    private static boolean isCircular(char[] path) {
        int x = 0, y = 0;
        int dir = N;

        //Traverse the path given for robot
        for (int i = 0; i < path.length; i++) {
            // Find current move
            char move = path[i];

            //If move is left or right, then change direction
            if (move == 'R') {
                dir = (dir + 1) % 4;
            } else if (move == 'L') {
                dir = (4 + dir - 1) % 4;
            } else if (move == 'G') {
                // If move is Go, then change  x or y according to current direction
                if (dir == N) {
                    y++;
                } else if (dir == E) {
                    x++;
                } else if (dir == S) {
                    y--;
                } else {// dir == W
                    x--;
                }
            }
        }

        // If robot comes back to (0, 0), then path is cyclic
        return (x == 0 && y == 0);
    }

    public static void main(String args[]) {
        String path = "GLGLGLG";

        if (isCircular(path.toCharArray())) {
            System.out.println("Given sequence of moves is circular");
        } else {
            System.out.println("Given sequence of moves is not circular");
        }
    }
}
