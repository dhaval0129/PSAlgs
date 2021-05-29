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
 * http://www.geeksforgeeks.org/construct-tree-inorder-level-order-traversals/
 *
 * Construct a tree from in-order and level-order traversals
 *
 */
public class BuildTree4 {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int item) {
            data = item;
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

    private tNode buildTree(int in[], int level[]) {
        return constructTree(level, in, 0, in.length - 1);
    }

    private tNode constructTree(int[] levelOrder,
            int[] inOrder, int inStart, int inEnd) {

        // if start index is more than end index
        if (inStart > inEnd) {
            return null;
        }

        tNode node = null;

        if (inStart == inEnd) {
            return new tNode(inOrder[inStart]);
        }

        boolean found = false;
        int index = 0;

        for (int i = 0; i < levelOrder.length - 1; i++) {
            int data = levelOrder[i];

            for (int j = inStart; j < inEnd; j++) {

                if (data == inOrder[j]) {
                    node = new tNode(data);
                    index = j;
                    found = true;
                    break;
                }
            }

            if (found) {
                break;
            }
        }

        node.left = constructTree(levelOrder, inOrder, inStart, index - 1);
        node.right = constructTree(levelOrder, inOrder, index + 1, inEnd);

        return node;
    }

    public static void main(String args[]) {
        BuildTree4 tree = new BuildTree4();
        int in[] = {4, 8, 10, 12, 14, 20, 22};
        int level[] = {20, 8, 22, 4, 12, 10, 14};

        tNode node = tree.buildTree(in, level);

        /* Let us test the built tree by printing Inorder traversal */
        System.out.println("Inorder traversal of the constructed tree is ");
        tree.printInorder(node);
        System.out.println();
    }

}
