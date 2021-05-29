/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dc;

/**
 *
 * @author djoshi
 */
public class PowerX {

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Algorithmic Paradigm: Divide and conquer.
    static int power(int x, int y) {
        if (y == 0) {
            return 1;
        } else if (y % 2 == 0) {
            return power(x, y / 2) * power(x, y / 2);
        } else {
            return x * power(x, y / 2) * power(x, y / 2);
        }
    }

    float power(float x, int y) {
        float temp;
        if (y == 0) {
            return 1;
        }
        temp = power(x, y / 2);
        if (y % 2 == 0) {
            return temp * temp;
        } else if (y > 0) {
            return x * temp * temp;
        } else {
            return (temp * temp) / x;
        }
    }

    public static void main(String args[]) {
        int x = 2;
        int y = 3;

        System.out.println(" " + power(x, y));
    }

}
