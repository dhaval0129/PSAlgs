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
 * Given a binary tree, design an algorithm which creates a linked list of all
 * the nodes at each depth ( Connect nodes at same level )
 *
 * https://www.geeksforgeeks.org/connect-nodes-at-same-level/
 *
 *
 */
public class TreeListEachLevel {

    static class Node {

        int data;
        Node left, right, nextRight;

        Node(int item) {
            data = item;
            left = right = nextRight = null;
        }
    }

    static Node root;

    private void connect(Node node) {
        // set the nextRight for root
        node.nextRight = null;

        // Set the next right for rest of the nodes 
        // ( other than root )
        connectRecur(node);
    }

    private void connectRecur(Node node) {
        // base case
        if (node == null) {
            return;
        }

        // Set the nextRight pointer for node's left child
        if (node.left != null) {
            node.left.nextRight = node.right;
        }

        // Set the nextRight pointer for node's right child 
        // node -> nextRight will be NULL if node is the right most child  
        // at its level 
        if (node.right != null) {
            node.right.nextRight = (node.nextRight != null) ? node.nextRight.left : null;
        }

        // Set nextRight for other nodes in pre order fashion 
        connectRecur(node.left);
        connectRecur(node.right);
    }

    public static void main(String args[]) {
        TreeListEachLevel tree = new TreeListEachLevel();
        /* Constructed binary tree is 
             10 
            /  \ 
          8     2 
         / 
        3 
         */
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);

        // Populates nextRight pointer in all nodes 
        tree.connect(tree.root);

        // Let us check the values of nextRight pointers 
        System.out.println("Following are populated nextRight pointers in "
                + "the tree (-1 is printed if there is no nextRight )");
        
        int a = tree.root.nextRight != null ? tree.root.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.data + " is " + a);
        
        int b = tree.root.left.nextRight != null ? tree.root.left.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.left.data + " is " + b);
       
        int c = tree.root.right.nextRight != null ? tree.root.right.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.right.data + " is " + c);
        
        int d = tree.root.left.left.nextRight != null ? tree.root.left.left.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.left.left.data + " is " + d);
    }
}
