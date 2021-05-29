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
 * http://www.geeksforgeeks.org/count-bst-nodes-that-are-in-a-given-range/
 * 
 * Count BST nodes that lie in a given range
 * 
 * 
 * 
 */
public class BSTRange {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;

    private int getCount(tNode node, int low, int high) {
        //base case
        if (node == null) {
            return 0;
        }

        if (node.data >= low && node.data <= high) {
            return (1 + getCount(node.left, low, high)
                    + getCount(node.right, low, high));
        } else if (node.data < low) {
            return getCount(node.right, low, high);
        } else {
            return getCount(node.left, low, high);
        }
    }

    public static void main(String[] args) {
        BSTRange tree = new BSTRange();

        tree.root = new tNode(10);
        tree.root.left = new tNode(5);
        tree.root.right = new tNode(50);
        tree.root.left.left = new tNode(1);
        tree.root.right.left = new tNode(40);
        tree.root.right.right = new tNode(100);
        /* Let us constructed BST shown in above example
                10
              /    \
            5       50
           /       /  \
          1       40   100   */
        int l = 5;
        int h = 45;
        System.out.println("Count of nodes between [" + l + ", "
                + h + "] is " + tree.getCount(tree.root,
                        l, h));
    }
}
