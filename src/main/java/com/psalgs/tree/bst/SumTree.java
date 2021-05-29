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
 * http://www.geeksforgeeks.org/transform-bst-sum-tree/
 * 
 * Transform a BST to greater sum tree
 * 
 */
public class SumTree {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right;
        }
    }
    
    static class Sum {
        int value;
    }

    tNode root;

    private void inorder(tNode node) {
        if (node == null) {
            return;
        }
        
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
    
    private void sumTree(tNode node, Sum sum) {
        if(node == null) {
            return;
        }
        
        sumTree(node.right, sum);
        sum.value = sum.value + node.data;
        node.data = sum.value - node.data;
        sumTree(node.left, sum);
    }

    public static void main(String args[]) {
        SumTree tree = new SumTree();
        Sum sum = new Sum();
        
        tree.root = new tNode(11);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(29);
        tree.root.left.left = new tNode(1);
        tree.root.left.right = new tNode(7);
        tree.root.right.left = new tNode(15);
        tree.root.right.right = new tNode(40);
        tree.root.right.right.left = new tNode(35);

        System.out.println("Original tree: ");
        tree.inorder(tree.root);
        tree.sumTree(tree.root, sum);
        System.out.println("\nSum Tree: ");
        tree.inorder(tree.root);
        System.out.println();
    }

}
