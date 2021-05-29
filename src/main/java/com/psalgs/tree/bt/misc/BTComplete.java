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
 * http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-complete-tree-or-not/
 *
 * http://www.geeksforgeeks.org/check-whether-binary-tree-complete-not-set-2-recursive-solution/
 *
 * Check whether a given Binary Tree is Complete or not
 *
 * A complete binary tree is a binary tree in which every level, except possibly
 * the last, is completely filled, and all nodes are as far left as possible.
 *
 * Time Complexity : O(n)
 * 
 */
public class BTComplete {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
            right = left = null;
        }
    }

    tNode root;

    private int countNodes(tNode node) {
        if (node == null) {
            return 0;
        }

        return (1 + countNodes(node.left) + countNodes(node.right));
    }

    private boolean isComplete(tNode node, int index, int no_nodes) {
        // An empty tree is complete
        if (node == null) {
            return true;
        }

        // If index assigned to current node is more than
        // number of nodes in tree, then tree is not complete
        if (index >= no_nodes) {
            return false;
        }

        return (isComplete(node.left, 2 * index + 1, no_nodes)
            && isComplete(node.right, 2 * index + 2, no_nodes));
    }

    public static void main(String args[]) {
        BTComplete tree = new BTComplete();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
//        tree.root.right.right = new tNode(6);

        int node_count = tree.countNodes(tree.root);
        int index = 0;

        if (tree.isComplete(tree.root, index, node_count)) {
            System.out.println("The binary tree is complete");
        } else {
            System.out.println("The binary tree is not complete");
        }
    }
}
