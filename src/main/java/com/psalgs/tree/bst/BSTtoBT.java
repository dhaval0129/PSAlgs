/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bst;

/**
 *
 * @author djoshi
 * 
 * http://www.geeksforgeeks.org/convert-bst-to-a-binary-tree/
 * 
 * Convert a BST to a Binary Tree such that sum of all greater keys is added to every key
 * 
 */
public class BSTtoBT {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    static class Sum {

        int sum = 0;
    }

    tNode root;
    Sum s = new Sum();

    private void printInorder(tNode node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    private tNode addGreater(tNode node) {
        addGreaterUtil(node, s);
        return node;
    }

    private void addGreaterUtil(tNode node, Sum s) {
        if (node == null) {
            return;
        }

        addGreaterUtil(node.right, s);
        s.sum += node.data;
        node.data = s.sum;
        addGreaterUtil(node.left, s);
    }

    public static void main(String args[]) {
        BSTtoBT tree = new BSTtoBT();
        tree.root = new tNode(5);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(13);

        System.out.println("Inorder traversal of given tree ");
        tree.printInorder(tree.root);
        tNode node = tree.addGreater(tree.root);
        System.out.println();
        System.out.println("Inorder traversal of modified tree ");
        tree.printInorder(node);
        System.out.println();
    }

}
