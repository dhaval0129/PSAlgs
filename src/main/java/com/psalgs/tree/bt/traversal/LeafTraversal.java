/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.traversal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/check-if-leaf-traversal-of-two-binary-trees-is-same/
 *
 * Check if leaf traversal of two Binary Trees is same?
 *
 */
public class LeafTraversal {

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
    List<Integer> leaf = new ArrayList<>();

    private boolean isSame(tNode root1, tNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();

        if (root1 == null || root2 == null) {
            return false;
        }

        scanTree(root1);
        leaf1 = leaf;
        leaf.clear();

        scanTree(root2);
        leaf2 = leaf;
        leaf.clear();

        if (leaf1 == leaf2) {
            return true;
        } else {
            return false;
        }
    }

    private void scanTree(tNode node) {

        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            leaf.add(node.data);
        }

        scanTree(node.left);
        scanTree(node.right);
    }

    public static void main(String args[]) {
        LeafTraversal tree1 = new LeafTraversal();
        LeafTraversal tree2 = new LeafTraversal();

        tree1.root = new tNode(1);
        tree1.root.left = new tNode(2);
        tree1.root.right = new tNode(3);
        tree1.root.left.left = new tNode(4);
        tree1.root.right.left = new tNode(6);
        tree1.root.right.right = new tNode(7);

        tree2.root = new tNode(1);
        tree2.root.left = new tNode(2);
        tree2.root.right = new tNode(5);
        tree2.root.left.right = new tNode(4);
        tree2.root.right.left = new tNode(6);
        tree2.root.right.right = new tNode(7);

        if (tree1.isSame(tree1.root, tree2.root)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }
}
