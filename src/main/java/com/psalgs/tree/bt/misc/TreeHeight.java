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
 * http://www.geeksforgeeks.org/iterative-method-to-find-height-of-binary-tree/
 *
 * Compute the "height" of a tree -- the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 *
 * Tree Height and Tree Depth are same
 * 
 * Time Complexity O(n)
 *
 */
public class TreeHeight {

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

    private int treeHeight_Rec(tNode node) {
        //base case
        if (node == null) {
            return 0;
        }
        int lHeight = treeHeight_Rec(node.left);
        int rHeight = treeHeight_Rec(node.right);

        if (lHeight > rHeight) {
            return (lHeight + 1);
        } else {
            return (rHeight + 1);
        }
    }

    private int treeHeight_Itr(tNode node) {
        // base case 
        if (node == null) {
            return 0;
        }

        // Create an empty queue for level order tarversal
        Queue<tNode> q = new LinkedList();

        // Enqueue Root and initialize height
        q.add(node);
        int height = 0;

        while (!q.isEmpty()) {
            // nodeCount (queue size) indicates number of nodes
            // at current lelvel.
            int nodeCount = q.size();
            height++;

            while (nodeCount > 0) {
                tNode curr = q.poll();

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                nodeCount--;
            }
        }

        return height;
    }

    public static void main(String args[]) {
        TreeHeight tree = new TreeHeight();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        System.out.println("Tree Height (Recursion) : " + tree.treeHeight_Rec(tree.root));
        System.out.println("Tree Height (Iteration) : " + tree.treeHeight_Itr(tree.root));
    }
}
