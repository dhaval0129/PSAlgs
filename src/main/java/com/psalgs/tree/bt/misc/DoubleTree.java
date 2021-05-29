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
 * http://www.geeksforgeeks.org/double-tree/
 * 
 * Convert Tree to Double Tree
 * 
 * To create Double tree of the given tree, 
 * create a new duplicate for each node, 
 * and insert the duplicate as the left child of the original node. 
 * 
 * Time Complexity O(n)
 */
public class DoubleTree {

    static class tNode {

        int data;
        tNode right;
        tNode left;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;
    
    private void printInOrder(tNode node) {
        if(node == null) {
            return;
        }
        
        printInOrder(node.left);
        System.out.print(node.data +" ");
        printInOrder(node.right);
    }
    
    // Do the postorder traversal and then attach node to left
    private void doubleTree(tNode node) {
        
        if(node == null) {
            return;
        }

        doubleTree(node.left);
        doubleTree(node.right);
        /* duplicate this node to its left */
        tNode temp = node.left; // store the address of current left node to temp
        node.left = new tNode(node.data);  // add new node to left of existing node
        node.left.left = temp; // point left of new node which left.left of old node to next left node
    }
    
    public static void main(String args[]) {
        /* Constructed binary tree is
              1
            /   \
           2     3
         /  \
        4    5
        */
        DoubleTree tree = new DoubleTree();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        System.out.println("Original Inorder traversal of Tree");
        tree.printInOrder(tree.root);
        System.out.println();
        System.out.println("Make double tree" );
        tree.doubleTree(tree.root);
        tree.printInOrder(tree.root);
        System.out.println();
    }

}
