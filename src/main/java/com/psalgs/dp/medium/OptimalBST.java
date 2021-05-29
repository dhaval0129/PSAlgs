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
 * Optimal Binary Search Tree
 *
 * https://www.geeksforgeeks.org/optimal-binary-search-tree-dp-24/
 *
 * https://www.youtube.com/watch?v=hgA4xxlVvfQ
 *
 * https://www.youtube.com/watch?v=vLS-zRCHo-Y
 *
 *
 */
public class OptimalBST {

    private static int optCost(int freq[], int i, int j) {

        // base cases
        if (j < i) {
            return 0;
        }

        if (j == i) {
            return freq[i];
        }

        int fsum = sum(freq, i, j);

        int min = Integer.MAX_VALUE;

        // One by one consider all elements as root and  
        // recursively find cost of the BST, compare the  
        // cost with min and update min if needed 
        for (int r = i; r <= j; ++r) {
            int cost = optCost(freq, i, r - 1)
                    + optCost(freq, r + 1, j);
            if (cost < min) {
                min = cost;
            }
        }

        // Return minimum value 
        return min + fsum;
    }

    private static int optimalSearchTree(int keys[], int freq[], int n) {
        return optCost(freq, 0, n - 1);
    }

    private static int sum(int freq[], int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++) {
            s += freq[k];
        }
        return s;
    }

    public static void main(String[] args) {
        int keys[] = {10, 12, 20};
        int freq[] = {34, 8, 50};
        int n = keys.length;
        System.out.println("Cost of Optimal BST is " + optimalSearchTree(keys, freq, n));
    }
}
