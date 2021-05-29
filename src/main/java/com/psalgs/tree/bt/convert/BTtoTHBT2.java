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
 * http://www.geeksforgeeks.org/convert-binary-tree-threaded-binary-tree-set-2-efficient/
 *
 * Convert a Binary Tree to Threaded binary tree ( Efficient )
 * 
 * This algorithm works in O(n) time complexity and O(1) 
 *
 */
public class BTtoTHBT2 {

    static class tNode {

        int data;
        tNode left, right;

        // Used to indicate whether the right pointer is a normal
        // right pointer or a pointer to inorder successor.
        boolean isThreaded;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;

    private tNode createThreaded(tNode node) {

        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            return node;
        }

        // Find predecessor if it exists
        if (node.left != null) {
            tNode temp = createThreaded(node.left);
            temp.right = node;
            temp.isThreaded = true;
        }

        if (node.right == null) {
            return node;
        }

        return createThreaded(node.right);
    }

    private void inOrder(tNode node) {
        if (node == null) {
            return;
        }

        // Find the leftmost node in Binary Tree
        tNode cur = leftMost(node);

        while (cur != null) {
            System.out.print(cur.data + " ");

            // If this Node is a thread Node, then go to
            // inorder successor
            if (cur.isThreaded == true) {
                cur = cur.right;
            } else {
                // Else go to the leftmost child in right subtree
                cur = leftMost(cur.right);
            }
        }
        System.out.println();
    }

    private tNode leftMost(tNode node) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String args[]) {
        BTtoTHBT2 tree = new BTtoTHBT2();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);

        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.right.left = new tNode(6);
        tree.root.right.right = new tNode(7);

        tree.createThreaded(tree.root);
        System.out.println("Inorder traversal of created threaded tree");
        tree.inOrder(tree.root);
    }
}
