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
 * https://www.geeksforgeeks.org/continuous-tree/
 *
 * A tree is Continuous tree if in each root to leaf path, absolute difference
 * between keys of two adjacent is 1
 *
 */
public class TreeContinious {

    static class Node {

        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    static Node root;

    private static boolean treeContinious(Node node) {

        if (node == null) {
            return true;
        }

        // if current node is leaf node then return true 
        // because it is end of root to leaf path 
        if (node.left != null && node.right != null) {
            return true;
        }

        // If left subtree is empty, then only check right 
        if (node.left == null) {
            return (Math.abs(node.key - node.right.key) == 1)
                    && treeContinious(node.right);
        }

        // If left subtree is empty, then only check right 
        if (node.right == null) {
            return (Math.abs(node.key - node.left.key) == 1)
                    && treeContinious(node.left);
        }

        // If both left and right nodes are not empty, check everything
        return Math.abs(node.key - node.left.key) == 1
                && Math.abs(node.key - node.right.key) == 1
                && treeContinious(node.left)
                && treeContinious(node.right);

    }

    public static void main(String args[]) {
        root = new Node(31);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(5);


        if (treeContinious(root)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
