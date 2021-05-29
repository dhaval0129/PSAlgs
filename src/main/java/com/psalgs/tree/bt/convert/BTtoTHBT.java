/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.convert;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/convert-binary-tree-threaded-binary-tree/
 *
 * Convert a Binary Tree to Threaded binary tree (Using Queue)
 *
 * In a simple threaded binary tree, the NULL right pointers are used to store
 * in-order successor. Where-ever a right pointer is NULL, it is used to store
 * in-order successor. The idea of threaded binary trees is to make in-order
 * traversal faster and do it without stack and without recursion.
 *
 */
public class BTtoTHBT {

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

    private void createThreaded(tNode node) {
        // Create a queue to store inorder traversal
        Queue<tNode> q = new LinkedList<>();

        // Store inorder traversal in queue
        populateQueue(node, q);

        // Link NULL right pointers to inorder successor
        createThreadedUtil(node, q);
    }

    private void createThreadedUtil(tNode node, Queue<tNode> q) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            createThreadedUtil(node.left, q);
        }
        q.remove();

        if (node.right != null) {
            createThreadedUtil(node.right, q);
        } else {
            // If right pointer is NULL, link it to the
            // inorder successor and set 'isThreaded' bit.
            node.right = q.peek();
            node.isThreaded = true;
        }

    }

    private void populateQueue(tNode node, Queue<tNode> q) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            populateQueue(node.left, q);
        }
        q.add(node);
        if (node.right != null) {
            populateQueue(node.right, q);
        }
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
        BTtoTHBT tree = new BTtoTHBT();
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
