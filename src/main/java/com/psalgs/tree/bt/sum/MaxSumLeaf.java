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
 * http://www.geeksforgeeks.org/find-the-maximum-sum-path-in-a-binary-tree/
 *
 * Find the maximum sum leaf to root path in a Binary Tree
 *
 */
public class MaxSumLeaf {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    static class Maximum {
        int max_no = Integer.MIN_VALUE;
    }

    tNode root;
    tNode target_leaf = null;
    Maximum max = new Maximum();

    // A utility function that prints all nodes on the
    // path from root to target_leaf
    private boolean printPath(tNode node, tNode target_leaf) {
        // base case
        if (node == null) {
            return false;
        }

        if (node == target_leaf || printPath(node.left, target_leaf)
                || printPath(node.right, target_leaf)) {
            System.out.print(node.data + " ");
            return true;
        }
        return false;
    }

    // This function sets the target_leaf_ref to refer
    // the leaf node of the maximum path sum. Also,
    // returns the max_sum using max_sum_ref
    private void getTargetLeaf(tNode node, Maximum max_sum_ref,
            int curr_sum) {

        if (node == null) {
            return;
        }

        curr_sum += node.data;

        if (node.left == null && node.right == null) {
            if (curr_sum > max_sum_ref.max_no) {
                max_sum_ref.max_no = curr_sum;
                target_leaf = node;
            }
        }

        // If this is not a leaf node, then recur down
        // to find the target_leaf
        getTargetLeaf(node.left, max_sum_ref, curr_sum);
        getTargetLeaf(node.right, max_sum_ref, curr_sum);
    }

    private int maxSumPath() {
        // base case
        if (root == null) {
            return 0;
        }

        // find the target leaf and maximum sum
        getTargetLeaf(root, max, 0);

        // print the path from root to the target leaf
        printPath(root, target_leaf);
        return max.max_no; // return maximum sum
    }

    public static void main(String args[]) {
        MaxSumLeaf tree = new MaxSumLeaf();
        tree.root = new tNode(10);
        tree.root = new tNode(10);
        tree.root.left = new tNode(-2);
        tree.root.right = new tNode(7);
        tree.root.left.left = new tNode(8);
        tree.root.left.right = new tNode(-4);

        System.out.println("Following are the nodes on maximum sum path");
        int sum = tree.maxSumPath();
        System.out.println("");
        System.out.println("Sum of nodes is : " + sum);
    }
}
