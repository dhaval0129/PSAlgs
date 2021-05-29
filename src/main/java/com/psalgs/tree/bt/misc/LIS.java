/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.misc;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/binary-tree-data-structure/
 *
 * Largest Independent Set Problem
 *
 * Given a Binary Tree, find size of the Largest Independent Set(LIS) in it
 * 
 * Time Complexity: O(n) where n is the number of nodes in given Binary tree. 
 */
public class LIS {

    static class tNode {

        int data, liss;
        tNode left;
        tNode right;

        tNode(int d) {
            liss = 0;
            data = d;
            left = right = null;
        }
    }

    // A memoization function returns size 
    // of the largest independent set in
    // a given binary tree
    private static int liss(tNode node) {

        if (node == null) {
            return 0;
        }

        if (node.liss != 0) {
            return node.liss;
        }

        if (node.left == null && node.right == null) {
            return node.liss = 1;
        }

        // Calculate size excluding the 
        // current node
        int liss_excl = liss(node.left) + liss(node.right);

        // Calculate size including the 
        // current node
        int liss_incl = 1;

        if (node.left != null) {
            liss_incl += (liss(node.left.left) + liss(node.left.right));
        }

        if (node.right != null) {
            liss_incl += (liss(node.right.left) + liss(node.right.right));
        }

        return node.liss = Math.max(liss_excl, liss_incl);
    }

    public static void main(String args[]) {
        tNode root = new tNode(20);
        root.left = new tNode(8);
        root.left.left = new tNode(4);
        root.left.right = new tNode(12);
        root.left.right.left = new tNode(10);
        root.left.right.right = new tNode(14);
        root.right = new tNode(22);
        root.right.right = new tNode(25);
        System.out.println("Size of the Largest Independent Set is " + liss(root));
    }
}
