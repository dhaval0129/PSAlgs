/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string;

import java.util.Arrays;

/**
 * Check if string is Anagram of each other
 * 
 * An anagram of a string is another string that contains same characters, 
 * only the order of characters can be different. For example, “abcd” and “dabc” are anagram of each other
 *
 * @author djoshi
 *
 * Listen = Silent Triangle = Integral
 *
 * Reference:
 * http://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
 */
public class Anagram {

    // using sort() and equals() method of java
    static boolean isAnagram(String s1, String s2) {
        String copyOfs1 = s1.replaceAll("\\s", "");
        String copyOfs2 = s2.replaceAll("\\s", "");

        boolean status = true;

        if (copyOfs1.length() != copyOfs2.length()) {
            status = false;
        } else {
            //Changing the case of characters of both copyOfs1 and copyOfs2 and converting them to char array
            char[] s1Array = copyOfs1.toLowerCase().toCharArray();
            char[] s2Array = copyOfs2.toLowerCase().toCharArray();
            //Sorting both s1Array and s2Array
            Arrays.sort(s1Array);
            Arrays.sort(s2Array);
            //Checking whether s1Array and s2Array are equal
            status = Arrays.equals(s1Array, s2Array);
        }

        //Output
        if (status) {
            System.out.println(s1 + " and " + s2 + " are anagrams");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams");
        }       
        return status;
    }

    public static void main(String args[]) {
        String s1 = "geeksforgeeks";
        String s2 = "forgeeksgeeks";

    }

}
