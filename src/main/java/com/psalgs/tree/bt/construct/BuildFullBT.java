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
 * http://www.geeksforgeeks.org/full-and-complete-binary-tree-from-given-preorder-and-postorder-traversals/
 *
 * Construct Full Binary Tree from given pre-order and postorder traversals
 * 
 * In full binary tree each node has 0 or 2 children 
 * 
 */
public class BuildFullBT {

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
    static int preIndex = 0;

    private static tNode constructTreeUtil(int[] pre, int[] post, int start, int end, int size) {

        // Base case
        if (preIndex >= size || start > end) {
            return null;
        }

        tNode node = new tNode(pre[preIndex]);
        preIndex++;

        if (start == end || preIndex >= size) {
            return node;
        }

        int i;
        for (i = start; i <= end; i++) {
            if (post[i] == pre[preIndex]) {
                break;
            }
        }

        if (i <= end) {
            node.left = constructTreeUtil(pre, post, start, i, size);
            node.right = constructTreeUtil(pre, post, i + 1, end, size);
        }

        return node;
    }

    private static tNode constructTree(int[] pre, int post[], int size) {
        return constructTreeUtil(pre, post, 0, size - 1, size);
    }

    private static void printInorder(tNode node) {

        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String args[]) {
        int pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};

        int size = pre.length;
        tNode node = constructTree(pre, post, size);

        System.out.println("Inorder traversal of the constructed tree:");
        printInorder(node);
    }
}
