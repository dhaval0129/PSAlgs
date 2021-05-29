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
 * http://www.geeksforgeeks.org/inorder-predecessor-successor-given-key-bst/
 *
 * http://www.makeinjava.com/find-inorder-predecessor-binary-search-tree-bst-examples/
 *
 * In-order predecessor of BST
 *
 * Time Complexity: O(h) where h is height of tree
 *
 */
public class IOPredecessor {

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

    private tNode inOrderPredecessor(tNode node) {
        if (node.left != null) {
            return maxValue(node.left);
        }

        tNode pred = null;
        tNode curr = root;
        while (curr != null) {

            if (node.data == curr.data) {
                // by now we might found our predecessor
                break;
            } else if (node.data < curr.data) {
                curr = curr.left;
            } else if (node.data > curr.data) {
                pred = curr;
                curr = curr.right;
            }
        }
        return pred;
    }

    private tNode maxValue(tNode node) {

        while (node.right != null) {
            node = node.right;
        }

        return node;
    }

    public static void main(String args[]) {
        IOPredecessor tree = new IOPredecessor();
        tree.root = new tNode(20);
        tree.root.left = new tNode(10);
        tree.root.right = new tNode(30);
        tree.root.left.left = new tNode(5);
        tree.root.left.left.right = new tNode(7);
        tree.root.left.right = new tNode(15);
        tree.root.right.left = new tNode(25);
        tree.root.right.right = new tNode(35);
        tree.root.left.right.left = new tNode(13);
        tree.root.left.right.right = new tNode(18);

        tNode temp = tree.root.left.right.right;
        tNode pred = tree.inOrderPredecessor(temp);

        if (pred != null) {
            System.out.println("Inorder predecessor of " + temp.data + " is " + pred.data);
        } else {
            System.out.println("Inorder predecessor does not exist");
        }
    }

}
