/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.binary;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/generate-binary-permutations-1s-0s-every-point-permutations/
 *
 * Generate all binary permutations such that there are more or equal 1’s than
 * 0’s before every point in all permutations
 *
 */
public class BinaryPermutations {

    private static void generate(int ones, int zeroes, String str, int len) {
        // If length of current string becomes same as desired length
        if (len == str.length()) {
            System.out.println(str);
            return;
        }

        // Append 1 and recurse
        generate(ones + 1, zeroes, str + "1", len);

        if (ones > zeroes) {
            generate(ones, zeroes + 1, str + "0", len);
        }
    }

    public static void main(String args[]) {
        String str = "";
        generate(0, 0, str, 4);
    }
}
