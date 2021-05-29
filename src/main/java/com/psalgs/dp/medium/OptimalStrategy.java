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
 * Reference:
 *
 * http://algorithms.tutorialhorizon.com/dynamic-programming-coin-in-a-line-game-problem/
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-31-optimal-strategy-for-a-game/
 *
 * https://stackoverflow.com/questions/22195300/understanding-solution-to-finding-optimal-strategy-for-game-involving-picking-po
 *
 * Optimal Strategy for a Game ( Pot Gold Problem )
 *
 */
public class OptimalStrategy {

    private static int Solve_Rec(int[] arr, int start, int end) {
        if(start > end){
            return 0;
        }
        
        int a = arr[start] + Math.min(Solve_Rec(arr, start + 2, end),
                Solve_Rec(arr, start + 1, end - 1));
        int b = arr[end] + Math.min(Solve_Rec(arr, start + 1, end - 1), 
                Solve_Rec(arr, start, end - 2));
        
        return Math.max(a, b);
    }

    private static int Solve_DP(int[] arr) {
        int n = arr.length;
        int[][] table = new int[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                // i is from front and j is from back ( in theory)
                // a = table(i+2,j) - Alice chooses i Bob chooses i+1
                // b = table(i+1,j-1)- Alice chooses i, Bob chooses j OR
                // Alice chooses j, Bob chooses i
                // c = table(i,j-2)- Alice chooses j, Bob chooses j-1
                int a, b, c;
                if (i + 2 <= j) {
                    a = table[i + 2][j];
                } else {
                    a = 0;
                }

                if (i + 1 <= j - 1) {
                    b = table[i + 1][j - 1];
                } else {
                    b = 0;
                }

                if (i <= j - 2) {
                    c = table[i][j - 2];
                } else {
                    c = 0;
                }

                table[i][j] = Math.max(arr[i] + Math.min(a, b),
                        arr[j] + Math.min(b, c));
            }
        }
        return table[0][n - 1];
    }

    public static void main(String args[]) {
        int[] arr = {8, 15, 3, 7};
//        int len = arr.length;
//        System.out.println("Max value pick up by player1(Alice) " + Solve_Rec(arr, 0, len-1 ));
        System.out.println("Max value pick up by player1(Alice) " + Solve_DP(arr));
    }

}
