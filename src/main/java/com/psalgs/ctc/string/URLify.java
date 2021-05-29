/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.ctc.string;

/**
 *
 * @author djoshi
 *
 * https://www.geeksforgeeks.org/urlify-given-string-replace-spaces/
 *
 * Write a method to replace all spaces in a string with '%20'.
 *
 */
public class URLify {

    public static void main(String args[]) {
        // Instantiate the string 
        String str = "Mr John Smith   ";

        // Trim the given string 
        str = str.trim();

        // Replace All space (unicode is \\s) to %20 
        str = str.replaceAll("\\s", "%20");

        // Display the result 
        System.out.println(str);
    }
}
