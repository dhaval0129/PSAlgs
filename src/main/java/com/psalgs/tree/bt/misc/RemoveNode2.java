/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.misc;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/remove-nodes-root-leaf-paths-length-k/
 *
 * Remove nodes on root to leaf paths of length < K
 *
 */
public class RemoveNode2 {

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

    //Method to print the tree in inorder fashion.
    private void printInorder(tNode node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }
    }

    private tNode removeShortPathNodes(tNode node, int level, int k) {
        //Base condition
        if (node == null) {
            return null;
        }

        // Traverse the tree in postorder fashion so that if a leaf
        // node path length is shorter than k, then that node and
        // all of its descendants till the node which are not
        // on some other path are removed.
        node.left = removeShortPathNodes(node.left, level + 1, k);
        node.right = removeShortPathNodes(node.right, level + 1, k);

        // If root is a leaf node and it's level is less than k then
        // remove this node.
        // This goes up and check for the ancestor nodes also for the
        // same condition till it finds a node which is a part of other
        // path(s) too.
        if (node.left == null && node.right == null && level < k) {
            return null;
        }

        // Return root;
        return node;
    }

    public static void main(String args[]) {
        int k = 4;
        RemoveNode2 tree = new RemoveNode2();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.left.left.left = new tNode(7);
        tree.root.right.right = new tNode(6);
        tree.root.right.right.left = new tNode(8);
        System.out.println("The inorder traversal of original tree is : ");
        tree.printInorder(tree.root);
        tNode res = tree.removeShortPathNodes(tree.root, 1, k);
        System.out.println("");
        System.out.println("The inorder traversal of modified tree is : ");
        tree.printInorder(res);
        System.out.println("");
    }
}
