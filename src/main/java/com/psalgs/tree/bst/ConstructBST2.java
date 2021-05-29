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
 * http://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
 *
 * Construct BST from given pre-order traversal
 *
 */
public class ConstructBST2 {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    static class Index {

        int index;
    }

    tNode root;
    Index index = new Index();

    private void printInorder(tNode node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    private tNode constructTree(int[] pre, int size) {
        tNode node = constructTreeUtil(pre, index, 0, size - 1, size);
        return node;
    }

    private tNode constructTreeUtil(int[] pre, Index preIndex, int low, int high, int size) {
        // Base case
        if (preIndex.index >= size || low > high) {
            return null;
        }

        tNode node = new tNode(pre[preIndex.index++]);

        if (low == high) {
            return node;
        }

        int i;
        for (i = low; i <= high; i++) {
            if (pre[i] > node.data) {
                break;
            }
        }

        node.left = constructTreeUtil(pre, index, 0, i - 1, size);
        node.right = constructTreeUtil(pre, index, i + 1, high, size);

        return node;
    }

    public static void main(String args[]) {
        ConstructBST2 tree = new ConstructBST2();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        tree.root = tree.constructTree(pre, size);
        System.out.println("Inorder traversal of the constructed tree");
        tree.printInorder(tree.root);
        System.out.println();
    }
}
