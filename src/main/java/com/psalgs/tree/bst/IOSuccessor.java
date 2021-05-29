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
 * http://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
 *
 * In-order Successor in Binary Search Tree
 *
 * Time Complexity: O(h) where h is height of tree
 *
 */
public class IOSuccessor {

    static class tNode {

        int data;
        tNode left;
        tNode right;
        tNode parent;

        tNode(int d) {
            data = d;
            left = right = parent = null;
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

        tNode temp = null;

        if (key < node.data) {
            temp = insertRec(key, node.left);
            node.left = temp;
            temp.parent = node;

        } else if (key > node.data) {
            temp = insertRec(key, node.right);
            node.right = temp;
            temp.parent = node;
        }

        return node;
    }

    private tNode inOrderSuccessor(tNode node) {
        if (node.right != null) {
            return minValue(node.right);
        }

        tNode p = node.parent;
        while (p != null && node == p.right) {
            node = p;
            p = p.parent;
        }

        return p;
    }

    // method 2 to find inorder successor from root node 
    private tNode inOrderSuccessor2(tNode node) {

        if (node.right != null) {
            return minValue(node.right);
        }

        tNode curr = root;
        tNode succ = null;

        while (curr != null) {
            if (node.data < curr.data) {
                succ = curr;
                curr = curr.left;
            } else if (node.data > curr.data) {
                curr = curr.right;
            } else {
                break;
            }
        }

        return succ;
    }

    private tNode minValue(tNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String args[]) {
        IOSuccessor tree = new IOSuccessor();

        tree.insert(20);
        tree.insert(8);
        tree.insert(22);
        tree.insert(4);
        tree.insert(12);
        tree.insert(10);
        tree.insert(14);
        // find inorder successor for 14
        tNode temp = tree.root.left.right.right;
        tNode suc = tree.inOrderSuccessor2(temp);

        if (suc != null) {
            System.out.println("Inorder successor of " + temp.data + " is " + suc.data);
        } else {
            System.out.println("Inorder successor does not exist");
        }
    }
}
