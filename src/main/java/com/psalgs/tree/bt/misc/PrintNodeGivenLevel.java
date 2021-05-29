/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.misc;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/given-binary-tree-print-nodes-two-given-level-numbers/
 *
 * Print nodes between two given level numbers of a binary tree
 *
 * Time Complexity O(n)
 */
public class PrintNodeGivenLevel {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;

    private void printLevels(tNode node, int start, int end) {
        if (node == null) {
            return;
        }

        Queue<tNode> queue = new LinkedList<>();
        queue.add(node);
        int currLevel = 0;

        while (!queue.isEmpty()) {

            int noOfLevels = queue.size();
            ++currLevel;

            while (noOfLevels > 0) {
                tNode curr = queue.poll();

                if (currLevel >= start && currLevel <= end) {
                    System.out.print(curr.data + " ");
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
                --noOfLevels;
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        PrintNodeGivenLevel tree = new PrintNodeGivenLevel();
        tree.root = new tNode(20);
        tree.root.left = new tNode(8);
        tree.root.right = new tNode(22);

        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(12);
        tree.root.left.right.left = new tNode(10);
        tree.root.left.right.right = new tNode(14);

        System.out.println("Level Order traversal between two levels");
        tree.printLevels(tree.root, 2, 3);
    }
}
