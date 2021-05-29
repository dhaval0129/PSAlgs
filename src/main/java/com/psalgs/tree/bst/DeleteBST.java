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
 * http://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
 *
 * Delete node from BST
 *
 */
public class DeleteBST {

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

    private DeleteBST() {
        root = null;
    }

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

    private void inorder(tNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // This method mainly calls deleteRec()
    private void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    private tNode deleteRec(tNode node, int key) {
        // base case
        if (node == null) {
            return node;
        }

        if (key < node.data) {
            node.left = deleteRec(node.left, key);
        } else if (key > node.data) {
            node.right = deleteRec(node.right, key);
        } else {
            // node with only one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // if node is intermediate node
            
            // node with two children: Get the inorder successor (smallest value in the right subtree)
            // replace node to be delete value to node value of inorder successor
            node.data = minValue(node.right);
            // Delete the inorder successor and update key to inorder successor data value
            node.right = deleteRec(node.right, node.data);
        }

        return node;
    }

    // find inorder successor and return node value
    private int minValue(tNode node) {
        int minv = node.data;

        while (node.left != null) {
            minv = node.left.data;
            node = node.left;
        }
        return minv;
    }

    public static void main(String args[]) {
        DeleteBST tree = new DeleteBST();
        /* Let us create following BST
              50
           /     \
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

        System.out.println("Inorder traversal of the given tree");
        tree.inorder(tree.root);

        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder(tree.root);

        System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder(tree.root);

        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder(tree.root);
        System.out.println(); 
    }
}
