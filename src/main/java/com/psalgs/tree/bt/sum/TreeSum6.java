/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.sum;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
 *
 * Convert a given tree to its Sum Tree
 * 
 * Time Complexity: O(n)
 *
 */
public class TreeSum6 {

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

    // Time Complexity: O(n)
    private int toSumTree(tNode node) {
        // Base case
        if (node == null) {
            return 0;
        }

        // Store the old value
        int old_val = node.data;

        // Recursively call for left and right subtrees and store the sum
        // as new value of this node
        node.data = toSumTree(node.left) + toSumTree(node.right);

        // Return the sum of values of nodes in left and right subtrees
        // and old_value of this node
        return node.data + old_val;
    }

    private void printInOrder(tNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

    /* Driver function to test above functions */
    public static void main(String args[]) {
        TreeSum6 tree = new TreeSum6();

        /* Constructing tree given in the above figure */
        tree.root = new tNode(10);
        tree.root.left = new tNode(-2);
        tree.root.right = new tNode(6);
        tree.root.left.left = new tNode(8);
        tree.root.left.right = new tNode(-4);
        tree.root.right.left = new tNode(7);
        tree.root.right.right = new tNode(5);

        tree.toSumTree(tree.root);

        // Print inorder traversal of the converted tree to test result 
        // of toSumTree()
        System.out.println("Inorder Traversal of the resultant tree is:");
        tree.printInOrder(tree.root);
        System.out.println();
    }
}
