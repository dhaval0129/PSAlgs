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
 * http://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other/
 *
 * A Program to check if strings are rotations of each other or not
 *
 */
public class StringRotations {

    private static boolean areRotations(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        String temp = str1 + str1;

        return (str1.length() == str2.length() 
                && temp.indexOf(str2) != -1);             
    }

    public static void main(String[] args) {
        String str1 = "AACD";
        String str2 = "ACDA";

        if (areRotations(str1, str2)) {
            System.out.println("Strings are rotations of each other");
        } else {
            System.out.printf("Strings are not rotations of each other");
        }
    }
}
