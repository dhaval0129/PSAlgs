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
 * http://www.geeksforgeeks.org/find-depth-of-the-deepest-odd-level-node/
 *
 * Find depth of the deepest odd level leaf node
 *
 *
 */
public class DeepestOddLevel {

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

    private int depthOfOddLeafUtil(tNode node, int level) {
        // Base Case
        if (node == null) {
            return 0;
        }

        // If this node is a leaf and its level is odd, return its level
        if (node.left == null && node.right == null && (level & 1) != 0) {
            return level;
        }

        // If not leaf, return the maximum value from left and right subtrees
        return Math.max(depthOfOddLeafUtil(node.left, level + 1),
                depthOfOddLeafUtil(node.right, level + 1));
    }

    private int depthOfOddLeaf(tNode node) {
        int level = 1;
        return depthOfOddLeafUtil(node, level);
    }

    public static void main(String args[]) {
        DeepestOddLevel tree = new DeepestOddLevel();
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
        tree.root.right.right.right.right.left = new tNode(11);
        System.out.println(tree.depthOfOddLeaf(tree.root) + " is the required depth");
    }
}
