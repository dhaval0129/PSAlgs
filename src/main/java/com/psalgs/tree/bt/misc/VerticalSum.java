/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.misc;

import java.util.HashMap;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
 *
 * Vertical Sum in a given Binary Tree
 *
 */
public class VerticalSum {

    static class TreeNode {

        // data members
        private int key;
        private TreeNode left;
        private TreeNode right;

        // Accessor methods
        public int key() {
            return key;
        }

        public TreeNode left() {
            return left;
        }

        public TreeNode right() {
            return right;
        }

        //constructor
        public TreeNode(int key) {
            this.key = key;
            left = null;
            right = null;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    private TreeNode root;

    public VerticalSum() {
        root = null;
    }

    public VerticalSum(TreeNode n) {
        root = n;
    }

    // Method to be called by the consumer classes 
    // like Main class
    public void VerticalSumMain() {
        VerticalSum(root);
    }

    private void VerticalSum(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }

        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM
                = new HashMap<>();

        // Calls the VerticalSumUtil() to store the 
        // vertical sum values in hM
        VerticalSumUtil(root, 0, hM);

        // Prints the values stored by VerticalSumUtil()
        if (hM != null) {
            System.out.println(hM.entrySet());
        }
    }

    // Traverses the tree in Inoorder form and builds
    // a hashMap hM that contains the vertical sum
    private void VerticalSumUtil(TreeNode node, int hD,
            HashMap<Integer, Integer> hM) {

        // base case
        if (node == null) {
            return;
        }

        // Store the values in hM for left subtree
        VerticalSumUtil(node.left(), hD - 1, hM);

        // update vertical sum for hD of this node
        int prevSum = (hM.get(hD) == null ) ? 0 : hM.get(hD);
        hM.put(hD, prevSum + node.key());
        
        // Store the values in hM for right subtree
        VerticalSumUtil(node.right(), hD + 1, hM);
    }

    public static void main(String[] args) {
        /* Create following Binary Tree
              1
             /\
            2  3
           / \/ \
          4  56  7  
        */
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.left().setLeft(new TreeNode(4));
        root.left().setRight(new TreeNode(5));
        root.right().setLeft(new TreeNode(6));
        root.right().setRight(new TreeNode(7));
        VerticalSum t = new VerticalSum(root);

        System.out.println("Following are the values of"
                + " vertical sums with the positions"
                + " of the columns with respect to root ");
        t.VerticalSumMain();
    }
}
