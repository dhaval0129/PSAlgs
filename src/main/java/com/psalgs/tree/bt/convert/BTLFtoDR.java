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
 * http://www.geeksforgeeks.org/convert-left-right-representation-bianry-tree-right/
 *
 * Convert left-right representation of a binary tree to down-right
 * 
 * Time complexity of the program is O(n).
 *
 */
public class BTLFtoDR {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;

    // left will be down pointer and right pointer will right 
    private void convertDownRight(tNode node) {
        if (node == null) {
            return;
        }

        convertDownRight(node.left);
        convertDownRight(node.right);

        if (node.left == null) {
            node.left = node.right;
        } else {
            node.left.right = node.right;
        }

        node.right = null;
    }

    private void downRightTraversal(tNode node) {
        if(node != null) {
            System.out.print(node.data +" ");
            downRightTraversal(node.right);
            downRightTraversal(node.left);
        }
    }
            
    public static void main(String args[]) {
        // Let us create binary tree shown in above diagram
        /*
           1
         /   \
        2     3
             / \
            4   5
           /   /  \
          6   7    8
         */
        BTLFtoDR tree = new BTLFtoDR();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.right.left = new tNode(4);
        tree.root.right.right = new tNode(5);
        tree.root.right.left.left = new tNode(6);
        tree.root.right.right.left = new tNode(7);
        tree.root.right.right.right = new tNode(8);

        tree.convertDownRight(tree.root);
        tree.downRightTraversal(tree.root);
        System.out.println();
    }

}
