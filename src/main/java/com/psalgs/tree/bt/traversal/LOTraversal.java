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
 * Breath First Search is also called as Level Order Traversal
 * 
 * Time Complexity O(n ^ 2)
 */
public class LOTraversal {

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

    private LOTraversal() {
        root = null;
    }

    private int height(tNode root) {

        if (root == null) {
            return 0;
        } else {
            int lheight = height(root.left);
            int rheight = height(root.right);

            if (lheight > rheight) {
                return (lheight + 1);
            } else {
                return (rheight + 1);
            }
        }
    }

    // Breath First Search is also called as Level Order Traversal
    private void printLevelOrder() {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printGivenLevel(root, i);
        }
    }

    private void printGivenLevel(tNode root, int level) {
        // base case
        if (root == null) {
            return;
        }

        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    public static void main(String args[]) {
        LOTraversal tree = new LOTraversal();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        
        System.out.println("Level order traversal or BFS of binary tree is ");
        tree.printLevelOrder();
        System.out.println();
    }

}
