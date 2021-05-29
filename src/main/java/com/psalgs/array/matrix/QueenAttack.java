/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.matrix;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/number-cells-queen-can-move-obstacles-chessborad/
 *
 * http://portalkrishna.blogspot.com/2017/01/queens-attack-ii-solving-problem.html
 *
 * Number of cells a queen can move with obstacles on the chess board
 *
 * Queen Attack II problem ( Method 2 of first link on top )
 *
 * Time Complexity O( k ) where k is no. of obstacles 
 */
public class QueenAttack {

    private static int numberOfPosition(int n, int k, int x, int y, int obstPosx[], int obstPosy[]) {
        // d11, d12, d21, d22 are for diagnoal distances.
        // r1, r2 are for vertical distance.
        // c1, c2 are for horizontal distance.
        int d11, d12, d21, d22, r1, r2, c1, c2;

        // Initialize the distance to end of the board ( diagonals)
        d11 = Math.min(x - 1, y - 1); // top left half diagonal
        d12 = Math.min(n - x, n - y); // bottom right half diagonal
        d21 = Math.min(n - x, y - 1); // bottom left half diagonal
        d22 = Math.min(x - 1, n - y); // top right half diagonal

        // Initialize distances from center ( vertical and horizontal )
        r1 = y - 1;  // mid left half horizontal (row)
        r2 = n - y;  // mid right half horizontal (row)
        c1 = x - 1;  // mid top half vertical (column)
        c2 = n - x;  // mid bottom half vertical (column)

        // For each obstacle find the minimum distance.
        // If obstacle is present in any direction, distance has to be updated.
        for (int i = 0; i < k; i++) {
            
            // check if there is any obstacles on top left half diagonal (d11)
            if (x > obstPosx[i] && y > obstPosy[i] && x - obstPosx[i] == y - obstPosy[i]) {
                d11 = Math.min(d11, x - obstPosx[i] - y);
            }

            // check if there is any obstacles on bottom right half diagonal (d12)
            if (obstPosx[i] > x && obstPosy[i] > y && obstPosx[i] - x == obstPosy[i] - y) {
                d12 = Math.min(d12, obstPosx[i] - x - 1);
            }

            // check if there is any obstacles on bottom left half diagonal (d21)
            if (obstPosx[i] > x && y > obstPosy[i] && obstPosx[i] - x == y - obstPosy[i]) {
                d21 = Math.min(d21, obstPosx[i] - x - 1);
            }

            // check if there is any obstacles on top right half diagonal (d22)
            if (x > obstPosx[i] && obstPosy[i] > y && x - obstPosx[i] == obstPosy[i] - y) {
                d22 = Math.min(d22, x - obstPosx[i] - 1);
            }

            // check if obstacle is straight left from middle horizontally
            if (x == obstPosx[i] && obstPosy[i] < y) {
                r1 = Math.min(r1, y - obstPosy[i] - 1);
            }

            // check if obstacle is straight right from middle horizontally
            if (x == obstPosx[i] && obstPosy[i] > y) {
                r2 = Math.min(r2, obstPosy[i] - y - 1);
            }

            // check if obstacle is straight top from middle vertically
            if (y == obstPosy[i] && obstPosx[i] < x) {
                c1 = Math.min(c1, x - obstPosx[i] - 1);
            }

            // check if obstacle is straight bottom from middle vertically
            if (y == obstPosy[i] && obstPosx[i] > x) {
                c2 = Math.min(c2, obstPosx[i] - x - 1);
            }
        }

        return d11 + d12 + d21 + d22 + r1 + r2 + c1 + c2;
    }

    public static void main(String args[]) {
        int n = 8; // Chessboard size
        int k = 1; // Number of obstacles 
        int Qposx = 4; // Queen X Position
        int Qposy = 4; // Queen y position
        int obstPosx[] = {3}; // x position of obstacles 
        int obstPosy[] = {4}; // y position of obstacles 
        
        int no =  numberOfPosition(n, k, Qposx, Qposy, obstPosx, obstPosy);
        System.out.println(no);

    }
}
