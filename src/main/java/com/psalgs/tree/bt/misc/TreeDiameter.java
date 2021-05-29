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
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 *
 * Diameter of a Binary Tree or width of binary tree is maximum distance between
 * two leaf nodes
 *
 * Time Complexity: O(n^2) as it travels every time till bottom to find the
 * height
 *
 * The diameter of a tree (sometimes called the width) is the number of nodes on
 * the longest path between two end node
 *
 */
public class TreeDiameter {

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

    private int treeDiameter() {
        return diameter(root);
    }

    private int diameter(tNode node) {
        /* base case if tree is empty */
        if (node == null) {
            return 0;
        }

        /* get the height of left and right sub trees */
        int lheight = height(node.left);
        int rheight = height(node.right);

        /* get the diameter of left and right subtrees */
        int ldiameter = diameter(node.left);
        int rdiameter = diameter(node.right);

        // first find max between left and right diameter 
        // then find max between left + right height and max diameter 
        return Math.max(lheight + rheight + 1,
                Math.max(ldiameter, rdiameter));
    }

    private int height(tNode node) {
        /* base case tree is empty */
        if (node == null) {
            return 0;
        }

        /* If tree is not empty then height = 1 + max of left
           height and right heights */
        return (1 + Math.max(height(node.left), height(node.right)));
    }

    public static void main(String args[]) {
        TreeDiameter tree = new TreeDiameter();
        tree.root = new tNode(1);
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);

        System.out.println("The diameter of given binary tree is : " + tree.treeDiameter());
    }

}
