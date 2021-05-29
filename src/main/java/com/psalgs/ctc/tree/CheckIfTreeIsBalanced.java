/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.ctc.tree;

/**
 *
 * @author djoshi
 *
 * Implement a function to check if a binary tree is balanced. For the purposes
 * of this question, a balanced tree is defined to be a tree such that the
 * heights of the two subtrees of any node never differ by more than one
 *
 * https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
 *
 */
public class CheckIfTreeIsBalanced {

    static class Node {

        int data;
        Node left, right;

        Node(int d) {
            this.data = d;
            left = right = null;
        }
    }

    static class Height {
        int height = 0;
    }

    static Node root;

    private int height(Node node) {
        if (node == null) {
            return 0;
        }

        /* If tree is not empty then height = 1 + max of left 
         height and right heights */
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // Time Complexity O(2 ^ n)
    private boolean isBalanced(Node node) {
        int lh; // for height of left subtree
        int rh; // for height of right subtree

        if (node == null) {
            return true;
        }

        lh = height(node.left);
        rh = height(node.right);

        if (Math.abs(lh - rh) <= 1
                && isBalanced(node.left) && isBalanced(node.right)) {
            return true;
        }
        return false;
    }

    // Time Complexity O(n)
    private boolean isBalanced_Optimized(Node node, Height height) {

        if (node == null) {
            height.height = 0;
            return true;
        }

        Height lheight = new Height();
        Height rheight = new Height();

        boolean l = isBalanced_Optimized(node.left, lheight);
        boolean r = isBalanced_Optimized(node.right, rheight);

        int lh = lheight.height;
        int rh = rheight.height;

        height.height = (lh > rh ? lh : rh) + 1;

        if (Math.abs(lh -rh) >= 2) {
            return false;
        } else {
            return l && r;
        }
    }

    public static void main(String args[]) {
        
        CheckIfTreeIsBalanced tree = new CheckIfTreeIsBalanced();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        //tree.root.right.right = new Node(6);
        tree.root.left.left.left = new Node(7);
        
        Height height = new Height(); 

        //if (tree.isBalanced(tree.root)) {
        if(tree.isBalanced_Optimized(tree.root, height)) {
            System.out.println("Tree is balanced");
        } else {
            System.out.println("Tree is not balanced");
        }
    }
}
