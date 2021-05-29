/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.traversal;

/**
 *
 * @author djoshi
 */
public class ReverseLOTraversal {

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

    private void printReverseLevelOrder() {
        int h = getHeight(root);
        for (int i = h; i > 0; i--) {
            printLevel(root, i);
        }
    }

    private void printLevel(tNode node, int level) {
        if (node == null) {
            return;
        }

        if (level == 1) {
            System.out.print(node.data + " ");
        } else {
            printLevel(node.left, level - 1); // --level
            printLevel(node.right, level - 1); // level--
        }
    }

    private int getHeight(tNode node) {

        if (node == null) {
            return 0;
        } else {
            int lheight = getHeight(node.left);
            int rheight = getHeight(node.right);

            if (lheight > rheight) {
                return (lheight + 1);
            } else {
                return (rheight + 1);
            }
        }
    }

    public static void main(String args[]) {
        ReverseLOTraversal tree = new ReverseLOTraversal();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);

        System.out.println("Reverse level order traversal or Reverse BFS of binary tree is ");
        tree.printReverseLevelOrder();
        System.out.println();
    }
}
