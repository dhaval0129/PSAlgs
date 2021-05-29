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
 * http://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
 *
 * Find the maximum path sum between two leaves of a binary tree
 *
 */
public class MaxSumLeaf2 {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    // Result
    class Res {

        int val;
    }

    tNode root;

    // A utility function to find the maximum sum between any
    // two leaves.This function calculates two values:
    
    // 1) Maximum path sum between two leaves which is stored in res.
    // 2) The maximum root to leaf path sum which is returned.
    // 3) If one side of root is empty, then it returns INT_MIN
    private int maxPathSumUtil(tNode node, Res res) {
        // Base cases
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return node.data;
        }

        // Find maximum sum in left and right subtree. Also
        // find maximum root to leaf sums in left and right
        // subtrees and store them in ls and rs
        int ls = maxPathSumUtil(node.left, res);
        int rs = maxPathSumUtil(node.right, res);

        if (node.left != null && node.right != null) {
            // update result if needed
            // case 1] 
            // Use of case 1] is at the end to calculate left and right sum
            res.val = Math.max(res.val, ls + rs + node.data);

            // Return maxium possible value for root being
            // on one side
            // case 2]
            return Math.max(ls, rs) + node.data;
        }

        // If any of the two children is empty, return
        // root sum for root being on one side
        // case 3]
        return (node.left == null) ? rs + node.data
                : ls + node.data;
    }

    private int maxPathSum() {
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
        maxPathSumUtil(root, res);
        return res.val;
    }

    public static void main(String args[]) {
        MaxSumLeaf2 tree = new MaxSumLeaf2();
        tree.root = new tNode(-15);
        tree.root.left = new tNode(5);
        tree.root.right = new tNode(6);
        tree.root.left.left = new tNode(-8);
        tree.root.left.right = new tNode(1);
        tree.root.left.left.left = new tNode(2);
        tree.root.left.left.right = new tNode(6);
        tree.root.right.left = new tNode(3);
        tree.root.right.right = new tNode(9);
        tree.root.right.right.right = new tNode(0);
        tree.root.right.right.right.left = new tNode(4);
        tree.root.right.right.right.right = new tNode(-1);
        tree.root.right.right.right.right.left = new tNode(10);
        System.out.println("Max pathSum of the given binary tree is "
                + tree.maxPathSum());
    }
}
