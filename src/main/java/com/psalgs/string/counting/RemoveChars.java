/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.counting;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/remove-characters-from-the-first-string-which-are-present-in-the-second-string/
 *
 * Remove characters from the first string which are present in the second
 * string
 *
 */
public class RemoveChars {

    private static final int NO_OF_CHARS = 128;

    /* Returns an array of size 256 containg count
       of characters in the passed char array */
    private static int[] getCharCountArray(String str) {
        int count[] = new int[NO_OF_CHARS];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        return count;
    }

    /* 
    RemoveDirtyChars takes two string as arguments: First
    string (str)  is the one from where function removes dirty
    characters. Second  string is the string which contain all
    dirty characters which need to be removed  from first string 
     */
    private static String removeDirtyChars(String str, String mask_str) {
        int count[] = getCharCountArray(mask_str);
        int ip_ind = 0, res_ind = 0;
        String s = "";
        char arr[] = str.toCharArray();

        while (ip_ind != arr.length) {
            char temp = arr[ip_ind];

            if (count[temp] == 0) {
                s += temp;
            }
            ip_ind++;
        }
        return s;
    }

    public static void main(String args[]) {
        String str = "geeksforgeeks";
        String mask_str = "mask";
        System.out.println("Original String: " + str);
        System.out.println("Mask: " + mask_str);
        System.out.println("Result: " + removeDirtyChars(str, mask_str));
    }
}
