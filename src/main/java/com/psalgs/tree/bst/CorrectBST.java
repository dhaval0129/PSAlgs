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
 * http://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
 *
 * Two nodes of a BST are swapped, correct the BST
 * 
 * Time Complexity O(n)
 */
public class CorrectBST {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;
    tNode first, last, prev;

    private void findSegments(tNode node) {

        if (node == null) {
            return;
        }

        findSegments(node.left);
        
        if (prev != null) {
            if (prev.data > node.data) {
                if (first == null) {
                    first = prev;
                }
                last = node;
            }
        }
        prev = node;
        findSegments(node.right);
    }

    private void recoverTree(tNode node) {
        findSegments(node);
        int x = first.data;
        first.data = last.data;
        last.data = x;
    }
    
    private void printInorder(tNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String args[]) {
        CorrectBST tree = new CorrectBST();
        tree.root = new tNode(10);
        tree.root.left = new tNode(5);
        tree.root.right = new tNode(8);
        tree.root.left.left = new tNode(2);
        tree.root.left.right = new tNode(20);

        tree.printInorder(tree.root);
        System.out.println();
        tree.recoverTree(tree.root);
        tree.printInorder(tree.root);
        System.out.println();
    }

}
