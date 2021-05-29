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
 * http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
 *
 * Check if a given Binary Tree is SumTree
 *
 */
public class TreeSum3 {

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

    private int isLeaf(tNode node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        return 0;
    }

    private int isSumTree(tNode node) {
        int ls;
        int rs;

        if (node == null || isLeaf(node) == 1) {
            return 1;
        }

        // Time Complexity O(n)
        if (isSumTree(node.left) != 0 && isSumTree(node.right) != 0) {
            // Get the sum of nodes in left subtree
            if (node.left == null) {
                ls = 0;
            } else if (isLeaf(node.left) != 0) {
                ls = node.left.data;
            } else {
                ls = 2 * (node.left.data);
            }

            // Get the sum of nodes in right subtree
            if (node.right == null) {
                rs = 0;
            } else if (isLeaf(node.right) != 0) {
                rs = node.right.data;
            } else {
                rs = 2 * (node.right.data);
            }

            /* If root's data is equal to sum of nodes in left
               and right subtrees then return 1 else return 0*/
            if ((node.data == rs + ls)) {
                return 1;
            } else {
                return 0;
        
            }
        }

        return 0;
    }

    public static void main(String args[]) {
        TreeSum3 tree = new TreeSum3();
        tree.root = new tNode(26);
        tree.root.left = new tNode(10);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(6);
        tree.root.right.right = new tNode(3);

        if (tree.isSumTree(tree.root) != 0) {
            System.out.println("The given tree is a sum tree");
        } else {
            System.out.println("The given tree is not a sum tree");
        }
    }
}
