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
 * http://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/
 *
 * Connect nodes at same level using constant extra space
 *
 */
public class ConnectNodes2 {

    static class tNode {

        int data;
        tNode left;
        tNode right;
        tNode nextRight;

        tNode(int d) {
            data = d;
            nextRight = left = right = null;
        }
    }

    tNode root;

    /* This function returns the leftmost child of nodes at the same
       level as p. This function is used to getNExt right of p's right child
       If right child of p is NULL then this can also be used for 
       the left child */
    private tNode getNextRight(tNode p) {
        tNode temp = p.nextRight;

        /* Traverse nodes at p's level and find and return
         the first node's first child */
        while (temp != null) {
            if (temp.left != null) {
                return temp.left;
            }
            if (temp.right != null) {
                return temp.right;
            }
            temp = temp.nextRight;
        }
        // If all the nodes at p's level are leaf nodes then return NULL
        return null;
    }

    private void connect(tNode p) {

        if (p == null) {
            return;
        }

        p.nextRight = null;

        while (p != null) {
            tNode q = p;

            while (q != null) {
                // Set the nextRight pointer for p's left child
                if (q.left != null) {
                    // If q has right child, then right child is nextRight of
                    // p and we also need to set nextRight of right child
                    if (q.right != null) {
                        q.left.nextRight = q.right;
                    } else {
                        q.left.nextRight = getNextRight(q);
                    }
                }

                if (q.right != null) {
                    q.right.nextRight = getNextRight(q);
                }

                // Set nextRight for other nodes in pre order fashion
                q = q.nextRight;
            }

            // start from the first node of next level
            if (p.left != null) {
                p = p.left;
            } else if (p.right != null) {
                p = p.right;
            } else {
                p = getNextRight(p);
            }
        }
    }

    public static void main(String args[]) {
        /* Constructed binary tree is
                10
               /  \
              8    2
             /      \
            3        90
         */
        ConnectNodes2 tree = new ConnectNodes2();
        tree.root = new tNode(10);
        tree.root.left = new tNode(8);
        tree.root.right = new tNode(2);
        tree.root.left.left = new tNode(3);
        tree.root.right.right = new tNode(90);

        // Populates nextRight pointer in all nodes
        tree.connect(tree.root);

        // Let us check the values of nextRight pointers
        int a = tree.root.nextRight != null
                ? tree.root.nextRight.data : -1;
        int b = tree.root.left.nextRight != null
                ? tree.root.left.nextRight.data : -1;
        int c = tree.root.right.nextRight != null
                ? tree.root.right.nextRight.data : -1;
        int d = tree.root.left.left.nextRight != null
                ? tree.root.left.left.nextRight.data : -1;
        int e = tree.root.right.right.nextRight != null
                ? tree.root.right.right.nextRight.data : -1;

        // Now lets print the values
        System.out.println("Following are populated nextRight pointers in "
                + " the tree(-1 is printed if there is no nextRight)");
        System.out.println("nextRight of " + tree.root.data + " is " + a);
        System.out.println("nextRight of " + tree.root.left.data
                + " is " + b);
        System.out.println("nextRight of " + tree.root.right.data
                + " is " + c);
        System.out.println("nextRight of " + tree.root.left.left.data
                + " is " + d);
        System.out.println("nextRight of " + tree.root.right.right.data
                + " is " + e);
    }
}
