/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bst;

import java.util.Arrays;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/binary-tree-to-binary-search-tree-conversion/
 *
 * Binary Tree to Binary Search Tree Conversion
 *
 * 1] Convert Binary Tree to Array with inorder traversal 2] Sort the array with
 * sorting program ( merge sort or quick sort ) 3] create new BST tree with
 * sorted array.
 *
 */
public class BTtoBST {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    static class Index {

        int i = 0;
    }

    tNode root;

    private void printInorder(tNode node) {
        // base case
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);

    }

    private int countNodes(tNode node) {
        if (node == null) {
            return 0;
        }

        return countNodes(node.left)
                + countNodes(node.right) + 1;
    }

    private void storeInorder(tNode node, int[] arr, Index index) {
        if (node == null) {
            return;
        }

        storeInorder(node.left, arr, index);
        arr[index.i++] = node.data;
        storeInorder(node.right, arr, index);
    }

    private void binaryTreeToBST(tNode node) {
        // base case
        if (node == null) {
            return;
        }

        /* Count the number of nodes in Binary Tree so that
           we know the size of temporary array to be created */
        int n = countNodes(root);
        int[] arr = new int[n];
        // create array of BT with inorder traversal
        storeInorder(root, arr, new Index());
        // sort the array
        Arrays.sort(arr);
        // Instead of creating the new BST just replace values from array
        arrayToBST(root, arr, new Index());
    }

    private void arrayToBST(tNode node,int[] arr, Index index) {

        if (node == null) {
            return;
        }

        arrayToBST(node.left, arr, index);

        node.data = arr[index.i++];

        arrayToBST(node.right, arr, index);
    }

    public static void main(String args[]) {
        /* Constructing tree given in the above figure
            10
           /  \
          30   15
         /      \
        20       5   */
        BTtoBST tree = new BTtoBST();
        tree.root = new tNode(10);
        tree.root.left = new tNode(30);
        tree.root.right = new tNode(15);
        tree.root.left.left = new tNode(20);
        tree.root.right.right = new tNode(5);

        // convert Binary Tree to BST
        tree.binaryTreeToBST(tree.root);

        System.out.println("Following is Inorder Traversal of the converted BST: \n");
        tree.printInorder(tree.root);
        System.out.println();
    }

}
