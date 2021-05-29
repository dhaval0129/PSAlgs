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
 * http://www.geeksforgeeks.org/remove-recurring-digits-in-a-given-number/
 *
 * Remove recurring digits in a given number
 *
 * Time Complexity O(n)
 */
public class RemoveRecurringDigits {

    private static String removeRecurringDigits(char[] num) {
        int len = num.length;
        int j = 0;
        String s = "";

        for (int i = 0; i < len; i++) {
            s += "" + num[i];

            while (i + 1 < len && num[i] == num[i + 1]) {
                i++;
            }
        }
        return s;
    }

    public static void main(String args[]) {
        String num = "12998888334";
        String s = removeRecurringDigits(num.toCharArray());
        System.out.println("Modified number is: " + s);
    }
}
