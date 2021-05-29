/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.traversal;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 *
 * Boundary Traversal of binary tree
 *
 * Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise
 * starting from the root.
 * 
 * Time Complexity: O(n) where n is the number of nodes in binary tree.
 *
 */
public class BTBoundryTraversal {

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

    // A function to print all left boundry nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    private void printBoundaryLeft(tNode node) {

        if (node != null) {
            if (node.left != null) {
                System.out.print(node.data + " ");
                printBoundaryLeft(node.left);
            } else if (node.right != null) {
                System.out.print(node.data + " ");
                printBoundaryLeft(node.right);
            }
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    private void printBoundaryRight(tNode node) {

        if (node != null) {
            if (node.right != null) {
                System.out.print(node.data + " ");
                printBoundaryRight(node.right);
            } else if (node.left != null) {
                System.out.print(node.data + " ");
                printBoundaryRight(node.left);
            }
            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    private void printLeaves(tNode node) {
        if (node != null) {
            printLeaves(node.left);
            
            if(node.left == null && node.right == null) {
                System.out.print(node.data + " ");
            }
            printLeaves(node.right);
        }
    }

    private void printBoundary(tNode node) {
        if (node != null) {
            System.out.print(node.data + " ");

            // Print the left boundary in top-down manner
            printBoundaryLeft(node.left);

            // print leaf node of left subtree from left to right
            printLeaves(node.left);
            // print leaf node of right subree from left to right
            printLeaves(node.right);
            // print the right boundary in bottom-up manner
            printBoundaryRight(node.right);
        }
    }

    public static void main(String args[]) {
        BTBoundryTraversal tree = new BTBoundryTraversal();
        tree.root = new tNode(20);
        tree.root.left = new tNode(8);
        tree.root.right = new tNode(22);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(12);
        tree.root.left.right.left = new tNode(10);
        tree.root.left.right.right = new tNode(14);
        tree.root.right = new tNode(22);
        tree.root.right.right = new tNode(25);
        tree.printBoundary(tree.root);
        System.out.println();
    }
}
