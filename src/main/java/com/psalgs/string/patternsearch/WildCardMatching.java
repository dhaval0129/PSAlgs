/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.patternsearch;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/wildcard-character-matching/
 *
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/WildCardMatching.java
 *
 * https://www.youtube.com/watch?v=3ZDZ-N0EPV0
 *
 */
public class WildCardMatching {

    // Dynamic programming 
    
    public static boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        //replace multiple * with one *
        //e.g a**b***c --> a*b*c
        int writeIndex = 0;
        boolean isFirst = true;
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[writeIndex++] = pattern[i];
                    isFirst = false;
                }
            } else {
                pattern[writeIndex++] = pattern[i];
                isFirst = true;
            }
        }

        boolean T[][] = new boolean[str.length + 1][writeIndex + 1];

        if (writeIndex > 0 && pattern[0] == '*') {
            T[0][1] = true;
        }

        T[0][0] = true;

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j - 1] == '?' || str[i - 1] == pattern[j - 1]) {
                    T[i][j] = T[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    T[i][j] = T[i - 1][j] || T[i][j - 1];
                }
            }
        }

        return T[str.length][writeIndex];
    }

    // Recursive approach
    
    private static boolean isMatch_Recur(String s, String p) {
        return isMatch_RecurUtil(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    private static boolean isMatch_RecurUtil(char[] text, char[] pattern, int pos1, int pos2) {
        if (pos2 == pattern.length) {
            return text.length == pos1;
        }

        if (pattern[pos2] != '*') {
            if (pos1 < text.length && text[pos1] == pattern[pos2] || pattern[pos2] == '?') {
                return isMatch_RecurUtil(text, pattern, pos1 + 1, pos2 + 1);
            }
        } else {
            //if we have a***b then skip to the last *
            while (pos2 < pattern.length - 1 && pattern[pos2 + 1] == '*') {
                pos2++;
            }

            while (pos1 < text.length) {
                if (isMatch_RecurUtil(text, pattern, pos1, pos2 + 1)) {
                    return true;
                }
                pos1++;
            }
        }
        return false;
    }

    public static void main(String args[]) {
//        System.out.println(isMatch_Recur("xbylmz", "x?y*z"));
        System.out.println(isMatch("xbylmz", "x?y*z"));
    }
}
