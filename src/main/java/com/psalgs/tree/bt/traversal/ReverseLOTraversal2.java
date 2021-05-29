/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/perfect-binary-tree-specific-level-order-traversal-set-2/
 *
 * Perfect Binary Tree Specific Level Order Traversal ( Bottom to TOP )
 */
public class ReverseLOTraversal2 {

    static class tNode {

        int data;
        tNode right;
        tNode left;

        tNode(int d) {
            data = d;
            right = left = null;
        }
    }

    static tNode root;

    private void printSpecificLevelOrderUtil(tNode root, Stack<tNode> s) {

        if (root == null) {
            return;
        }

        // Create a queue and enqueue left and right
        // children of root
        Queue<tNode> q = new LinkedList<tNode>();

        q.add(root.left);
        q.add(root.right);

        // We process two nodes at a time, so we
        // need two variables to store two front
        // items of queue
        tNode first = null, second = null;

        while (!q.isEmpty()) {
            first = q.poll();
            second = q.poll();

            // Push first and second node's chilren
            // in reverse order
            s.push(second.left);
            s.push(first.right);
            s.push(second.right);
            s.push(first.left);

            // If first and second have grandchildren,
            // enqueue them in specific order
            if (first.left.left != null) {
                q.add(first.right);
                q.add(second.left);
                q.add(first.left);
                q.add(second.right);
            }
        }

    }

    private void printSpecificLevelOrder(tNode root) {
        Stack<tNode> s = new Stack<tNode>();

        s.push(root);

        // Since it is perfect Binary Tree, right is
        // not checked
        if (root.left != null) {
            s.push(root.right);
            s.push(root.left);
        }

        // Do anything more if there are nodes at next
        // level in given perfect Binary Tree
        if (root.left.left != null) {
            printSpecificLevelOrderUtil(root, s);
        }

        // Finally pop all Nodes from stack and prints
        // them.
        while (!s.empty()) {
            System.out.print(s.peek().data + " ");
            s.pop();
        }
        System.out.println();
    }

    public static void main(String args[]) {
        ReverseLOTraversal2 tree = new ReverseLOTraversal2();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);

        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.right.left = new tNode(6);
        tree.root.right.right = new tNode(7);

        tree.root.left.left.left = new tNode(8);
        tree.root.left.left.right = new tNode(9);
        tree.root.left.right.left = new tNode(10);
        tree.root.left.right.right = new tNode(11);
        tree.root.right.left.left = new tNode(12);
        tree.root.right.left.right = new tNode(13);
        tree.root.right.right.left = new tNode(14);
        tree.root.right.right.right = new tNode(15);

        tree.root.left.left.left.left = new tNode(16);
        tree.root.left.left.left.right = new tNode(17);
        tree.root.left.left.right.left = new tNode(18);
        tree.root.left.left.right.right = new tNode(19);
        tree.root.left.right.left.left = new tNode(20);
        tree.root.left.right.left.right = new tNode(21);
        tree.root.left.right.right.left = new tNode(22);
        tree.root.left.right.right.right = new tNode(23);
        tree.root.right.left.left.left = new tNode(24);
        tree.root.right.left.left.right = new tNode(25);
        tree.root.right.left.right.left = new tNode(26);
        tree.root.right.left.right.right = new tNode(27);
        tree.root.right.right.left.left = new tNode(28);
        tree.root.right.right.left.right = new tNode(29);
        tree.root.right.right.right.left = new tNode(30);
        tree.root.right.right.right.right = new tNode(31);

        System.out.println("Specific Level Order traversal of binary tree is (Bottom to Top) ");
        tree.printSpecificLevelOrder(tree.root);
    }
}
