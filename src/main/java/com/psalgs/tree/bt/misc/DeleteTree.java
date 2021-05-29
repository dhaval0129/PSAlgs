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
 * http://www.geeksforgeeks.org/write-a-c-program-to-delete-a-tree/
 *
 * Write a program to Delete a Tree.
 *
 */
public class DeleteTree {

    static class tNode {

        int data;
        tNode right, left;

        tNode(int d) {
            data = d;
            right = left = null;
        }
    }

    tNode root;

    private void deleteTree(tNode node) {

        if (node == null) {
            return;
        }
        
         /* first delete both subtrees */
        deleteTree(node.left);
        deleteTree(node.right);
        
        /* then delete the node */
        System.out.println("The deleted node is " + node.data);
        node = null;
    }

    public static void main(String args[]) {
        DeleteTree tree = new DeleteTree();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.deleteTree(tree.root);
        tree.root = null;
        System.out.println("Tree Deleted");
    }
}
