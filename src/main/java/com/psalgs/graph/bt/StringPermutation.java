/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.graph.bt;

/**
 *
 * @author djoshi
 * 
 * Below are the permutations of string ABC.
 * ABC ACB BAC BCA CBA CAB
 * 
 * Reference: http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 */
public class StringPermutation {

    public static void main(String args[]) {
        String str = "ABC";
        int n = str.length();
        StringPermutation permutation = new StringPermutation();
        permutation.permute(str, 0, n - 1);
    }

    /**
     * 
     * @param str
     * @param a
     * @param b 
     */
    private void permute(String str, int a, int b) {
        if (a == b) {
            System.out.println(str);
        } else {

            for (int i = a; i <= b; i++) {
                str = swap(str, a, i);
                permute(str, a + 1, b);
                str = swap(str, a, i);
            }
        }
    }

    /**
     *
     * @param a
     * @param i
     * @param j
     * @return
     */
    public String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}
