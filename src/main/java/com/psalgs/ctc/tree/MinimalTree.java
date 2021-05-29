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
 * Given a sorted (increasing order) array with unique integer elements, write
 * an algorithm to create a binary search tree with minimal height
 *
 * https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
 *
 */
public class MinimalTree {

    class Node {

        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static Node root;

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private Node sortedArrayToBST(int arr[], int start, int end) {
        // Base case
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);

        // recursively construct the left subtree
        // make it left child of root
        node.left = sortedArrayToBST(arr, start, mid - 1);

        // recursively construct the right subtree 
        // make it right child of root
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }

    public static void main(String args[]) {
        MinimalTree mt = new MinimalTree();
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        root = mt.sortedArrayToBST(arr, 0, n - 1);
        System.out.println("\nPreorder traversal of constructed BST");
        mt.preOrder(root);
    }

}
