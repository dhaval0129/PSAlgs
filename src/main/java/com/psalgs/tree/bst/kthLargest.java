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
 * http://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/
 * 
 * K’th Largest Element in BST when modification to BST is not allowed
 * 
 * Time Complexity O(n)
 * 
 * Similarly kth smallest element traverse left
 * 
 * http://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
 * 
 */
public class kthLargest {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    static class Count {

        int c;
    }

    tNode root;

    private void kthLargest(int k) {
        Count c = new Count();
        kthLargestUtil(root, k, c);
    }

    private void kthLargestUtil(tNode node, int k, Count count) {
        if (node == null) {
            return;
        }

        kthLargestUtil(node.right, k, count);
        count.c++;
        if (k == count.c) {
            System.out.println("kth largest element: " + k + " is: " + node.data);
        }
        kthLargestUtil(node.left, k, count);
    }

    public static void main(String args[]) {
        kthLargest tree = new kthLargest();
        tree.root = new tNode(50);
        tree.root.left = new tNode(30);
        tree.root.right = new tNode(70);
        tree.root.left.left = new tNode(20);
        tree.root.left.right = new tNode(40);
        tree.root.right.left = new tNode(60);
        tree.root.right.right = new tNode(80);

        for (int i = 0; i <= 7; i++) {
            tree.kthLargest(i);
        }
    }
}
