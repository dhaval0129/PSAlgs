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
 * Time Complexity O(n)
 *
 * The diameter of a tree (sometimes called the width) is the number of nodes on
 * the longest path between two end node
 *
 */
public class TreeDiameter2 {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    class Height {

        int h;
    }

    tNode root;

    private int treeDiameter() {
        Height height = new Height();
        return treeDiameter(root, height);
    }

    // Optimized version O(n)
    private int treeDiameter(tNode node, Height height) {
        /* 
        lh --> Height of left subtree
        rh --> Height of right subtree 
         */
        Height lh = new Height();
        Height rh = new Height();

        /* base case if tree is empty */
        if (node == null) {
            height.h = 0;
            return 0;
        }

//        lh.h++;
//        rh.h++;
        int ldiameter = treeDiameter(node.left, lh);
        int rdiameter = treeDiameter(node.right, rh);

        height.h = Math.max(lh.h, rh.h) + 1;

        return Math.max(lh.h + rh.h + 1,
                Math.max(ldiameter, rdiameter));
    }

    public static void main(String args[]) {
        TreeDiameter2 tree = new TreeDiameter2();
        tree.root = new tNode(1);
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);

        System.out.println("The diameter of given binary tree is : " + tree.treeDiameter());
    }
}
