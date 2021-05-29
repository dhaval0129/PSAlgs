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
 * http://www.geeksforgeeks.org/difference-between-sums-of-odd-and-even-levels/
 *
 * Difference between sums of odd level and even level nodes of a Binary Tree
 *
 * Difference for root is root's data - difference for left subtree - difference
 * for right subtree
 */
public class TreeSum4 {

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

    private int getLevelDiff(tNode node) {
        if (node == null) {
            return 0;
        }

        // Difference for root is root's data - difference for 
        // left subtree - difference for right subtree
        return node.data - getLevelDiff(node.left)
                - getLevelDiff(node.right);
    }

    public static void main(String args[]) {
        TreeSum4 tree = new TreeSum4();
        tree.root = new tNode(5);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(6);
        tree.root.left.left = new tNode(1);
        tree.root.left.right = new tNode(4);
        tree.root.left.right.left = new tNode(3);
        tree.root.right.right = new tNode(8);
        tree.root.right.right.right = new tNode(9);
        tree.root.right.right.left = new tNode(7);
        System.out.println(tree.getLevelDiff(tree.root) + " is required difference");
    }
}
