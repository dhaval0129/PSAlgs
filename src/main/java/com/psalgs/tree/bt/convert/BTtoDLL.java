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
 * http://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-doubly-linked-list/
 *
 * Convert a given Binary Tree to Doubly Linked List
 *
 */
public class BTtoDLL {

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

    private void printList(tNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
        System.out.println();
    }

    private tNode bintree2list(tNode node) {
        // Base case
        if (node == null) {
            return node;
        }

        // Convert to DLL using bintree2listUtil()
        node = bintree2listUtil(node);

        // bintree2listUtil() returns root node of the converted
        // DLL.  We need pointer to the leftmost node which is
        // head of the constructed DLL, so move to the leftmost node
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    private tNode bintree2listUtil(tNode node) {
        // Base case
        if (node == null) {
            return node;
        }

        // Convert the left subtree and link to root
        if (node.left != null) {
            tNode left = bintree2listUtil(node.left);
            // Find inorder predecessor. After this loop, left
            // will point to the inorder predecessor
            while (left.right != null) {
                left = left.right;
            }
            // Make root as next of the predecessor
            left.right = node;
            // Make predecssor as previous of root
            node.left = left;
        }

        // Convert the right subtree and link to root
        if (node.right != null) {
            // Convert the right subtree
            tNode right = bintree2listUtil(node.right);

            // Find inorder successor. After this loop, right
            // will point to the inorder successor
            while (right.left != null) {
                right = right.left;
            }
            // Make root as previous of successor
            right.left = node;
            // Make successor as next of root
            node.right = right;
        }

        return node;
    }

    public static void main(String[] args) {
        BTtoDLL tree = new BTtoDLL();

        // Let us create the tree shown in above diagram
        tree.root = new tNode(10);
        tree.root.left = new tNode(12);
        tree.root.right = new tNode(15);
        tree.root.left.left = new tNode(25);
        tree.root.left.right = new tNode(30);
        tree.root.right.left = new tNode(36);

        // Convert to DLL
        tNode head = tree.bintree2list(tree.root);

        // Print the converted list
        tree.printList(head);
    }
}
