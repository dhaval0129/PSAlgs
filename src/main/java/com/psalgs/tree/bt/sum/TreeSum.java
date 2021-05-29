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
 * http://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
 *
 * Check for Children Sum Property in a Binary Tree
 *
 */
public class TreeSum {

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

    private int isSumProperty(tNode node) {

        int left_data = 0, right_data = 0;

        if (node == null
                || (node.left == null && node.right == null)) {
            return 1;
        } else {
            /* If left child is not present then 0 is used
               as data of left child */
            if (node.left != null) {
                left_data = node.left.data;
            }

            if (node.right != null) {
                right_data = node.right.data;
            }

            if ((node.data == left_data + right_data)
                    && (isSumProperty(node.left) != 0)
                    && (isSumProperty(node.right) != 0)) {
                return 1;
            } else {
                return 0;
            }
        }

    }

    public static void main(String args[]) {
        TreeSum tree = new TreeSum();
        tree.root = new tNode(10);
        tree.root.left = new tNode(8);
        tree.root.right = new tNode(2);
        tree.root.left.left = new tNode(3);
        tree.root.left.right = new tNode(5);
        tree.root.right.left = new tNode(2);
        if(tree.isSumProperty(tree.root) != 0 ) {
            System.out.println("The given tree satisfies children sum property");
        } else {
            System.out.println("The given tree does not satisfies children sum property");
        }
    }
}
