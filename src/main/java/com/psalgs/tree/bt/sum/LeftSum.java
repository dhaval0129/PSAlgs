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
 * http://www.geeksforgeeks.org/find-sum-left-leaves-given-binary-tree/
 *
 * Find sum of all left leaves in a given Binary Tree
 */
public class LeftSum {

    static class tNode {

        int data;
        int vd;
        tNode left, right;

        tNode(int d) {
            data = d;
            right = left = null;
        }
    }

    tNode root;
    int sum;

    // A utility function to check if a given node is leaf or not
    private boolean isLeaf(tNode node) {
        if (node == null) {
            return false;
        }

        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

    private int leftLeavesSum(tNode node) {
        int res = 0;

        if (node != null) {
            // If left of root is NULL, then add key of
            // left child
            if (isLeaf(node.left)) {
                res += node.left.data;
            } else {
                res += leftLeavesSum(node.left);
            }
            
            res += leftLeavesSum(node.right);
        }

        // result
        return res;
    }

    public static void main(String args[]) {
        LeftSum tree = new LeftSum();
        tree.root = new tNode(20);
        tree.root.left = new tNode(9);
        tree.root.right = new tNode(49);
        tree.root.left.right = new tNode(12);
        tree.root.left.left = new tNode(5);
        tree.root.right.left = new tNode(23);
        tree.root.right.right = new tNode(52);
        tree.root.left.right.right = new tNode(12);
        tree.root.right.right.left = new tNode(50);

        System.out.println("The sum of leaves is " + tree.leftLeavesSum(tree.root));
    }
}
