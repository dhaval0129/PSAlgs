/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.misc;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/print-ancestors-of-a-given-node-in-binary-tree/
 *
 * Print Ancestors of a given node in Binary Tree
 * 
 *  Time Complexity: O(n) 
 *
 */
public class PrintAncestors {

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

    private boolean printAncestors(tNode node, int target) {
        /* base cases */
        if (node == null) {
            return false;
        }

        if (node.data == target) {
            return true;
        }

        if (printAncestors(node.left, target) || printAncestors(node.right, target)) {
            System.out.print(node.data +" ");
            return true;
        }
        
        return false;
    }

    public static void main(String args[]) {
        PrintAncestors tree = new PrintAncestors();
        /* Construct the following binary tree
                  1
                /   \
               2     3
              /  \
             4    5
            /
           7
         */
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.left.left.left = new tNode(7);

        tree.printAncestors(tree.root, 7);
        System.out.println();
    }

}
