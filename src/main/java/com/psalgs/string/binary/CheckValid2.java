/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.binary;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/check-binary-string-0-1s-not-set-2-regular-expression-approach/
 *
 * Check if a binary string has a 0 between 1s or not
 *
 */
public class CheckValid2 {

    private static boolean checkString(String str) {
        String regex = "10+1"; // of type 1000--1 

        // compile regex
        Pattern p = Pattern.compile(regex);

        // Match object
        Matcher m = p.matcher(str);

        while (m.find()) {
            return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        String str = "00011111111100000";
        System.out.println(checkString(str) ? "VALID" : "NOT VALID");
    }
}
