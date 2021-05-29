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
 * http://www.geeksforgeeks.org/change-a-binary-tree-so-that-every-node-stores-sum-of-all-nodes-in-left-subtree/
 *
 * Change a Binary Tree so that every node stores sum of all nodes in left
 * subtree
 *
 */
public class LNodeSum {

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

    private int leftNodeSum(tNode node) {
        // Base cases
        if (node == null) {
            return 0;
        }

        if (node.right == null && node.right == null) {
            return node.data;
        }

        // Update left and right subtrees
        int leftSum = leftNodeSum(node.left);
        int rightSum = leftNodeSum(node.right);

        // Add leftsum to current node
        node.data += leftSum;

        // Return sum of values under root
        return node.data + rightSum;
    }

    private void inOrder(tNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void main(String args[]) {
        LNodeSum tree = new LNodeSum();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.right.right = new tNode(6);

        tree.leftNodeSum(tree.root);
        tree.inOrder(tree.root);
        System.out.println();
    }
}
