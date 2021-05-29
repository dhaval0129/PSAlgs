/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.misc;

/**
 *
 * @author djoshi
 */
public class TreeDelete {

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

    private void deleteTree(tNode node) {
        if (node == null) {
            return;
        }

        deleteTree(node.left);
        deleteTree(node.right);

        /* then delete the node */
        System.out.println("The deleted node is " + node.data);
        node = null;

    }

    public static void main(String args[]) {
        TreeDelete tree = new TreeDelete();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);

        tree.deleteTree(tree.root);
    }

}
