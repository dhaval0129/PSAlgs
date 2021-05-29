/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bst;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/check-for-identical-bsts-without-building-the-trees/
 *
 * https://algoexplode.wordpress.com/2013/11/13/check-for-same-bsts-from-arrays-geeksforgeeks/
 *
 * Check for Identical BSTs without building the trees
 *
 */
public class CheckBST2 {

    private static boolean calculate(int a[], int b[]) {
        return calculateRec(a, b, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean calculateRec(int a[], int b[], int x, int y, int min, int max) {
        int i, j;
        for (i = x; i < a.length; i++) {
            if (a[i] > min && a[i] < max) {
                break;
            }
        }

        for (j = y; j < b.length; j++) {
            if (b[j] > min && b[j] < max) {
                break;
            }
        }

        if (i == a.length && j == b.length) {
            return true;
        } else if (i == a.length || j == b.length) {
            return false;
        } else {
            return a[i] == b[j]
                    && calculateRec(a, b, x + 1, y + 1, min, a[i])
                    && calculateRec(a, b, x + 1, y + 1, a[i], max);
        }

    }

    public static void main(String args[]) {
        int a[] = {2, 4, 1, 3};
        int b[] = {2, 4, 3, 1};

        if (calculate(a, b)) {
            System.out.println("Both BST are identical");
        } else {
            System.out.println("Both BST are not identical");
        }
    }

}
