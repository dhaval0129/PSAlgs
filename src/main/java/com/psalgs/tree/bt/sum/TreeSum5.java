/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.sum;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property/
 *
 * Convert an arbitrary Binary Tree to a tree that holds Children Sum Property
 *  ( Balance the node value depending upon right and left value )
 *
 */
public class TreeSum5 {

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

    private void printInorder(tNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    private void convertTree(tNode node) {
        int left_data = 0, right_data = 0, diff;

        if (node == null || (node.left == null && node.right == null)) {
            return;
        } else {
            /* convert left and right subtrees  */
            convertTree(node.left);
            convertTree(node.right);

            /* If left child is not present then 0 is used
             as data of left child */
            if (node.left != null) {
                left_data = node.left.data;
            }

            /* If right child is not present then 0 is used
             as data of right child */
            if (node.right != null) {
                right_data = node.right.data;
            }

            diff = left_data + right_data - node.data;

            /* If node's children sum is greater than the node's data */
            if (diff > 0) {
                node.data = node.data + diff;
            }

            /* THIS IS TRICKY --> If node's data is greater than children
               sum, then increment subtree by diff */
            if (diff < 0) {
                // -diff is used to make diff value (- x - = + ) positive
                increment(node, -diff);
            }
        }
    }

    private void increment(tNode node, int diff) {

        if (node.left != null) {
            node.left.data = node.left.data + diff;
            increment(node.left, diff);
        } else if (node.right != null) {
            node.right.data = node.right.data + diff;
            increment(node.right, diff);
        }
    }

    public static void main(String args[]) {
        TreeSum5 tree = new TreeSum5();
        tree.root = new tNode(50);
        tree.root.left = new tNode(7);
        tree.root.right = new tNode(2);
        tree.root.left.left = new tNode(3);
        tree.root.left.right = new tNode(5);
        tree.root.right.left = new tNode(1);
        tree.root.right.right = new tNode(30);

        System.out.println("Inorder traversal: ");
        tree.printInorder(tree.root);
        tree.convertTree(tree.root);
        System.out.println("\n Inorder traversal after conversion");
        tree.printInorder(tree.root);
    }
}
