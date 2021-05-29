/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.convert;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/convert-normal-bst-balanced-bst/
 *
 * Convert a normal BST to Balanced BST
 *
 */
public class BalanceBST {

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

    /* Function to do preorder traversal of tree */
    private void preOrder(tNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private void storeBSTNodes(tNode node, List<tNode> nodes) {
        // Base case
        if (node == null) {
            return;
        }

        // Store nodes in Inorder (which is sorted
        // order for BST)
        storeBSTNodes(node.left, nodes);
        nodes.add(node);
        storeBSTNodes(node.right, nodes);
    }

    private tNode buildTreeUtil(List<tNode> nodes, int start, int end) {
        if(start > end){
            return null;
        }
        
        int mid = (start + end) / 2;
        tNode node = nodes.get(mid);
        
        /* Using index in Inorder traversal, construct
           left and right subtrees */
        node.left = buildTreeUtil(nodes, start, mid - 1 );
        node.right = buildTreeUtil(nodes, mid + 1, end);
        
        return node;
    }

    private tNode buildTree(tNode node) {
        // Store nodes of given BST in sorted order 
        // with inorder traversal
        List<tNode> nodes = new ArrayList<>();
        storeBSTNodes(node, nodes);
        
        int len = nodes.size();
        return buildTreeUtil(nodes, 0, len-1);
    }

    public static void main(String args[]) {
        /* Constructed skewed binary tree is
                10
               /
              8
             /
            7
           /
          6
         /
        5   */
        BalanceBST tree = new BalanceBST();
        tree.root = new tNode(10);
        tree.root.left = new tNode(8);
        tree.root.left.left = new tNode(7);
        tree.root.left.left.left = new tNode(6);
        tree.root.left.left.left.left = new tNode(5);

        tree.root = tree.buildTree(tree.root);
        System.out.println("Preorder traversal of balanced BST is :");
        tree.preOrder(tree.root);
        System.out.println();
    }
}
