/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bst;

import java.util.Stack;

/**
 *
 * @author djoshi
 * 
 * http://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversal-set-2/
 * 
 * Construct BST from given pre-order traversal
 * 
 */
public class ConstructBST3 {

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

    private void printInorder(tNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    private tNode constructTree(int[] pre, int size) {
        tNode node = new tNode(pre[0]);
        Stack<tNode> s = new Stack<>();

        s.push(node);

        for (int i = 1; i < size; ++i) {
            tNode temp = null;

            while (!s.isEmpty() && pre[i] > s.peek().data) {
                temp = s.pop();
            }

            if (temp != null) {
                temp.right = new tNode(pre[i]);
                s.push(temp.right);
            } else {
                temp = s.peek();
                temp.left = new tNode(pre[i]);
                s.push(temp.left);
            }
        }
        return node;
    }

    public static void main(String args[]) {
        ConstructBST3 tree = new ConstructBST3();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        tNode root = tree.constructTree(pre, size);
        System.out.println("Inorder traversal of the constructed tree: ");
        tree.printInorder(root);
        System.out.println();
    }
}
