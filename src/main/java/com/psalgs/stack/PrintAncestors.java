/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.stack;

import java.util.Stack;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/print-ancestors-of-a-given-binary-tree-node-without-recursion/
 *
 * Print ancestors of a given binary tree node without recursion
 *
 */
public class PrintAncestors {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;

    private static void printAncestors(tNode root, int key) {
        if (root == null) {
            return;
        }

        Stack<tNode> st = new Stack<>();

        while (true) {
            // Traverse the left side. While traversing, push the nodes into
            // the stack so that their right subtrees can be traversed later
            while (root != null && root.data != key) {
                st.push(root);   // push current node
                root = root.left;   // move to next node
            }

            // If the node whose ancestors are to be printed is found,
            // then break the while loop.
            if (root != null && root.data == key) {
                break;
            }

            // Check if right sub-tree exists for the node at top
            // If not then pop that node because we don't need this
            // node any more.
            if (st.peek().right == null) {
                root = st.pop();

                // If the popped node is right child of top, then remove the top
                // as well. Left child of the top must have processed before.
                while (!st.isEmpty() && st.peek().right == root) {
                    root = st.peek();
                    st.pop();
                }
            }

            // if stack is not empty then simply set the root as right child
            // of top and start traversing right sub-tree.
            root = st.isEmpty() ? null : st.peek().right;
            
            // home work assignment done
            if(st.isEmpty() && root == null) {
                System.out.println("key "+key + " not found in tree");
                break;
            }
        }

        // If stack is not empty, print contents of stack
        // Here assumption is that the key is there in tree
        while (!st.empty()) {
            System.out.print(st.peek().data + " ");
            st.pop();
        }
    }

    public static void main(String args[]) {
        PrintAncestors tree = new PrintAncestors();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.right.left = new tNode(6);
        tree.root.right.right = new tNode(7);
        tree.root.left.left.left = new tNode(8);
        tree.root.left.right.right = new tNode(9);
        tree.root.right.right.left = new tNode(10);

        printAncestors(tree.root, 10);
        System.out.println();

    }

}
