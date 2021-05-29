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
 * http://www.geeksforgeeks.org/get-level-of-a-node-in-a-binary-tree/
 * 
 * 
 * Find Level of the node
 */
public class NodeLevel {

    static class tNode {

        int data;
        tNode right;
        tNode left;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;
    int height = 0;

    private void getLevelOfNode(tNode node, int data, int h) {
        if (node == null) {
            return;
        }

        if (node.data == data) {
            this.height = h;
        }
        ++h;
        getLevelOfNode(node.left, data, h);
        getLevelOfNode(node.right, data, h);
    }

    public static void main(String args[]) {
        NodeLevel tree = new NodeLevel();
        /* Constructed binary tree is
                1
              /   \
             2     3
            / \   /
           4   5 8 
         */
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.right.left = new tNode(8);
        tree.getLevelOfNode(tree.root, 5, 1);
        
        if (tree.height == 0) {
            System.out.println("data not found");
        } else {
            System.out.println("Height: " + tree.height);
        }
    }
}
