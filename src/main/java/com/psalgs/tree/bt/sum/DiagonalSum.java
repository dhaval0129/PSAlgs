/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.sum;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/diagonal-sum-binary-tree/
 *
 * Diagonal Sum of a Binary Tree
 *
 */
public class DiagonalSum {

    static class tNode {

        int data;
        int vd;
        tNode left, right;

        tNode(int d) {
            data = d;
            right = left = null;
        }
    }

    tNode root;

    private void diagonalSum() {
        Queue<tNode> queue = new LinkedList<>();
        // Map to store sum of node's data lying diagonally
        Map<Integer, Integer> map = new HashMap<>();
        // Assign the root's vertical distance as 0.
        root.vd = 0;
        // Add root node to the queue
        queue.add(root);

        while (!queue.isEmpty()) {
            tNode curr = queue.poll();

            // Get the vertical distance of the dequeued node.
            int vd = curr.vd;

            while (curr != null) {
                int prevSum = (map.get(vd) == null) ? 0 : map.get(vd);
                map.put(vd, prevSum + curr.data);

                // If for any node the left child is not null add
                // it to the queue for future processing.
                if (curr.left != null) {
                    curr.left.vd = vd + 1;
                    queue.add(curr.left);
                }

                // Move to the current node's right child.
                curr = curr.right;
            }
        }

        System.out.print("Diagonal sum in a binary tree is: ");
        int size = map.size();
        for(int i = 0; i < size; i++) {
            System.out.print(map.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        DiagonalSum tree = new DiagonalSum();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(9);
        tree.root.left.right = new tNode(6);
        tree.root.right.left = new tNode(4);
        tree.root.right.right = new tNode(5);
        tree.root.right.left.left = new tNode(12);
        tree.root.right.left.right = new tNode(7);
        tree.root.left.right.left = new tNode(11);
        tree.root.left.left.right = new tNode(10);
        tree.diagonalSum();
    }
}
