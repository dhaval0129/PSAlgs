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
 * http://www.geeksforgeeks.org/find-maximum-or-minimum-in-binary-tree/
 *
 * Find maximum (or minimum) in Binary Tree
 *
 */
public class FindMaxElement {

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

    private int findMax(tNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int result = node.data;
        int left = findMax(node.left);
        int right = findMax(node.right);

        if (left > result) {
            result = left;
        }

        if (right > result) {
            result = right;
        }
        return result;
    }

    public static void main(String args[]) {
        FindMaxElement tree = new FindMaxElement();
        tree.root = new tNode(2);
        tree.root.left = new tNode(7);
        tree.root.right = new tNode(5);
        tree.root.left.right = new tNode(6);
        tree.root.left.right.left = new tNode(1);
        tree.root.left.right.right = new tNode(11);
        tree.root.right.right = new tNode(9);
        tree.root.right.right.left = new tNode(4);

        System.out.print("Minimum element in tree: " + tree.findMax(tree.root) + "\n");
    }
}
