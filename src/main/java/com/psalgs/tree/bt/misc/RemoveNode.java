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
 * http://www.geeksforgeeks.org/remove-all-nodes-which-lie-on-a-path-having-sum-less-than-k/
 *
 * Remove all nodes which don’t lie in any path with sum>= k
 *
 */
public class RemoveNode {

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

    private tNode pruneTree(tNode node, int sum) {
        // base case
        if (node == null) {
            return null;
        }

        node.left = pruneTree(node.left, sum - node.data);
        node.right = pruneTree(node.right, sum - node.data);

        // If we reach leaf whose data is smaller than sum,
        // we delete the leaf.  An important thing to note
        // is a non-leaf node can become leaf when its
        // chilren are deleted.
        if (node.left == null && node.right == null) {
            // we can use condition (node.data > sum )
            if (sum > 0) {
                return null;
            }
        }
        return node;
    }

    private void inorder(tNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String args[]) {
        RemoveNode tree = new RemoveNode();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.left.left.left = new tNode(8);
        tree.root.left.left.right = new tNode(9);
        tree.root.left.left.right.left = new tNode(13);
        tree.root.left.left.right.right = new tNode(14);
        tree.root.left.left.right.right.left = new tNode(15);
        tree.root.left.right.left = new tNode(12);
        tree.root.right.left = new tNode(6);
        tree.root.right.right = new tNode(7);
        tree.root.right.right.left = new tNode(10);
        tree.root.right.right.left.right = new tNode(11);

        System.out.println("Tree Before Truncation");
        tree.inorder(tree.root);
        System.out.println("");
        tree.root = tree.pruneTree(tree.root, 20);
        System.out.println("Tree After Truncation");
        tree.inorder(tree.root);
        System.out.println("");
    }
}
