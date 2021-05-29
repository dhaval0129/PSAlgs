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
 * http://www.geeksforgeeks.org/searching-for-patterns-set-5-finite-automata/
 *
 * Finite Automata Pattern searching ( FSM (finite state machine) Algorithm )
 *
 * Time Complexity O(n)
 * 
 * https://www.youtube.com/watch?v=M_XpGQyyqIQ
 *
 */
public class FiniteAutomata {

    private static final int NO_OF_CHARS = 128;

    private static int getNextState(String pat, int M, int state, int x) {
        // If the character c is same as next character in pattern, 
        // then simply increment state
        if (state < M && x == pat.charAt(state)) {
            return ++state;
        }

        // ns stores the result which is next state
        int ns, i;

        // ns finally contains the longest prefix which
        // is also suffix in "pat[0...state-1]c"
        for (ns = state; ns > 0; ns--) {
            if (pat.charAt(ns - 1) == x) {
                for (i = 0; i < ns - 1; i++) {
                    if (pat.charAt(i) != pat.charAt(state - ns + 1 + i)) {
                        break;
                    }
                }
                if (i == ns - 1) {
                    return ns;
                }
            }
        }

        return 0;
    }

    // 2D array which represents finite automata 
    private static void computeTF(String pat, int M, int TF[][]) {
        for (int state = 0; state <= M; ++state) {
            for (int x = 0; x < NO_OF_CHARS; ++x) {
                TF[state][x] = getNextState(pat, M, state, x);
            }
        }
    }

    private static void search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        int[][] TF = new int[M + 1][NO_OF_CHARS];

        computeTF(pat, M, TF);

        // Process txt over FA.
        int i, state = 0;
        for (i = 0; i < N; i++) {
            state = TF[state][txt.charAt(i)];
            if (state == M) {
                System.out.println("Pattern found at index " + (i - M + 1));
            }
        }
    }

    public static void main(String args[]) {
        String txt = "AABAACAADAABAAABAA";
        String pat = "AABA";
        search(pat, txt);
    }
}
