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
 * http://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
 *
 * Level order traversal in spiral form
 *
 */
public class SpiralForm {

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

    private int heightTree(tNode node) {

        if (node == null) {
            return 0;
        }

        int left = heightTree(node.left);
        int right = heightTree(node.right);

        if (left > right) {
            return (left + 1);
        } else {
            return (right + 1);
        }
    }

    private void printSpiral(tNode node) {
        int h = heightTree(node);
        boolean ltr = false;

        for (int i = 1; i <= h; i++) {
            printGivenLevel(node, i, ltr);
            ltr = !ltr;
        }
        System.out.println();
    }

    private void printGivenLevel(tNode node, int level, boolean ltr) {
        if (node == null) {
            return;
        }

        if (level == 1) {
            System.out.print(node.data +" ");
        } else if (level > 1) {
            if (ltr != false) {
                printGivenLevel(node.left, level - 1, ltr);
                printGivenLevel(node.right,level - 1, ltr);
            } else {
                printGivenLevel(node.right,level - 1, ltr);
                printGivenLevel(node.left, level - 1, ltr);
            }
        }
    }

    public static void main(String args[]) {
        SpiralForm tree = new SpiralForm();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.right.left = new tNode(6);
        tree.root.right.right = new tNode(7);
        System.out.println("Spiral order traversal of Binary Tree is ");
        tree.printSpiral(tree.root);
    }
}
