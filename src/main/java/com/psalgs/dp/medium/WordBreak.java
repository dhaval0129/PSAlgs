/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp.medium;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
 *
 * https://www.youtube.com/watch?v=WepWFGxiwRs
 *
 * Word Break Problem
 *
 * Given an input string and a dictionary of words, find out if the input string
 * can be segmented into a space-separated sequence of dictionary words.
 *
 */
public class WordBreak {

    private static boolean dictionaryContains(String word) {
        String dictionary[] = {"mobile", "samsung", "sam", "sung",
            "man", "mango", "icecream", "and",
            "go", "i", "like", "ice", "crea,"};

        int n = dictionary.length;

        for (int i = 0; i < n; i++) {
            if (dictionary[i].equals(word)) {
                return true;
            }
        }
        return false;
    }

    private static boolean wordBreak_Rec(String str) {
        int len = str.length();
        // base case
        if (len == 0) {
            return true;
        }

        for (int i = 1; i <= len; i++) {
            if (dictionaryContains(str.substring(0, i))
                    && wordBreak_Rec(str.substring(i, len))) {
                return true;
            }
        }
        return false;
    }

    // Bottom Up approach
    private static boolean wordBreak_DP(String str) {
        int n = str.length();
        if (n == 0) {
            return true;
        }

        boolean[] wb = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (!wb[j] && dictionaryContains(str.substring(j, i))) {
                    wb[i] = true;
                    break;
                }
            }
        }
        return wb[n];
    }

    public static void main(String args[]) {
        if (wordBreak_DP("ilikesamsung")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}
