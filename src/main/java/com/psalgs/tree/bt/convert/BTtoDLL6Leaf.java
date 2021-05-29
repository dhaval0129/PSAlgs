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
 * http://www.geeksforgeeks.org/connect-leaves-doubly-linked-list/
 *
 * Extract Leaves of a Binary Tree in a Doubly Linked List
 *
 */
public class BTtoDLL6Leaf {

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
    tNode head, prev;

    private tNode extractLeafList(tNode node) {
        // base case
        if (node == null) {
            return null;
        }

        // If node is leaf node add it DLL
        if (node.left == null && node.right == null) {

            if (head == null) {
                head = node;
            } else {
                prev.right = node;
                node.left = prev;
            }
            prev = node;
            return null;
        }

        node.left = extractLeafList(node.left);
        node.right = extractLeafList(node.right);
        return node;
    }

    //Prints the DLL in both forward and reverse directions.
    public void printDLL(tNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.right;
        }
    }

    private void inorder(tNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String args[]) {
        BTtoDLL6Leaf tree = new BTtoDLL6Leaf();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);

        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.right.right = new tNode(6);
        tree.root.left.left.left = new tNode(7);
        tree.root.left.left.right = new tNode(8);
        tree.root.right.right.left = new tNode(9);
        tree.root.right.right.right = new tNode(10);

        System.out.println("Inorder traversal of given tree is : ");
        tree.inorder(tree.root);
        tree.extractLeafList(tree.root);
        System.out.println("");
        System.out.println("Extracted double link list is : ");
        tree.printDLL(tree.head);
        System.out.println("");
        System.out.println("Inorder traversal of modified tree is : ");
        tree.inorder(tree.root);
        System.out.println();
    }

}
