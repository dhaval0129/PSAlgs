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
 * http://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
 * 
 * http://www.geeksforgeeks.org/bfs-vs-dfs-binary-tree/
 * 
 */
public class BTTraversal {

    static class tNode {
        int data;
        tNode left;
        tNode right;
        
        tNode(int d) {
            data = d;
            right = left = null;
        }
    }
    
    // Root of Binary Tree
    tNode root;

    // Constructors
    BTTraversal(int key) {
        root = new tNode(key);
    }

    BTTraversal() {
        root = null;
    }

    private void printPreOrder(tNode node) {

        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    private void printInOrder(tNode node) {
        if (node == null) {
            return;
        }

        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

    private void printPostOrder(tNode node) {
        if (node == null) {
            return;
        }

        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data + " ");
    }

    // Wrappers over above recursive functions
    void printPostOrder() {
        printPostOrder(root);
    }

    void printInOrder() {
        printInOrder(root);
    }

    void printPreOrder() {
        printPreOrder(root);
    }

    public static void main(String args[]) {
        BTTraversal tree = new BTTraversal();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreOrder();

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInOrder();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostOrder();
    }
}
