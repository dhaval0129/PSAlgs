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
 * http://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
 *
 * Sum of all the numbers that are formed from root to leaf paths
 *
 */
public class TreeSum2 {

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

    private int treeSumPathsUtil(tNode node, int val) {
        // base case
        if (node == null) {
            return 0;
        }

        val = (val * 10 + node.data);

        if (node.left == null && node.right == null) {
            return val;
        }

        return treeSumPathsUtil(node.left, val)
                + treeSumPathsUtil(node.right, val);

    }

    private int treePathsSum(tNode node) {
        return treeSumPathsUtil(node, 0);
    }

    public static void main(String args[]) {
        TreeSum2 tree = new TreeSum2();
        tree.root = new tNode(6);
        tree.root.left = new tNode(3);
        tree.root.right = new tNode(5);
        tree.root.right.right = new tNode(4);
        tree.root.left.left = new tNode(2);
        tree.root.left.right = new tNode(5);
        tree.root.left.right.right = new tNode(4);
        tree.root.left.right.left = new tNode(7);

        System.out.print("Sum of all paths is " + tree.treePathsSum(tree.root) + "\n");
    }

}
