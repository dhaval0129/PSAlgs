/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.traversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author djoshi
 * 
 * http://www.geeksforgeeks.org/print-left-view-binary-tree/
 * 
 * Print Left View of a Binary Tree
 * 
 */
public class LeftTraversal {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
            right = left = null;
        }
    }

    tNode root;

    private void leftTraversal(tNode node) {
        if (node == null) {
            return;
        }

        Queue<tNode> queue = new LinkedList<>();
        queue.add(node);
        System.out.print(node.data + " ");

        while (!queue.isEmpty()) {
            tNode curr = queue.poll();

            if (curr.left != null) {
                System.out.print(curr.left.data + " ");
                queue.add(curr.left);
            }

            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        System.out.println();
    }

    int max_level = 0;

    // Here once we travese left level is incremented 
    // and condition is satisfied when we traverse right 
    // level is incremented but condtion is not satisfied
    // since maxlevel and level variable are of same value
    private void leftViewUtil(tNode node, int level) {
        // Base Case
        if (node == null) {
            return;
        }

        // If this is the first node of its level
        if (max_level < level) {
            System.out.print(node.data + " ");
            max_level = level;
        }

        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }

    public static void main(String args[]) {
        LeftTraversal tree = new LeftTraversal();
        tree.root = new tNode(12);
        tree.root.left = new tNode(10);
        tree.root.right = new tNode(30);
        tree.root.right.left = new tNode(25);
        tree.root.right.right = new tNode(40);

        tree.leftTraversal(tree.root);
        System.out.println();
        tree.leftViewUtil(tree.root, 1);
        System.out.println();
    }
}
