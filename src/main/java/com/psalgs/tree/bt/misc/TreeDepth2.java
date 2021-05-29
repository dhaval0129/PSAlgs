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
 * http://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/
 *
 * Find Minimum Depth of a Binary Tree
 *
 */
public class TreeDepth2 {

    static class tNode {

        int data;
        tNode right;
        tNode left;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;

    private int minimumDepth() {
        return minimumDepth(root);
    }

    private int minimumDepth(tNode node) {
        // Corner case. Should never be hit unless the code is
        // called on root = NULL
        if (root == null) {
            return 0;
        }

        // Base case : Leaf Node. This accounts for height = 1.
        if (root.left == null && root.right == null) {
            return 1;
        }

        // If left subtree is NULL, recur for right subtree
        if (root.left == null) {
            return minimumDepth(root.right) + 1;
        }

        // If right subtree is NULL, recur for right subtree
        if (root.right == null) {
            return minimumDepth(root.left) + 1;
        }

        return Math.min(minimumDepth(root.left),
                minimumDepth(root.right)) + 1;
    }

    public static void main(String args[]) {
        TreeDepth2 tree = new TreeDepth2();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);

        System.out.println("The minimum depth of binary tree is : " + tree.minimumDepth());
    }
}
