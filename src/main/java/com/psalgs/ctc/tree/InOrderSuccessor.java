/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.ctc.tree;

/**
 *
 * @author djoshi
 *
 * Write an algorithm to find the "next" node (i.e., in-order successor) of a
 * given node in a binary search tree. You may assume that each node has a link
 * to its parent.
 *
 * https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
 *
 * Time Complexity: O(h) where h is height of tree.
 *
 */
public class InOrderSuccessor {

    static class Node {

        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node root;

    private Node inOrderSuccessor(Node node, Node dest) {

        // If node does have right node 
        // then leftmost child of right node is inorder successor
        if (dest.right != null) {
            return minValue(dest.right);
        }

        Node parent = null;
        while (node != null) {
            if (dest.data < node.data) {
                parent = node;
                node = node.left;
            } else if (dest.data > node.data) {
                node = node.right;
            } else {
                break;
            }
        }

        return parent;
    }

    private Node minValue(Node node) {
        Node current = node;

        /* loop down to find the left most leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public static void main(String args[]) {

        InOrderSuccessor tree = new InOrderSuccessor();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        //Node temp = root.left.right.right; // 14
        Node temp = root.left.right; // 12
        //Node temp = root.left; // 8
        Node successor = tree.inOrderSuccessor(root, temp);

        if (successor != null) {
            System.out.println("Inorder successor of " + temp.data + " is " + successor.data);
        } else {
            System.out.println("Inorder successor does not exist");
        }

    }
}
