/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.traversal;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
 *
 * Iterative Postorder Traversal ( using one single stack )
 *
 */
public class IPosTraversal {

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
    ArrayList<Integer> list = new ArrayList<>();

    private ArrayList<Integer> postOrderTraversal(tNode node) {

        // Check for empty tree
        if (node == null) {
            return list;
        }

        Stack<tNode> st = new Stack<>();
        st.push(node);
        tNode prev = null;

        while (!st.empty()) {
            tNode curr = st.peek();
            /* go down the tree in search of a leaf an if so process it 
            and pop stack otherwise move down */
            if (prev == null || prev.left == curr
                    || prev.right == curr) {

                if (curr.left != null) {
                    st.push(curr.left);
                } else if (curr.right != null) {
                    st.push(curr.right);
                } else {
                    st.pop();
                    list.add(curr.data);
                }
            } else if (curr.left == prev) {
                /* go up the tree from left node, if the child is right 
                   push it onto stack otherwise process parent and pop 
                   stack */
                if (curr.right != null) {
                    st.push(curr.right);
                } else {
                    st.pop();
                    list.add(curr.data);
                }
            } else if (curr.right == prev) {
                /* go up the tree from right node and after coming back
                 from right node process parent and pop stack */
                st.pop();
                list.add(curr.data);
            }

            prev = curr;
        }
        return list;
    }

    public static void main(String args[]) {
        IPosTraversal tree = new IPosTraversal();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.right.left = new tNode(6);
        tree.root.right.right = new tNode(7);
        ArrayList<Integer> mylist = tree.postOrderTraversal(tree.root);

        System.out.println("Post order traversal of binary tree is :");
        System.out.println(mylist);
    }

}
