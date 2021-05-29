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
 * http://www.geeksforgeeks.org/find-next-right-node-of-a-given-key/
 * 
 * Find next right node of a given key
 * 
 */
public class NextRNode {

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

    private tNode nextRight(tNode first, int k) {
        // base case
        if (first == null) {
            return null;
        }

        // Create an empty queue for level order tarversal
        // A queue to store node addresses
        Queue<tNode> qn = new LinkedList<>();

        // Another queue to store node levels
        Queue<Integer> ql = new LinkedList<>();
        int level = 0;

        // enqueue root and its level
        qn.add(first);
        ql.add(level);

        while (qn.size() != 0) {
            tNode node = qn.poll();
            level = ql.poll();

            if (node.data == k) {
                // If there are no more items in queue or given node is
                // the rightmost node of its level, then return NULL
                if (ql.size() == 0 || ql.peek() != level) {
                    return null;
                }
                // Otherwise return next node from queue of nodes
                return qn.peek();
            }

            if (node.left != null) {
                qn.add(node.left);
                ql.add(level + 1);
            }

            if (node.right != null) {
                qn.add(node.right);
                ql.add(level + 1);
            }

        }

        return null;
    }

    private void test(tNode node, int k) {
        tNode nr = nextRight(root, k);

        if (nr != null) {
            System.out.println("Next Right of " + k + " is " + nr.data);
        } else {
            System.out.println("No next right node found for " + k);
        }
    }

    public static void main(String args[]) {
        NextRNode tree = new NextRNode();
        tree.root = new tNode(10);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(6);
        tree.root.left.left = new tNode(8);
        tree.root.left.right = new tNode(4);
        tree.root.right.right = new tNode(5);

        tree.test(tree.root, 10);
        tree.test(tree.root, 2);
        tree.test(tree.root, 6);
        tree.test(tree.root, 5);
        tree.test(tree.root, 8);
        tree.test(tree.root, 4);
    }
}
