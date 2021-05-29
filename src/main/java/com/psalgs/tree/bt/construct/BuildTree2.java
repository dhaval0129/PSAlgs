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
 * http://www.geeksforgeeks.org/construct-binary-tree-from-inorder-traversal/
 *
 * Construct special Binary Tree from given In-order traversal
 *
 */
public class BuildTree2 {

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

    private void printInorder(tNode node) {

        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    // Time Complexity: O(n^2)
    private tNode buildTree(int inorder[], int start, int end, tNode node) {
        if (start > end) {
            return null;
        }

        int index = max(inorder, start, end);
        node = new tNode(inorder[index]);

        if (start == end) {
            return node;
        }

        node.left = buildTree(inorder, start, index - 1, node.left);
        node.right = buildTree(inorder, index + 1, end, node.right);

        return node;
    }

    private int max(int arr[], int start, int end) {
        int i, max = arr[start], maxIndex = start++;

        for (i = start + 1; i <= end; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public static void main(String args[]) {
        BuildTree2 tree = new BuildTree2();
        /* Assume that inorder traversal of following tree is given
             40
            /   \
          10     30
         /         \
        5          28 */
        int inorder[] = new int[]{5, 10, 40, 30, 28};
        int len = inorder.length;
        tNode mynode = tree.buildTree(inorder, 0, len - 1, tree.root);

        /* Let us test the built tree by printing Inorder traversal */
        System.out.println("Inorder traversal of the constructed tree is ");
        tree.printInorder(mynode);
        System.out.println();
    }
}
