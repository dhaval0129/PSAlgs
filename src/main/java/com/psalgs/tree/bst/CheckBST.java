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
 * http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
 *
 * A program to check if a binary tree is BST or not
 *
 *
 * Time Complexity: O(n) Auxiliary Space: O(1) if Function Call Stack size is
 * not considered, otherwise O(n)
 *
 */
public class CheckBST {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;

    private boolean isBST() {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(tNode node, int min, int max) {
        // Base case
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
        CheckBST tree = new CheckBST();
        tree.root = new tNode(4);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(5);
        tree.root.left.left = new tNode(1);
        tree.root.left.right = new tNode(3);

        if (tree.isBST()) {
            System.out.println("Tree is BST");
        } else {
            System.out.println("Tree is not BST");
        }
    }
}
