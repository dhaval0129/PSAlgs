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
 * http://www.geeksforgeeks.org/print-nodes-dont-sibling-binary-tree/
 *
 * Print all nodes that don’t have sibling
 *
 */
public class NoSiblings {

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

    // Function to print all non-root nodes that don't have a sibling
    private void printSingles(tNode node) {
        if (node == null) {
            return;
        }

        // If this is an internal node, recur for left
        // and right subtrees
        if (node.left != null && node.right != null) {
            printSingles(node.left);
            printSingles(node.right);
        } else if (node.right != null) {
            // If left child is NULL and right is not, print right child
            // and recur for right child
            System.out.print(node.right.data + " ");
            printSingles(node.right);
        } else if (node.left != null) {
            // If right child is NULL and left is not, print left child
            // and recur for left child
            System.out.print(node.left.data + " ");
            printSingles(node.left);
        }
    }

    public static void main(String args[]) {
        NoSiblings tree = new NoSiblings();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.right = new tNode(4);
        tree.root.right.left = new tNode(5);
        tree.root.right.left.right = new tNode(6);
        tree.printSingles(tree.root);
    }
}
