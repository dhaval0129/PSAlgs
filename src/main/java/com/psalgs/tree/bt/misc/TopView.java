/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.misc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
 *
 * Print Nodes in Top View of Binary Tree
 *
 */
public class TopView {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    static class QItem {

        tNode node;
        int hd;

        public QItem(tNode n, int h) {
            node = n;
            hd = h;
        }
    }

    tNode root;

    private void printTopView() {
        // base case
        if (root == null) {
            return;
        }

        // Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();
        // Create a queue and add root to it
        Queue<QItem> Q = new LinkedList<>();
        Q.add(new QItem(root, 0)); // Horizontal distance of root is 0

        // Standard BFS or level order traversal loop
        while (!Q.isEmpty()) {
            // Remove the front item and get its details
            QItem qi = Q.remove();
            int hd = qi.hd;
            tNode n = qi.node;

            if (!set.contains(hd)) {
                set.add(hd);
                System.out.print(n.data + " ");
            }

            // Enqueue left and right children of current node
            if (n.left != null) {
                Q.add(new QItem(n.left, hd - 1));
            }
            if (n.right != null) {
                Q.add(new QItem(n.right, hd + 1));
            }

        }
    }

    public static void main(String args[]) {
        TopView tree = new TopView();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.right = new tNode(4);
        tree.root.left.right.right = new tNode(5);
        tree.root.left.right.right.right = new tNode(6);
        System.out.println("Following are nodes in top view of Binary Tree");
        tree.printTopView();
        System.out.println();
    }
}
