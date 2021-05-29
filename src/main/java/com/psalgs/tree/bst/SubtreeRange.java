/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bst;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/count-bst-subtrees-that-lie-in-given-range/
 *
 * Count BST subtrees that lie in given range
 *
 */
public class SubtreeRange {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;
    int counter;

    // This method mainly calls insertRec()
    private void insert(int key) {
        root = insertRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    private tNode insertRec(tNode root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new tNode(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.data) {
            root.left = insertRec(root.left, key);
        } else if (key > root.data) {
            root.right = insertRec(root.right, key);
        }

        /* return the (unchanged) node pointer */
        return root;
    }

    private int findSubtrees(int min, int max) {
        if (findSubtrees(root, min, max)) {
            counter += 1;
        }
        return counter;
    }

    private boolean findSubtrees(tNode node, int min, int max) {
        if (node == null) {
            return true;
        }

        boolean l = findSubtrees(node.left, min, max);
        boolean r = findSubtrees(node.right, min, max);

        //If both fall within range and current node is in range, continue.
        if (l && r && currentIsInRange(node.data, min, max)) {
            return true;
        } else if (l && r && !currentIsInRange(node.data, min, max)
                && node.left != null && node.right != null) {
            // Both left and right subtree fall within range but that node doesn't
            counter += 2;
            return false;
        } else if ((l && node.left != null) || (r && node.right != null)) {
            // Has either left or right subtree that falls within range
            counter++;
            return false;
        }
        return false;
    }

    private boolean currentIsInRange(int key, int min, int max) {
        return (key >= min && key <= max);
    }

    public static void main(String args[]) {
        SubtreeRange bst = new SubtreeRange();
        bst.insert(10);
        bst.insert(8);
        bst.insert(5);
        bst.insert(9);
        bst.insert(2);
        bst.insert(7);
        bst.insert(12);
        bst.insert(11);
        bst.insert(14);
        bst.insert(13);
        bst.insert(24);
        System.out.println(bst.findSubtrees(5, 20));
    }

}
