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
 * Design an algorithm and write code to find the first common ancestor of two
 * nodes in a binary tree. Avoid storing additional nodes in a data structure.
 * NOTE: This is not necessarily a binary search tree.
 *
 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 * 
 * Time Complexity: O(n)
 *
 */
public class FirstCommonAncestor {

    static class Node {

        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static Node root;

    private Node findLCA(int n1, int n2) {
        return findLCA(root, n1, n2);
    }

    private Node findLCA(Node node, int n1, int n2) {
        // Base case 
        if (node == null) {
            return null;
        }

        // If either n1 or n2 matches with root's key, report 
        // the presence by returning root
        if (node.data == n1 || node.data == n2) {
            return node;
        }

        // Look for keys in left and right subtrees 
        Node leftLca = findLCA(node.left, n1, n2);
        Node rightLca = findLCA(node.right, n1, n2);

        if (leftLca != null && rightLca != null) {
            return node;
        }
        
        // Otherwise check if left subtree or right subtree is LCA 
        return (leftLca != null) ? leftLca : rightLca; 
    }

    public static void main(String args[]) {
        FirstCommonAncestor tree = new FirstCommonAncestor();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("LCA(4, 5) = " + tree.findLCA(4, 5).data);
        System.out.println("LCA(4, 6) = " + tree.findLCA(4, 6).data);
        System.out.println("LCA(3, 4) = " + tree.findLCA(3, 4).data);
        System.out.println("LCA(2, 4) = " + tree.findLCA(2, 4).data);
    }
}
