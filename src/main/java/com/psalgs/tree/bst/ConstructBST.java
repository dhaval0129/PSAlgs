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
 * http://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
 *
 * Sorted Array to Balanced BST
 *
 * A Tree is height balanced when difference between height of left sub-tree and
 * right sub-tree is not more then 1
 * 
 * Time Complexity: O(n)
 */
public class ConstructBST {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;

    private tNode sortedArrayToBST(int arr[], int start, int end) {

        // base case
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        tNode node = new tNode(arr[mid]);

        node.left = sortedArrayToBST(arr, start, mid - 1);

        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }

    private void preOrder(tNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String args[]) {
        ConstructBST tree = new ConstructBST();
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;

        tree.root = tree.sortedArrayToBST(arr, 0, n - 1);
        System.out.println("Preorder traversal of constructed BST");
        tree.preOrder(tree.root);
        System.out.println();
    }

}
