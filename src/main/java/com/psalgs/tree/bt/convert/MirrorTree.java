/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.convert;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
 *
 * Write an Efficient Function to Convert a Binary Tree into its Mirror Tree
 * 
 * Time Complexity O(n)
 *
 */
public class MirrorTree {

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

    private void mirror() {
        root = mirror(root);
    }

    private tNode mirror(tNode node) {

        if (node == null) {
            return node;
        }

        tNode left = mirror(node.left);
        tNode right = mirror(node.right);

        node.left = right;
        node.right = left;

        return node;
    }

    private void inOrder() {
        inOrder(root);
    }

    private void inOrder(tNode node) {

        if (node == null) {
            return;
        }
        
        inOrder(node.left);
        System.out.print(node.data +" ");
        inOrder(node.right);
    }

    public static void main(String args[]) {
        /* creating a binary tree and entering the nodes */
        MirrorTree tree = new MirrorTree();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        
        /* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of input binary tree is :");
        tree.inOrder();
        System.out.println("");
        
        /* convert tree to its mirror */
        tree.mirror();
        
        /* print inorder traversal of the minor tree */
        System.out.println("Inorder traversal of mirrored binary tree is : ");
        tree.inOrder();
    }
}
