/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.list.doubly;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/convert-a-binary-tree-to-a-circular-doubly-link-list/
 *
 *
 * Convert a Binary Tree to a Circular Doubly Linked List
 *
 */
// Note class Node is used from BToDLL.java class
class Tree {

    Node root;

    protected Tree() {
        root = null;
    }

    // Display Circular Link List
    protected void display(Node head) {
        System.out.println("Circular Linked List is :");
        Node curr = head;

        do {
            System.out.print(curr.data + " ");
            curr = curr.right;
        } while (curr != head);

        System.out.println();
    }

    private Node concatenate(Node leftList, Node rightList) {
        // If either of the list is empty, then
        // return the other list
        if (leftList == null) {
            return rightList;
        }
        if (rightList == null) {
            return leftList;
        }

        // Store the last Node of left List
        Node leftLast = leftList.left;

        // Store the last Node of right List
        Node rightLast = rightList.left;

        // Connect the last node of Left List
        // with the first Node of the right List
        leftLast.right = rightList;
        rightList.left = leftLast;

        // left of first node refers to
        // the last node in the list
        leftList.left = rightLast;

        // Right of last node refers to the first
        // node of the List
        rightLast.right = leftList;

        // Return the Head of the List
        return leftList;
    }

    protected Node bTreeToCList(Node root) {
        if (root == null) {
            return null;
        }

        // Recursively convert left and right subtrees
        Node left = bTreeToCList(root.left);
        Node right = bTreeToCList(root.right);

        // Make a circular linked list of single node
        // (or root). To do so, make the right and
        // left pointers of this node point to itself
        root.left = root.right = root;

        // Step 1 (concatenate the left list with the list 
        //         with single node, i.e., current node)
        // Step 2 (concatenate the returned list with the
        //         right List)
        return concatenate(concatenate(left, root), right);
    }
}

public class BToDCLL {

    public static void main(String args[]) {
        /* Constructing below tree        
                    10
                  /    \
                 12    15
                / \    / 
              25  30  36         
        */

        Tree tree = new Tree();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);
        tree.root.right.right = new Node(40);

        // head refers to the head of the Link List
        Node head = tree.bTreeToCList(tree.root);

        // Display the Circular LinkedList
        tree.display(head);
    }

}
