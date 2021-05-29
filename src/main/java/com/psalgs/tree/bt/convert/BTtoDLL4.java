/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.convert;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-4/
 *
 * Convert a given Binary Tree to Doubly Linked List
 *
 * Time Complexity: O(n), as the solution does a single traversal of given
 * Binary Tree
 *
 */
public class BTtoDLL4 {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    Node root;
    Node head;

    // Utility function for printing double linked list.
    void printList(Node head) {
        System.out.println("Extracted Double Linked List is : ");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }
        System.out.println();
    }

    // A simple recursive function to convert a given
    // Binary tree to Doubly Linked List
    private void BToDLL(Node root) {
        // Base cases
        if (root == null) {
            return;
        }

        // Recursively convert right subtree
        BToDLL(root.right);

        // insert root into DLL
        root.right = head;

        // Change left pointer of previous head
        if (head != null) {
            head.left = root;
        } 
        // Change head of Doubly linked list
        head = root;

        // Recursively convert left subtree
        BToDLL(root.left);
    }

    public static void main(String args[]) {
        /* Constructing below tree        
               5
             /   \
            3     6
           / \     \
          1   4     8
         / \       / \
        0   2     7   9          
         */

        BTtoDLL4 tree = new BTtoDLL4();
        tree.root = new Node(5);
        tree.root.left = new Node(3);
        tree.root.right = new Node(6);
        tree.root.left.right = new Node(4);
        tree.root.left.left = new Node(1);
        tree.root.right.right = new Node(8);
        tree.root.left.left.right = new Node(2);
        tree.root.left.left.left = new Node(0);
        tree.root.right.right.left = new Node(7);
        tree.root.right.right.right = new Node(9);
        tree.BToDLL(tree.root);
        tree.printList(tree.head);
    }
}
