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
 * http://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
 *
 * How to determine if a binary tree is height-balanced ?
 * 
 * The difference between heights of left subtree and right subtree is not more than 1. 
 * 
 * Time Complexity: O(n^2) 
 *
 */
public class TreeBalance {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;

    private int height(tNode node) {
        if (node == null) {
            return 0;
        }
        return (1 + Math.max( height(node.left), height(node.right) ));
    }

    private boolean isBalanced(tNode node) {
        int lh;
        /* for height of left subtree */
        int rh;
        /* for height of right subtree */

        /* If tree is empty then return true */
        if (node == null) {
            return true;
        }

        /* Get the height of left and right sub trees */
        lh = height(node.left);
        rh = height(node.right);

        // check node balance at each and every level
        if (Math.abs(lh - rh) <= 1
                && isBalanced(node.left) && isBalanced(node.right)) {
            return true;
        }
        
        return false;
    }

    public static void main(String args[]) {
        TreeBalance tree = new TreeBalance();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.left.left.left = new tNode(8);

        if (tree.isBalanced(tree.root)) {
            System.out.println("Tree is balanced");
        } else {
            System.out.println("Tree is not balanced");
        }
    }
}
