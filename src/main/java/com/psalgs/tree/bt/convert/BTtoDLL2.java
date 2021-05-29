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
 * http://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-2/
 *
 * Convert a given Binary Tree to Doubly Linked List
 *
 */
public class BTtoDLL2 {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    static tNode root, prev;

    // Standard Inorder traversal of tree
    private static void inorder(tNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Traverses the DLL from left tor right
    private static void printlist(tNode root) {
        while (root != null) {
            System.out.print(root.data + " ");
            root = root.right;
        }
        System.out.println();
    }

    private static void fixPrevPtr(tNode root) {
        if (root == null) {
            return;
        }

        fixPrevPtr(root.left);
        root.left = prev;
        prev = root;
        fixPrevPtr(root.right);
    }

    private static tNode fixNextPtr(tNode root) {
        // BT or last node in DLL
        while (root.right != null) {
            root = root.right;
        }

        // Start from the rightmost node, traverse 
        // back using left pointers. While traversing, 
        // change right pointer of nodes
        while (root != null && root.left != null) {
            tNode left = root.left;
            left.right = root;
            root = root.left;
        }

        // The leftmost node is head of linked list, return it
        return root;
    }

    private static tNode BTtoDLL(tNode root) {
        prev = null;

        // Set the previous pointer
        fixPrevPtr(root);
        // set next pointer and return head of DLL
        return fixNextPtr(root);
    }

    public static void main(String args[]) {
        BTtoDLL2 tree = new BTtoDLL2();

        // Let us create the tree shown in above diagram
        tree.root = new tNode(10);
        tree.root.left = new tNode(12);
        tree.root.right = new tNode(15);
        tree.root.left.left = new tNode(25);
        tree.root.left.right = new tNode(30);
        tree.root.right.left = new tNode(36);

        System.out.println("Inorder Tree Traversal");
        inorder(tree.root);

        tNode head = tree.BTtoDLL(root);

        System.out.println("\nDLL Traversal");
        printlist(head);
    }
}
