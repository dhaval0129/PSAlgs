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
 * http://www.geeksforgeeks.org/foldable-binary-trees/
 *
 * Foldable Binary Trees
 *
 * Given a binary tree, find out if the tree can be folded or not
 *
 * A tree can be folded if left and right subtrees of the tree are structure
 * wise mirror image of each other. An empty tree is considered as foldable.
 *
 * Time complexity: O(n)
 */
public class FoldableBT {

    static class tNode {

        int data;
        tNode right;
        tNode left;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;

    // Time complexity: O(n)
    private boolean isFoldable(tNode node) {
        boolean result;
        
        /* base case */
        if (node == null) {
            return true;
        }

        /* convert left subtree to its mirror */
        mirror(node.left);

        /* Compare the structures of the right subtree and mirrored
         left subtree */
        result = isStructSame(node.left, node.right);
        
        /* Get the originial tree back */
        mirror(node.left);
        
        return result;
    }

    // check if structure is same
    private boolean isStructSame(tNode a, tNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a != null && b != null
                && isStructSame(a.left, b.left)
                && isStructSame(a.right, b.right)) {
            return true;
        }
        
        return false;
    }

    private void mirror(tNode node) {
        if (node == null) {
            return;
        } else {

            /* do the subtrees */
            mirror(node.left);
            mirror(node.right);

            /* swap the pointers in this node */
            tNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }

    public static void main(String args[]) {
        FoldableBT tree = new FoldableBT();
        /* The constructed binary tree is
             1
           /   \
          2     3
           \    /
            4  5
         */
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.right.right = new tNode(4);
        tree.root.left.left = new tNode(5);

        if (tree.isFoldable(tree.root)) {
            System.out.println("tree is foldable");
        } else {
            System.out.println("Tree is not foldable");
        }
    }
}
