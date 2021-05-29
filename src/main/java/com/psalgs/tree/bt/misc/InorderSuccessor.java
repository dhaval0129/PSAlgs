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
 * http://www.geeksforgeeks.org/populate-inorder-successor-for-all-nodes/
 *
 * Populate In-order Successor for all nodes
 * 
 * 
 * Time Complexity: O(n)
 */
public class InorderSuccessor {

    static class tNode {

        int data;
        tNode left;
        tNode right;
        tNode next;

        tNode(int d) {
            data = d;
            left = right = next = null;
        }
    }

    tNode root;
    // Note: if static node is not needed then pass next node parameter in recursive function call
    static tNode next = null;

    // Try doing in-order traversal of tree manually first & check successor
    private void populateNext(tNode node) {

        if (node != null) {
            // First set the next pointer in right subtree
            populateNext(node.right);

            // Set the next as previously visited node in reverse Inorder
            node.next = next;

            // Change the prev for subsequent node
            next = node;

            // Finally, set the next pointer in left subtree
            populateNext(node.left);
        }
    }

    /* Driver program to test above functions*/
    public static void main(String args[]) {
        /* Constructed binary tree is
            10
           /   \
          8      12
         /
        3    */
        InorderSuccessor tree = new InorderSuccessor();
        tree.root = new tNode(10);
        tree.root.left = new tNode(8);
        tree.root.left.left = new tNode(3);
        tree.root.right = new tNode(12);
//        tree.root.right.left = new tNode(11);
//        tree.root.right.right = new tNode(13);

        // Populates nextRight pointer in all nodes
        tree.populateNext(tree.root);

        // Let us see the populated values
        tNode ptr = tree.root.left.left;
        while (ptr != null) {
            // -1 is printed if there is no successor
            int print = ptr.next != null ? ptr.next.data : -1;
            System.out.println("Next of " + ptr.data + " is: " + print);
            ptr = ptr.next;
        }
    }
}
