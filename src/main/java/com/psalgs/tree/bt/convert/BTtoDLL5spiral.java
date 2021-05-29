/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.convert;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/convert-a-binary-tree-into-doubly-linked-list-in-spiral-fashion/
 *
 * Convert a Binary Tree into Doubly Linked List in spiral fashion
 *
 */
public class BTtoDLL5spiral {

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
    tNode head;

    private void push(tNode node) {
        node.right = head;
        node.left = null;

        if (head != null) {
            head.left = node;
        }
        head = node;
    }

    // Function to prints contents of DLL
    private void printList(tNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    private void spiralLevelOrder(tNode node) {
        // Base case
        if (node == null) {
            return;
        }
        // Create an empty deque for doing spiral
        // level order traversal and enqueue node
        Deque<tNode> q = new LinkedList<>();
        q.addFirst(node);

        // create a stack to store Binary Tree nodes
        // to insert into DLL later
        Stack<tNode> stack = new Stack<>();
        int level = 0;

        while (!q.isEmpty()) {
            // nodeCount indicates number of Nodes
            // at current level.
            int nodeCount = q.size();

            // Dequeue all Nodes of current level and
            // Enqueue all Nodes of next level
            if ((level & 1) % 2 != 0) { // odd level 

                while (nodeCount > 0) {
                    // dequeue node from front and push it to stack
                    tNode temp = q.pollFirst();
                    stack.push(temp);

                    // insert its left and right children
                    // in the back of the deque
                    if (temp.left != null) {
                        q.addLast(temp.left);
                    }

                    if (temp.right != null) {
                        q.addLast(temp.right);
                    }

                    nodeCount--;
                }
            } else { // even level
                while (nodeCount > 0) {
                    // dequeue node from the back & push it to stack
                    tNode temp = q.pollLast();
                    stack.push(temp);

                    // inserts its right and left children
                    // in the front of the deque
                    if (temp.right != null) {
                        q.addFirst(temp.right);
                    }
                    if (temp.left != null) {
                        q.addFirst(temp.left);
                    }
                    nodeCount--;
                }
            }
            level++;
        }

        // pop all nodes from stack and 
        // push them in the beginning of the doubly list
        while (!stack.empty()) {
            push(stack.pop());
        }

        System.out.println("Created DLL is : ");
        printList(head);
        System.out.println();
    }

    public static void main(String args[]) {
        BTtoDLL5spiral tree = new BTtoDLL5spiral();
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
        // tree.root.right.left.left = new Node(12);
        tree.root.right.left.right = new tNode(13);
        tree.root.right.right.left = new tNode(14);
        // tree.root.right.right.right = new Node(15);

        tree.spiralLevelOrder(tree.root);
    }
}
