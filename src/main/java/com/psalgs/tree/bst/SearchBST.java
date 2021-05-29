/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bst;

/**
 *
 * @author djoshi

 http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/

 Binary SearchBST Tree ( SearchBST and Insertion )
 */
public class SearchBST {

    static class tNode {

        tNode left;
        tNode right;
        int data;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;

    private SearchBST() {
        root = null;
    }

    private tNode search(tNode node, int key) {
        if (node == null) {
            return null;
        }

        if (key == node.data) {
            return node;
        } else if (key < node.data) {
            return search(node.left, key);
        }

        return search(node.right, key);
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

    public static void main(String[] args) {
        SearchBST tree = new SearchBST();

        /* Let us create following SearchBST
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

        // print inorder traversal of the SearchBST
        tree.inorder(tree.root);
        System.out.println();

        // SearchBST key
        tNode temp = tree.search(tree.root, 60);
        if (temp != null) {
            System.out.println("Key found: " + temp.data);
        } else {
            System.out.println("Key not found");
        }
    }

}
