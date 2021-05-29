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
 * http://www.geeksforgeeks.org/iterative-preorder-traversal/
 *
 * Iterative Preorder Traversal 
 * 
 * It can be also called Depth first search for preorder traversal
 */
public class IPreTraversal {

    static class tNode {

        int data;
        tNode right;
        tNode left;

        tNode(int d) {
            data = d;
            right = left = null;
        }
    }

    tNode root;

    private void iterativePreorder() {

        Stack<tNode> st = new Stack<>();
        st.push(root);

        /* Pop all items one by one. Do following for every popped item
         a) print it
         b) push its right child
         c) push its left child
         Note that right child is pushed first so that left is processed first */
        
        while (!st.isEmpty()) {
            tNode node = st.pop();
            System.out.print(node.data + " ");

            if (node.right != null) {
                st.push(node.right);
            }

            if (node.left != null) {
                st.push(node.left);
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        IPreTraversal tree = new IPreTraversal();
        tree.root = new tNode(10);
        tree.root.left = new tNode(8);
        tree.root.right = new tNode(2);
        tree.root.left.left = new tNode(3);
        tree.root.left.right = new tNode(5);
        tree.root.right.left = new tNode(2);
        tree.iterativePreorder();
    }

}
