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
 * http://www.geeksforgeeks.org/find-given-string-can-represented-substring-iterating-substring-n-times/
 *
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/string/NTMatch.java
 *
 * Find if a given string can be represented from a substring by iterating the
 * substring “n” times
 * 
 * Note: Implementation of KMP Algorithm
 * 
 * Time Complexity: O(n)
 *
 */
public class nSubstring {

    private static void computeLPSArray(String str, int M, int[] lps) {
        int len = 0; // length of the previous longest prefix suffix
        int i = 1;
        lps[0] = 0;

        while (i < M) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // (pat[i] != pat[len])
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    private static boolean isRepeat(String str) {
        int n = str.length();
        int lps[] = new int[n];

        computeLPSArray(str, n, lps);
        int len = lps[n - 1];

        return (len > 0 && n % (n - len) == 0) ? true : false;
    }

    public static void main(String args[]) {
        String txt[] = {"ABCABC", "ABABAB", "ABCDABCD", "GEEKSFORGEEKS",
            "GEEKGEEK", "AAAACAAAAC", "ABCDABC"};
        int n = txt.length;

        for (int i = 0; i < n; i++) {
            String status = isRepeat(txt[i]) ? "True" : "False";
            System.out.println(txt[i] + " " + status);
        }
    }
}
