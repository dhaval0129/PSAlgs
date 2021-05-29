/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.patternsearch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/find-patterns-101-given-string-set-2regular-expression-approach/
 *
 * Find all the patterns of “1(0+)1” in a given string
 *
 */
public class FindPattern {

    private static int patternCount(String str) {
        // regular expression for the pattern
        String regex = "10+1";
        // compiling regex
        Pattern p = Pattern.compile(regex);
        // Matcher object
        Matcher m = p.matcher(str);
        // counter
        int counter = 0;

        // whenever match found
        // increment counter
        while (m.find()) {
            // As last character of current match
            // is always one, starting match from that index
            m.region(m.end() - 1, str.length());
            counter++;
        }
        
        return counter;
    }

    public static void main(String[] args) {
        String str = "1001ab010abc01001";
        System.out.println(patternCount(str));
    }
}
