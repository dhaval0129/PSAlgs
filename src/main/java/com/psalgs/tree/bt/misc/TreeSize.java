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
 * http://www.geeksforgeeks.org/write-a-c-program-to-calculate-size-of-a-tree/
 * 
 * http://algorithms.tutorialhorizon.com/find-the-size-of-the-binary-tree/
 *
 * Write a program to Calculate Size of a tree ( Number of elements or nodes present in the tree )
 *
 */
public class TreeSize {

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
    
    private int size() {
        return size(root);
    }
    
    private int size(tNode node) {
        if (node == null) {
            return 0;
        } else {
            return (size(node.left) + 1 + size(node.right));
        }
    }

    public static void main(String args[]) {
        TreeSize tree = new TreeSize();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);

        System.out.println("The size of binary tree is : " + tree.size());
    }
}
