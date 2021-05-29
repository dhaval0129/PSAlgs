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
 * A binary search tree was created by traversing through an array from left to
 * right and inserting each element. Given a binary search tree with distinct
 * elements, print all possible arrays that could have led to this tree
 *
 *
 */
public class BSTSequences {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private static void preorder(Node node) {
        if (node != null) {
            System.out.println(node.data + " ");
            System.out.println(node.left);
            System.out.println(node.right);
        }
    }



    public static void main(String args[]) {

    }
}
