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
 * http://www.geeksforgeeks.org/tree-isomorphism-problem/
 * 
 * Tree Isomorphism Problem
 * 
 * Time complexity is O(m + n) where m and n are number of nodes in given trees
 */
public class TreeIsomorphic {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root1, root2;

    private boolean isIsomorphic(tNode n1, tNode n2) {
        // Both roots are NULL, trees isomorphic by definition
        if (n1 == null && n2 == null) {
            return true;
        }

        // Exactly one of the n1 and n2 is NULL, trees not isomorphic
        if (n1 == null || n2 == null) {
            return false;
        }

        if (n1.data != n2.data) {
            return false;
        }

        // There are two possible cases for n1 and n2 to be isomorphic
        // Case 1: The subtrees rooted at these nodes have NOT been 
        // "Flipped" means unaltered (both trees are name ). 
        // Then Both of these subtrees have to be isomorphic.
        // Case 2: The subtrees rooted at these nodes have been "Flipped" 
        // ( Are mirror of each other )
        return (isIsomorphic(n1.left, n2.left) && isIsomorphic(n1.right, n2.right))
                || (isIsomorphic(n1.left, n2.right) && isIsomorphic(n1.right, n2.left));
    }

    public static void main(String args[]) {
        TreeIsomorphic tree = new TreeIsomorphic();

        // Let us create trees shown in above diagram
        tree.root1 = new tNode(1);
        tree.root1.left = new tNode(2);
        tree.root1.right = new tNode(3);
        tree.root1.left.left = new tNode(4);
        tree.root1.left.right = new tNode(5);
        tree.root1.right.left = new tNode(6);
        tree.root1.left.right.left = new tNode(7);
        tree.root1.left.right.right = new tNode(8);

//        tree.root2 = new tNode(1);
//        tree.root2.left = new tNode(2);
//        tree.root2.right = new tNode(3);
//        tree.root2.left.left = new tNode(4);
//        tree.root2.left.right = new tNode(5);
//        tree.root2.right.left = new tNode(6);
//        tree.root2.left.right.left = new tNode(7);
//        tree.root2.left.right.right = new tNode(8);

        tree.root2 = new tNode(1);
        tree.root2.left = new tNode(3);
        tree.root2.right = new tNode(2);
        tree.root2.right.left = new tNode(4);
        tree.root2.right.right = new tNode(5);
        tree.root2.left.right = new tNode(6);
        tree.root2.right.right.left = new tNode(8);
        tree.root2.right.right.right = new tNode(7);
        System.out.print("Is Tree Isomorphic: ");
        if (tree.isIsomorphic(tree.root1, tree.root2) == true) {
            System.out.print("Yes\n");
        } else {
            System.out.print("No\n");
        }
    }
}
