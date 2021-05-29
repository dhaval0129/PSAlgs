/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.traversal;

import java.util.Stack;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/iterative-postorder-traversal/
 *
 * Iterative Postorder Traversal (Using Two Stacks)
 *
 */
public class IPosTraversal2 {

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

    private void postOrderTraversal(tNode node) {
        if (node == null) {
            return;
        }

        Stack<tNode> st1 = new Stack<>();
        Stack<tNode> st2 = new Stack<>();
        st1.push(node);

        while (!st1.isEmpty()) {
            // Pop an item from s1 and push it to s2
            tNode temp = st1.pop();
            st2.push(temp);

            // Push left and right children of removed node to s1
            if (temp.left != null) {
                st1.push(temp.left);
            }

            if (temp.right != null) {
                st1.push(temp.right);
            }
        }

        while (!st2.isEmpty()) {
            tNode temp = st2.pop();
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        IPosTraversal2 tree = new IPosTraversal2();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.right.left = new tNode(6);
        tree.root.right.right = new tNode(7);

        tree.postOrderTraversal(tree.root);

    }

}
