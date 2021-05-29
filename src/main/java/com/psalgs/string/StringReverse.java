/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/reverse-a-string-using-recursion/
 *
 * Print reverse of a string using recursion
 *
 */
public class StringReverse {

    private void stringReverse(String s) {
        if (s == null || s.length() <= 1) {
            System.out.print(s + "\n");
        } else {
            System.out.print(s.charAt(s.length() - 1));
            stringReverse(s.substring(0, s.length() - 1));
        }
    }

    public static void main(String args[]) {
        String str = "Geeks for Geeks";
        StringReverse sr = new StringReverse();
        sr.stringReverse(str);
    }
}
