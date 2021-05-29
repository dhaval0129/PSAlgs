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
 * http://www.geeksforgeeks.org/convert-given-binary-tree-tree-holds-logical-property/
 * 
 * Convert a given Binary tree to a tree that holds Logical AND property
 * 
 * 
 */
public class TreeAND {

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

    private int treeAND(tNode node) {

        if (node.left != null && node.right != null) {
            node.data = treeAND(node.left) & treeAND(node.right);
        }

        return node.data;
    }

    private void preOrder(tNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String args[]) {
        TreeAND tree = new TreeAND();
        tree.root = new tNode(1);
        tree.root.left = new tNode(1);
        tree.root.right = new tNode(0);
        tree.root.left.left = new tNode(0);
        tree.root.left.right = new tNode(1);
        tree.root.right.left = new tNode(1);
        tree.root.right.right = new tNode(1);

        System.out.println("Tree AND operation between nodes");
        tree.treeAND(tree.root);
        System.out.println("Preorder traversal of tree");
        tree.preOrder(tree.root);
        System.out.println();
    }

}
