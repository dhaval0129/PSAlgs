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
 * http://www.geeksforgeeks.org/second-largest-element-in-binary-search-tree-bst/
 * 
 * Second largest element in BST
 * 
 * 1] Start visiting the node from left to right 
 * 2] keep track of max1 value on each node
 * 3] if node data is greater then max1 then update max1 and assign old value of max1 to max2
 * 4] visit each node recursively this way, repeat step 1 to step 3 till all nodes have been visited
 * 
 */
public class SecondLargest {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;
    int max1, max2;
    
    private void insert(int data) {
        root = insertUtil(root, data);
    }

    private tNode insertUtil(tNode node, int data) {
        // base case
        if (node == null) {
            node = new tNode(data);
            return node;
        }

        if (data < node.data) {
            node.left = insertUtil(node.left, data);
        } else if (data > node.data) {
            node.right = insertUtil(node.right, data);
        }
        return node;
    }

    private void inorder(tNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    private void secondLargest(tNode node) {
        // base case
        if (node == null) {
            return;
        }
        
        secondLargest(node.left);
        // logic to find second largest node
        if(node.data > max1) {
            max2 = max1;
            max1 = node.data;
        }
        secondLargest(node.right);        
    }

    public static void main(String args[]) {
        SecondLargest tree = new SecondLargest();
        tree.insert(10);
        tree.insert(5);
        tree.insert(20);
        tree.insert(30);
        tree.inorder(tree.root);
        tree.secondLargest(tree.root);
        System.out.println("\nSecond Largest Element: "+tree.max2);        
    }

}
