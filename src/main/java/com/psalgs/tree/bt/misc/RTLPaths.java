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
 * http://www.geeksforgeeks.org/given-a-binary-tree-print-out-all-of-its-root-to-leaf-paths-one-per-line/
 * 
 * http://www.geeksforgeeks.org/given-a-binary-tree-print-all-root-to-leaf-paths/
 *
 * Given a binary tree, print out all of its root-to-leaf paths one per line.
 *
 */
public class RTLPaths {

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

    private void printPaths(tNode node) {
        // declare array of higher size
        int path[] = new int[10];
        printPathsRecur(node, path, 0);
    }

    private void printPathsRecur(tNode node, int path[], int pathLen) {
        if (node == null) {
            return;
        }

        /* append this node to the path array */
        path[pathLen] = node.data;
        pathLen++;

        /* it's a leaf, so print the path that led to here */
        if (node.left == null && node.right == null) {
            printArray(path, pathLen);
        } else {
            /* otherwise try both subtrees */
            printPathsRecur(node.left, path, pathLen);
            printPathsRecur(node.right, path, pathLen);
        }
    }

    private void printArray(int ints[], int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String args[]) {
        RTLPaths tree = new RTLPaths();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        System.out.println("Print Different Paths");
        tree.printPaths(tree.root);

    }
}
