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
 * http://www.geeksforgeeks.org/inorder-non-threaded-binary-tree-traversal-without-recursion-or-stack/
 * 
 * 
 * In-order Non-threaded Binary Tree Traversal without Recursion or Stack
 * Hint: Add extra node named parent to tree
 * 
 * In computing, a threaded binary tree is a binary tree variant that allows
 * fast traversal: given a pointer to a node in a threaded tree, it is possible
 * to cheaply find its in-order successor (and/or predecessor).
 * 
 */
public class IOTraversal {

    static class tNode {

        int data;
        tNode right;
        tNode left;
        tNode parent;

        tNode(int d) {
            data = d;
            right = left = parent = null;
        }
    }

    static tNode root;

    private tNode insert(tNode node, int data) {
        if (node == null) {
            return new tNode(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
            node.left.parent = node;
        } else if (data > node.data) {
            node.right = insert(node.right, data);
            node.right.parent = node;
        }

        return node;
    }

    private void inorder(tNode root) {
        boolean leftdone = false;

        // Start traversal from root
        while (root != null) {
            // If left child is not traversed, find the
            // leftmost child
            if (!leftdone) {
                while (root.left != null) {
                    root = root.left;
                }
            }

            // Print root's data
            System.out.print(root.data + " ");
            // Mark left as done
            leftdone = true;

            // If right child exists
            if (root.right != null) {
                leftdone = false;
                root = root.right;
            } else if (root.parent != null) {
                // If this node is right child of its parent,
                // visit parent's parent first
                while (root.parent != null && root == root.parent.right) {
                    root = root.parent;
                }
                if (root.parent == null) {
                    break;
                }
                root = root.parent;
            } else {
                break;
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        IOTraversal tree = new IOTraversal();
        tree.root = tree.insert(tree.root, 24);
        tree.root = tree.insert(tree.root, 27);
        tree.root = tree.insert(tree.root, 29);
        tree.root = tree.insert(tree.root, 34);
        tree.root = tree.insert(tree.root, 14);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 22);
        tree.root = tree.insert(tree.root, 13);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 6);

        System.out.println("Inorder traversal is ");
        tree.inorder(tree.root);
    }
}
