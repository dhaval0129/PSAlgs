/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp.hard;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-37-boolean-parenthesization-problem/
 *
 * https://algorithmsandme.in/2017/08/27/boolean-parenthesization-problem/
 *
 * https://www.youtube.com/watch?v=OF9Lhzjrv-E
 *
 * Boolean Parenthesization Problem
 *
 * Given boolean expression and operators, count no. of ways we can parenthesize
 * so that value of expression evaluates to true
 *
 * Time Complexity: O(n^3) 
 * Auxiliary Space: O(n^2)
 */
public class BooleanParenthesis {

    private static int countParenthesis(char[] symb, char[] oper, int n) {
        int[][] F = new int[n][n];
        int[][] T = new int[n][n];

        for (int i = 0; i < n; i++) {
            F[i][i] = (symb[i] == 'F') ? 1 : 0;
            T[i][i] = (symb[i] == 'T') ? 1 : 0;
        }

        // Now fill T[i][i+1], T[i][i+2], T[i][i+3]... in order
        // And F[i][i+1], F[i][i+2], F[i][i+3]... in order
        for (int gap = 1; gap < n; ++gap) {

            for (int i = 0, j = gap; j < n; ++i, ++j) {

                T[i][j] = F[i][j] = 0;

                for (int g = 0; g < gap; g++) {

                    // Find place of parenthesization using current value
                    // of gap
                    int k = i + g;

                    // Store Total[i][k] and Total[k+1][j]
                    int tik = T[i][k] + F[i][k];
                    int tkj = T[k + 1][j] + F[k + 1][j];

                    // Follow the recursive formulas according to the current
                    // operator
                    if (oper[k] == '&') {
                        T[i][j] += T[i][k] * T[k + 1][j];
                        F[i][j] += (tik * tkj - T[i][k] * T[k + 1][j]);
                    }

                    if (oper[k] == '|') {
                        F[i][j] += F[i][k] * F[k + 1][j];
                        T[i][j] += (tik * tkj - F[i][k] * F[k + 1][j]);
                    }

                    if (oper[k] == '^') {
                        T[i][j] += F[i][k] * T[k + 1][j] + T[i][k] * F[k + 1][j];
                        F[i][j] += T[i][k] * T[k + 1][j] + F[i][k] * F[k + 1][j];
                    }
                }
            }
        }
        return T[0][n - 1];
    }

    public static void main(String args[]) {
        char[] symbols = {'T', 'T', 'F', 'T'};
        char[] operators = {'|', '&', '^'};
        int n = symbols.length;

        System.out.println(countParenthesis(symbols, operators, n));
    }

}
