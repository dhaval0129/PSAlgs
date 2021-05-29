/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.convert;

/**
 *
 * @author djoshi
 * 
 * http://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
 * 
 * Convert a given Binary Tree to Doubly Linked List
 * 
 */
public class BTtoDLL3 {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    static tNode root, head;
    static tNode prev = null;

    /* Function to print nodes in a given doubly linked list */
    private void printList(tNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
        System.out.println();
    }

    private void BTtoDLL(tNode root) {
        // Base case
        if (root == null) {
            return;
        }

        // recursively convert left subtree
        BTtoDLL(root.left);

        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        // finally recursively convert right sibtree
        BTtoDLL(root.right);
    }

    public static void main(String args[]) {
        // Let us create the tree as shown in above diagram
        BTtoDLL3 tree = new BTtoDLL3();
        tree.root = new tNode(10);
        tree.root.left = new tNode(12);
        tree.root.right = new tNode(15);
        tree.root.left.left = new tNode(25);
        tree.root.left.right = new tNode(30);
        tree.root.right.left = new tNode(36);

        // convert to DLL
        tree.BTtoDLL(tree.root);

        // Print the converted List
        tree.printList(tree.head);
    }
}
