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
 * http://www.geeksforgeeks.org/find-the-minimum-element-in-a-binary-search-tree/
 *
 * Find the node with minimum value in a Binary Search Tree
 *
 */
public class MinValue {

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

    private void insert(int key) {
        root = insertRec(key, root);
    }

    private tNode insertRec(int key, tNode node) {

        if (node == null) {
            node = new tNode(key);
            return node;
        }

        if (key < node.data) {
            node.left = insertRec(key, node.left);
        } else if (key > node.data) {
            node.right = insertRec(key, node.right);
        }
        
        // return unchanged node pointer
        return node;
    }

    private int minValue(tNode node) {
        
        while(node.left != null) {
            node = node.left;
        }
        
        return node.data;
    }
    
    public static void main(String args[]) {
        MinValue tree = new MinValue();
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(5);

        System.out.println("The Minimum value: " + tree.minValue(tree.root));
    }
}
