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
 * http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 *
 * Construct Tree from given Inorder and Preorder traversals
 * 
 * Time Complexity: O(n^2)
 *
 */
public class BuildTree {

    static class tNode {

        char data;
        tNode left;
        tNode right;

        tNode(char d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;
    static int preIndex = 0;

    private tNode buildTree(char in[], char pre[], int inStrt, int inEnd) {
        if (inStrt > inEnd) {
            return null;
        }

        /* Pick current node from Preorder traversal using preIndex
           and increment preIndex */
        tNode tNode = new tNode(pre[preIndex++]);

        /* If this node has no children then return */
        if (inStrt == inEnd) {
            return tNode;
        }

        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(in, inStrt, inEnd, tNode.data);

        tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);

        return tNode;
    }

    private int search(char arr[], int start, int end, char value) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return i;
    }

    private void printInorder(tNode node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String args[]) {
        BuildTree tree = new BuildTree();
        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;
        tNode root = tree.buildTree(in, pre, 0, len - 1);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
        System.out.println();
    }

}
