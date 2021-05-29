/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.misc;

/**
 *
 * @author djoshi
 * 
 * http://www.geeksforgeeks.org/write-a-c-program-to-get-count-of-leaf-nodes-in-a-binary-tree/
 * 
 * Program to count leaf nodes in a binary tree
 * 
 */
public class CountLeaf {

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

    private int getLeafCount(tNode node) {

        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        } else {
            int left = getLeafCount(node.left);
            int right = getLeafCount(node.right);
            return left + right;
        }
    }

    public static void main(String args[]) {
        /* create a tree */
        CountLeaf tree = new CountLeaf();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);

        /* get leaf count of the abve tree */
        System.out.println("The leaf count of binary tree is : " 
            + tree.getLeafCount(tree.root));
    }

}
