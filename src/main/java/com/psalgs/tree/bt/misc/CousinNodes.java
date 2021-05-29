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
 * http://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/
 * 
 * Check if two nodes are cousins in a Binary Tree
 * 
 * Note: first check if nodes are at same level and 
 * then check if they do not have common parents
 */
public class CousinNodes {

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

    private boolean isSibling(tNode node, tNode a, tNode b) {
        // Base case
        if (node == null) {
            return false;
        }

        return ((node.left == a && node.right == b)
            || (node.left == b && node.right == a)
            || isSibling(node.left, a, b)
            || isSibling(node.right, a, b));
    }

    private int level(tNode node, tNode ptr, int lev) {
        // base cases
        if (node == null) {
            return 0;
        }

        if (node == ptr) {
            return lev;
        }

        int l = level(node.left, ptr, lev + 1);
        if (l != 0) {
            return l;
        }
        return level(node.right, ptr, lev + 1);
    }

    private boolean isCousin(tNode node, tNode a, tNode b) {
        // 1. The two Nodes should be on the same level
        //       in the binary tree.
        // 2. The two Nodes should not be siblings (means
        //    that they should not have the same parent
        //    Node).
        return ((level(node, a, 1) == level(node, b, 1))
                && (!isSibling(node, a, b)));
    }

    public static void main(String args[]) {
        CousinNodes tree = new CousinNodes();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.left.right.right = new tNode(15);
        tree.root.right.left = new tNode(6);
        tree.root.right.right = new tNode(7);
        tree.root.right.left.right = new tNode(8);

        tNode Node1, Node2;
        Node1 = tree.root.left.left;
        Node2 = tree.root.right.right;

        if (tree.isCousin(tree.root, Node1, Node2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
