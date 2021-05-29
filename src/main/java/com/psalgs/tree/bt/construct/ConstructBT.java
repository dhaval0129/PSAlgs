/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.construct;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/construct-a-binary-tree-from-parent-array-representation/
 *
 * Construct Binary Tree from given Parent Array representation
 * 
 * Input: parent[] = {-1, 0, 0, 1, 1, 3, 5};
 *
 * Time complexity is O(n)
 *
 */
public class ConstructBT {

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

    // Utility function to do inorder traversal
    private void inorder(tNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    private void createNode(int parent[], int i, tNode[] created) {
        // If this node is already created 
        if (created[i] != null) {
            return;
        }

        created[i] = new tNode(i);

        if (parent[i] == -1) {
            root = created[i];
            return;
        }

        if (created[parent[i]] == null) {
            createNode(parent, parent[i], created);
        }

        tNode p = created[parent[i]];

        // If this is first child of parent
        if (p.left == null) {
            p.left = created[i];
        } else {
            // If second child
            p.right = created[i];
        }
    }

    private tNode createTree(int parent[], int n) {
        tNode[] created = new tNode[n];

        for (int i = 0; i < n; i++) {
            created[i] = null;
        }

        for (int i = 0; i < n; i++) {
            createNode(parent, i, created);
        }

        return root;
    }

    public static void main(String args[]) {
        ConstructBT tree = new ConstructBT();
        int parent[] = {-1, 0, 0, 1, 1, 3, 5};
        int n = parent.length;
        tNode node = tree.createTree(parent, n);
        System.out.println("Inorder traversal of constructed tree ");
        tree.inorder(node);
        System.out.println();
    }

}
