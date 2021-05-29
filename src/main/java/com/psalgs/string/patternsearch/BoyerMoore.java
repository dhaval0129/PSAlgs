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
 * http://www.geeksforgeeks.org/pattern-searching-set-7-boyer-moore-algorithm-bad-character-heuristic/
 *
 * http://algs4.cs.princeton.edu/53substring/BoyerMoore.java.html
 * 
 * http://www.inf.fh-flensburg.de/lang/algorithmen/pattern/bmen.htm
 *
 * Boyer Moore Algorithm for pattern searching ( bad character heuristics ) 
 *
 */
public class BoyerMoore {

    private int R; // the radix
    private int[] right; // the bad-character skip array
    private String pat; // or as string

    // preprocess the pattern string
    private BoyerMoore(String pat) {
        this.R = 128;
        this.pat = pat;

        // position of rightmost occurrence of c in the pattern
        right = new int[R];
        for (int c = 0; c < R; c++) {
            right[c] = -1;
        }
        for (int j = 0; j < pat.length(); j++) {
            right[pat.charAt(j)] = j;
        }
    }

    private int search(String txt) {
        int m = pat.length();
        int n = txt.length();
        int skip;

        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            // start pattern matching from right to left
            for (int j = m - 1; j >= 0; j--) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    // check the value of character from pattern string in ascii table
                    skip = Math.max(1, j - right[txt.charAt(i + j)]);
                    break;
                }
            }
            if (skip == 0) {
                return i; //found
            }
        }
        return n; // not found
    }

    public static void main(String args[]) {
        System.out.println("Boyer Moore Algorithm: ");
//        String txt = "AABAACAADAABAAABAA";
        String txt = "AABAABAAABA";
        String pat = "BAAA";
        BoyerMoore boyermoore1 = new BoyerMoore(pat);
        int offset1 = boyermoore1.search(txt);

        System.out.println("Pattern Found at Index: "+offset1);
        
        System.out.println(txt);
        for (int i = 0; i < offset1; i++) {
            System.out.print(" ");
        }
        System.out.println(pat);
    }
}
