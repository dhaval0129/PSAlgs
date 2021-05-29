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
 * http://www.geeksforgeeks.org/deepest-left-leaf-node-in-a-binary-tree/
 *
 * Deepest left leaf node in a binary tree
 *
 * Time Complexity O(n)
 *
 */
public class DeepestLL {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    static class Level {

        int maxlevel = 0;
    }

    tNode root, result;

    private void deepestLeftLeafUtil(tNode node, int lvl,
            Level level, boolean isLeft) {
        // Base case
        if (node == null) {
            return;
        }

        // Update result if this node is left leaf and its level is more
        // than the maxl level of the current result
        if (isLeft != false && node.left == null
                && node.right == null && lvl > level.maxlevel) {
            result = node;
            level.maxlevel = lvl;
        }

        //Recur for left and right subtrees
        deepestLeftLeafUtil(node.left, lvl + 1, level, true);
        deepestLeftLeafUtil(node.right, lvl + 1, level, false);
    }

    private void deepestLeftLeaf(tNode node) {
        Level level = new Level();
        deepestLeftLeafUtil(node, level.maxlevel, level, false);
    }

    public static void main(String args[]) {
        DeepestLL tree = new DeepestLL();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.right.left = new tNode(5);
        tree.root.right.right = new tNode(6);
        tree.root.right.left.right = new tNode(7);
        tree.root.right.right.right = new tNode(8);
        tree.root.right.left.right.left = new tNode(9);
        tree.root.right.right.right.right = new tNode(10);

        tree.deepestLeftLeaf(tree.root);
        if (tree.result != null) {
            System.out.println("The deepest left child is " + tree.result.data);
        } else {
            System.out.println("There is no left leaf in the given tree");
        }
    }
}
