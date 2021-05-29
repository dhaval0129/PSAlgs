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
 * http://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
 *
 * Maximum Path Sum in a Binary Tree
 *
 */
public class MaxPathSum {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    // An object of Res is passed around so that the
    // same value can be used by multiple recursive calls.
    class Res {

        public int val;
    }

    tNode root;

    private int findMaxSum() {
        return findMaxSum(root);
    }

    private int findMaxSum(tNode node) {
        // Initialize result
        // int res2 = Integer.MIN_VALUE;
        Res res = new Res();
        res.val = Integer.MIN_VALUE;

        // Compute and return result
        findMaxUtil(node, res);
        return res.val;
    }

    // This function returns overall maximum path sum in 'res'
    // And returns max path sum going through root.
    private int findMaxUtil(tNode node, Res res) {
        // Base Case
        if (node == null) {
            return 0;
        }

        // l and r store maximum path sum going through left and
        // right child of root respectively
        int l = findMaxUtil(node.left, res);
        int r = findMaxUtil(node.right, res);

        // Max path for parent call of root. This path must
        // include at-most one child of root
        int max_single = Math.max(Math.max(l, r) + node.data, node.data);

        // Max Top represents the sum when the Node under
        // consideration is the root of the maxsum path and no
        // ancestors of root are there in max sum path
        int max_top = Math.max(max_single, l + r + node.data);

        // Store the Maximum Result.
        res.val = Math.max(res.val, max_top);
          // This can be used as well
//          res.val = Math.max(res.val, l + r + node.data);
        return max_single;
    }

    public static void main(String args[]) {
        MaxPathSum tree = new MaxPathSum();
        tree.root = new tNode(10);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(10);
        tree.root.left.left = new tNode(20);
        tree.root.left.right = new tNode(1);
        tree.root.right.right = new tNode(-25);
        tree.root.right.right.left = new tNode(3);
        tree.root.right.right.right = new tNode(4);
        System.out.println("maximum path sum is : " + tree.findMaxSum());
    }

}
