/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.traversal;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/print-postorder-from-given-inorder-and-preorder-traversals/
 *
 * Print Postorder traversal from given Inorder and Preorder traversals
 *
 * Time Complexity O(n^2)
 *
 * A naive is to first construct the tree, then use simple recursive
 * method to print postorder traversal of the constructed tree.
 */
public class PostorderTraversal {

    static class tNode {

        int data;
        tNode right;
        tNode left;

        tNode(int d) {
            data = d;
            right = left = null;
        }
    }

    tNode root;
    int preIndex;

    private void printPostOrder(tNode node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data + " ");
    }

    private tNode constructTree(int pre[], int in[], int start, int end) {

        if (start > end) {
            return null;
        }

        tNode node = new tNode(pre[preIndex++]);

        if (start == end) {
            return node;
        }

        // search node in postorder array
        int i;
        for (i = start; i <= end; i++) {
            if (node.data == in[i]) {
                break;
            }
        }

        node.left = constructTree(pre, in, start, i - 1);
        node.right = constructTree(pre, in, i + 1, end);

        return node;
    }

    public static void main(String args[]) {
        PostorderTraversal tree = new PostorderTraversal();
        int pre[] = {1, 2, 4, 5, 3, 6};
        int in[] = {4, 2, 5, 1, 3, 6};
        int size = pre.length;

        tNode node = tree.constructTree(pre, in, 0, size - 1);
        tree.printPostOrder(node);
        System.out.println();
    }
}
