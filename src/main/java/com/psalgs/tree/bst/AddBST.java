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
 * http://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
 *
 * Add all greater values to every node in a given BST
 * 
 * Time Complexity: O(n)
 *
 */
public class AddBST {

    static class tNode {
        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right;
        }
    }

    static class Sum {
        int sum = 0;
    }

    tNode root;

    private void insert(int key) {
        root = insertRec(root, key);
    }

    private tNode insertRec(tNode node, int key) {
        if (node == null) {
            node = new tNode(key);
            return node;
        }

        if (key < node.data) {
            node.left = insertRec(node.left, key);
        } else if (key > node.data) {
            node.right = insertRec(node.right, key);
        }

        return node;
    }

    private void modifyBST(tNode node) {
        Sum S = new Sum();
        modifyBSTUtil(node, S);
    }

    private void modifyBSTUtil(tNode node, Sum S) {

        if (node == null) {
            return;
        }

        modifyBSTUtil(node.right, S);

        S.sum += node.data;
        node.data = S.sum;

        modifyBSTUtil(node.left, S);
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
        AddBST tree = new AddBST();
        /* Let us create following BST
               50
             /    \
           30      70
          /  \    /  \
        20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.modifyBST(tree.root);
        // print inoder tarversal of the modified BST
        tree.inorder(tree.root);
    }

}
