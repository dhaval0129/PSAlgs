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
 * http://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/
 *
 * Print nodes at k distance from root
 *
 * Time Complexity: O(n)
 */
public class kDistance {

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

    // Time Complexity: O(n)
    private void printKDistant(tNode node, int k) {
        if (node == null) {
            return;
        }
        if (k == 0) {
            System.out.print(node.data + " ");
//            return;
        } else {
            printKDistant(node.left, k - 1);
            printKDistant(node.right, k - 1);
        }
    }

    public static void main(String args[]) {
        kDistance tree = new kDistance();
        /*  Constructed binary tree is
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

        tree.printKDistant(tree.root, 2);
        System.out.println();
    }
}
