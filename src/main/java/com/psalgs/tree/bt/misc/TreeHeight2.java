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
 * http://www.geeksforgeeks.org/find-height-binary-tree-represented-parent-array/
 * 
 * Find Height of Binary Tree represented by Parent array
 * 
 */
public class TreeHeight2 {

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

    private void fillDepth(int parent[], int i, int depth[]) {
        // If depth[i] is already filled
        if (depth[i] != 0) {
            return;
        }

        // If node at index i is root
        if (parent[i] == -1) {
            depth[i] = 1;
            return;
        }

        // If depth of parent is not evaluated before, then evaluate
        // depth of parent first
        // if condition is just to be on safer side
        if (depth[parent[i]] == 0) {
            fillDepth(parent, parent[i], depth);
        }

        // Depth of this node is depth of parent plus 1
        depth[i] = depth[parent[i]] + 1;

    }

    private int findHeight(int parent[], int n) {
        // Create an array to store depth of all nodes/ and
        // initialize depth of every node as 0 (an invalid
        // value). Depth of root is 1
        int depth[] = new int[n];
        for (int i = 0; i < n; i++) {
            depth[i] = 0;
        }

        // fill depth of all nodes
        for (int i = 0; i < n; i++) {
            fillDepth(parent, i, depth);
        }

        // The height of binary tree is maximum of all depths.
        // Find the maximum value in depth[] and assign it to ht.
        int ht = depth[0];
        for (int i = 1; i < n; i++) {
            if (ht < depth[i]) {
                ht = depth[i];
            }
        }
        return ht;
    }

    public static void main(String args[]) {
        TreeHeight2 tree = new TreeHeight2();
        int parent[] = {-1, 0, 0, 1, 1, 3, 5};

        int n = parent.length;
        System.out.println("Height is  " + tree.findHeight(parent, n));
    }
}
