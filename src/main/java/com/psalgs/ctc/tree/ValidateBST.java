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
 * Implement a function to check if a binary tree is a binary search tree.
 *
 * https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
 *
 * Time Complexity O(n) 
 * Auxiliary Space O(1)
 *
 */
public class ValidateBST {

    static class Node {

        int data;
        Node left, right;

        Node(int d) {
            this.data = d;
            left = right = null;
        }
    }

    static Node root;

    private boolean isBST() {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(Node node, int min, int max) {

        /* an empty tree is BST */
        if (node == null) {
            return true;
        }

        /* false if this node violates the min/max constraints */
        if (node.data < min || node.data > max) {
            return false;
        }

        /* otherwise check the subtrees recursively 
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.data - 1)
                && isBSTUtil(node.right, node.data + 1, max));
    }

    public static void main(String args[]) {
        ValidateBST tree = new ValidateBST();

        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        //tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(3);

        if (tree.isBST()) {
            System.out.println("Is BST");
        } else {
            System.out.println("Not a BST");
        }
    }
}
