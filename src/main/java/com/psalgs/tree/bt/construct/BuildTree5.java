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
 * http://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
 *
 * Construct a Binary Tree from Postorder and In-order arrays
 *
 */
public class BuildTree5 {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
        }
    }

    tNode root;

    private void preOrder(tNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    static int postIndex;

    private tNode constructTreeUtil(int[] in, int[] post, int start, int end) {
        if (start > end) {
            return null;
        }

        tNode node = new tNode(post[postIndex--]);

        if (start == end) {
            return node;
        }

        // search from inorder array
        int i;
        for (i = start; i <= end; i++) {
            if (in[i] ==  node.data) {
                break;
            }
        }

        node.left = constructTreeUtil(in, post, i + 1, end);
        node.right = constructTreeUtil(in, post, start, i - 1);
        
        return node;
    }

    public static void main(String args[]) {
        BuildTree5 tree = new BuildTree5();
        int[] in = {4, 8, 2, 5, 1, 6, 3, 7};
        int[] post = {8, 4, 5, 2, 6, 7, 3, 1};

        int len = in.length - 1;
        postIndex = len;
        tNode node = tree.constructTreeUtil(in, post, 0, len);
        tree.preOrder(node);
        System.out.println();
    }
}
