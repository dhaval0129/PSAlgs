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
 * http://www.geeksforgeeks.org/check-if-each-internal-node-of-a-bst-has-exactly-one-child/
 *
 * Check if each internal node of a BST has exactly one child
 *
 * Time Complexity: O(n)
 * 
 */
public class OneChild {

    private boolean hasOnlyOneChild(int pre[], int size) {
        int nextDiff, lastDiff;

        for (int i = 0; i < size - 1; i++) {
            nextDiff = pre[i] - pre[i + 1];
            lastDiff = pre[i] - pre[size - 1];

            if (nextDiff * lastDiff < 0) {
                return false;
            };
        }
        
        return true;
    }

    public static void main(String args[]) {
        OneChild tree = new OneChild();
        int pre[] = {8, 3, 5, 7, 6};
        int size = pre.length;

        if (tree.hasOnlyOneChild(pre, size)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

}
