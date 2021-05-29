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
 * http://www.geeksforgeeks.org/binary-search-tree-data-structure/
 *
 * Print BST keys in the given range
 * 
 * Time Complexity O(n)
 */
public class PrintRange {

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
    int n1 = 10;
    int n2 = 22;

    private void inOrder(tNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);

        if (node.data >= n1 && node.data <= n2) {
            System.out.print(node.data + " ");
        }

        inOrder(node.right);
    }

    public static void main(String args[]) {
        PrintRange tree = new PrintRange();
        tree.root = new tNode(20);
        tree.root.left = new tNode(8);
        tree.root.right = new tNode(22);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(12);
        tree.inOrder(tree.root);
        System.out.println();
    }
}
