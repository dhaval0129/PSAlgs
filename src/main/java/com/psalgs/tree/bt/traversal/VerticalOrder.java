/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.traversal;

/**
 *
 * @author djoshi
 * 
 * http://www.geeksforgeeks.org/print-binary-tree-vertical-order/
 * 
 * Print a Binary Tree in Vertical Order
 * 
 * Time Complexity O(n ^ 2)
 * 
 */
public class VerticalOrder {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
            right = left = null;
        }
    }

    class Values {

        int max, min;
    }

    tNode root;
    Values val = new Values();

    private void findMinMax(tNode node, Values min, Values max, int hd) {
        // Base case
        if (node == null) {
            return;
        }

        //update min and max
        if (hd < min.min) {
            min.min = hd;
        } else if (hd > max.max) {
            max.max = hd;
        }

        // Recur for left and right subtrees
        findMinMax(node.left, min, max, hd - 1);
        findMinMax(node.right, min, max, hd + 1);
    }

    private void printVerticalLine(tNode node, int line_no, int hd) {

        if (node == null) {
            return;
        }

        // If this node is on the given line number
        if (hd == line_no) {
            System.out.print(node.data + " ");
        }

        // Recur for left and right subtrees
        printVerticalLine(node.left, line_no, hd - 1);
        printVerticalLine(node.right, line_no, hd + 1);

    }

    private void verticalOrder(tNode node) {

        // Find min and max distances with resepect to root
        findMinMax(node, val, val, 0);

        for (int line_no = val.min; line_no <= val.max; line_no++) {
            printVerticalLine(node, line_no, 0);
            System.out.println();
        }
    }

    public static void main(String args[]) {
        VerticalOrder tree = new VerticalOrder();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.right.left = new tNode(6);
        tree.root.right.right = new tNode(7);
        tree.root.right.left.right = new tNode(8);

        System.out.println("vertical order traversal is :");
        tree.verticalOrder(tree.root);

    }
}
