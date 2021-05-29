/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.heap;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-heap/
 *
 * Check if a given Binary Tree is Heap
 *
 * 1] It should be a complete tree (i.e. all levels except last should be full).
 * 2] Every node’s value should be greater than or equal to its child node.
 * (considering max-heap).
 *
 */
public class BTisHeap {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;

    private int countNodes(tNode node) {
        // base case
        if (node == null) {
            return 0;
        }

        return (1 + countNodes(node.left) + countNodes(node.right));
    }

    // 1] This method checks if BT is complete binary tree
    private boolean isCompleteUtil(tNode node, int index, int number_nodes) {
        // base case
        if (node == null) {
            return true;
        }

        if (index >= number_nodes) {
            return false;
        }

        return (isCompleteUtil(node.left, 2 * index + 1, number_nodes)
                && isCompleteUtil(node.right, 2 * index + 2, number_nodes));
    }

    // 2] This method checks if BT is max heap
    private boolean isHeapUtil(tNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }

        if (node.right == null) {
            return true;
        } else if (node.data >= node.left.data && node.data >= node.right.data) {
            return isHeapUtil(node.left) && isHeapUtil(node.right);
        } else {
            return false;
        }

    }

    private boolean isHeap(tNode node) {
        if (node == null) {
            return true;
        }

        int node_count = countNodes(node);

        if (isCompleteUtil(node, 0, node_count) && isHeapUtil(node)) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        BTisHeap tree = new BTisHeap();
        tNode root = new tNode(10);
        root.left = new tNode(9);
        root.right = new tNode(8);
        root.left.left = new tNode(7);
        root.left.right = new tNode(6);
        root.right.left = new tNode(5);
        root.right.right = new tNode(4);
        root.left.left.left = new tNode(3);
        root.left.left.right = new tNode(2);
        root.left.right.left = new tNode(1);

        if (tree.isHeap(root) == true) {
            System.out.println("Given binary tree is a Heap");
        } else {
            System.out.println("Given binary tree is not a Heap");
        }
    }
}
