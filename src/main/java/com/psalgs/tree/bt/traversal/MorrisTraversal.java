/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.traversal;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 *
 * In-order Tree Traversal without recursion and without stack!
 *
 * Morris Traversal is based on Threaded Binary Tree in this traversal, we first
 * create links to In-order successor and print the data using these links, and
 * finally revert the changes to restore original tree.
 *
 * A binary tree is made threaded by making all right child pointers that would
 * normally be NULL point to the in-order successor of the node (if it exists).
 * 
 * http://www.geeksforgeeks.org/threaded-binary-tree/
 *
 */
class tNode {

    int data;
    tNode left, right;

    tNode(int item) {
        data = item;
        left = right = null;
    }
}

public class MorrisTraversal {

    tNode root;

    private void morrisTraversal_Inorder(tNode root) {
        tNode curr, pred; // predecessor node

        if (root == null) {
            return;
        }

        curr = root;

        while (curr != null) {

            if (curr.left == null) {
                System.out.print(curr.data + " ");
                curr = curr.right;
            } else {
                /* Find the inorder predecessor of current */
                pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    /* Make current as right child of its inorder predecessor */
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    /* Revert the changes made in if part to restore the 
                        original tree i.e.,fix the right child of predecssor*/
                    pred.right = null;
                    System.out.print(curr.data + " ");  // Inorder traversal
                    curr = curr.right;
                }

            }
        }
        System.out.println();
    }

    private void morrisTraversal_Preorder(tNode root) {
        tNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.data + " ");
                curr = curr.right;
            } else {
                tNode pred = curr.left;

                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = curr;
                    System.out.print(curr.data + " ");  // preorder traversal
                    curr = curr.left;
                } else {
                    pred.right = null;
                    curr = curr.right;
                }
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        MorrisTraversal tree = new MorrisTraversal();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        System.out.println("Morris Inorder traversal");
        tree.morrisTraversal_Inorder(tree.root);
        System.out.println("Morris Preorder traversal");
        tree.morrisTraversal_Preorder(tree.root);
    }

}
