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
 * http://www.geeksforgeeks.org/generate-all-binary-strings-from-given-pattern/
 *
 * Generate all binary strings from given pattern
 *
 */
public class GenerateBSPattern {

    private static void print(String str, int index) {

        if (index == str.length()) {
            System.out.println(str);
            return;
        }

        StringBuffer sb = new StringBuffer(str);

        if (sb.charAt(index) == '?') {

            // replace '?' by '0' and recurse
            sb.replace(index, index + 1, "0");
            print(sb.toString(), index + 1);

            // replace '?' by '1' and recurse
            sb.replace(index, index + 1, "1");
            print(sb.toString(), index + 1);
        } else {
            print(sb.toString(), index + 1);
        }
    }

    public static void main(String args[]) {
        String str = "1??0?101";
        print(str, 0);
    }
}
