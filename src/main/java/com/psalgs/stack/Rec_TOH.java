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
 * http://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/
 *
 * Tower of Hanoi ( Recursion )
 * 
 * Time Complexity O(2^n - 1)
 */
public class Rec_TOH {

    /**
     * 
     * @param n
     * @param from_rod
     * @param to_rod
     * @param aux_rod 
     */
    private static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) {

        if (n == 1) {
            System.out.println("Move disk 1 from rod " + from_rod + " to rod " + to_rod);
            return;
        }
        
        towerOfHanoi(n-1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod);
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod );
    }

    public static void main(String args[]) {
        int n = 3; // Number of disks
        // A is from rod
        // C is to rod
        // B is auxillary rod
        towerOfHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods
    }
}
