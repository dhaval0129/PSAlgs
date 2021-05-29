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
 * http://www.geeksforgeeks.org/reverse-alternate-levels-binary-tree/
 *
 * Reverse alternate levels of a perfect binary tree
 *
 * Time complexity of the above solution is O(n)
 *
 */
public class ReverseAlternateLevels {

    static class tNode {

        char data;
        tNode left;
        tNode right;

        tNode(char d) {
            data = d;
            left = right = null;
        }
    }

    // class to access index value by reference
    class Index {

        int index;
    }

    tNode root;
    Index index_obj = new Index();

    private void printInorder() {
        printInorder(root);
    }

    // A utility function to print indorder traversal of a
    // binary tree
    private void printInorder(tNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    private void reverseAlternate() {
        reverseAlternate(root);
    }

    private void storeAlternate(tNode node, char arr[], Index index, int level) {
        // base case
        if (node == null) {
            return;
        }
        // store elements of left subtree
        storeAlternate(node.left, arr, index, level + 1);

        if ((level & 1) != 0) {
            arr[index.index] = node.data;
            index.index++;
        }

        storeAlternate(node.right, arr, index, level + 1);
    }

    private void reverse(char arr[], int n) {
        int l = 0;
        int r = n - 1;

        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    private void modifyTree(tNode node, char arr[], Index index, int level) {
        // Base case
        if (node == null) {
            return;
        }

        // Update nodes in left subtree
        modifyTree(node.left, arr, index, level + 1);

        // Update this node only if this is an odd level node
        if ((level & 1) != 0) {
            node.data = arr[index.index];
            (index.index)++;
        }

        // Update nodes in right subtree
        modifyTree(node.right, arr, index, level + 1);
    }

    private void reverseAlternate(tNode node) {
        // Create an auxiliary array to store nodes of alternate levels
        char[] arr = new char[100];

        // First store nodes of alternate levels
        storeAlternate(node, arr, index_obj, 0);

        // Reverse the array
        reverse(arr, index_obj.index);

        // Update tree by taking elements from array
        index_obj.index = 0;
        modifyTree(node, arr, index_obj, 0);
    }

    // Driver program to test the above functions
    public static void main(String args[]) {
        ReverseAlternateLevels tree = new ReverseAlternateLevels();
        tree.root = new tNode('a');
        tree.root.left = new tNode('b');
        tree.root.right = new tNode('c');
        tree.root.left.left = new tNode('d');
        tree.root.left.right = new tNode('e');
        tree.root.right.left = new tNode('f');
        tree.root.right.right = new tNode('g');
        tree.root.left.left.left = new tNode('h');
        tree.root.left.left.right = new tNode('i');
        tree.root.left.right.left = new tNode('j');
        tree.root.left.right.right = new tNode('k');
        tree.root.right.left.left = new tNode('l');
        tree.root.right.left.right = new tNode('m');
        tree.root.right.right.left = new tNode('n');
        tree.root.right.right.right = new tNode('o');
        System.out.println("Inorder Traversal of given tree");
        tree.printInorder();

        tree.reverseAlternate();
        System.out.println("");
        System.out.println("");
        System.out.println("Inorder Traversal of modified tree");
        tree.printInorder();
    }
}
