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
 * Tl and T2 are two very large binary trees, with Tl much bigger than T2.
 * Create an algorithm to determine if T2 is a subtree of Tl.
 *
 * A tree T2 is a subtree of Tl if there exists a node n in Tl such that the
 * subtree of n is identical to T2. That is, if you cut off the tree at node n,
 * the two trees would be identical
 *
 *
 * https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
 *
 * https://prismoskills.appspot.com/lessons/Binary_Trees/Complete_subtree.jsp
 *
 * Time Complexity: O(m * n) where m and n are number of nodes in given two
 * trees.
 *
 */
public class CheckSubtree {

    static class Node {

        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root1, root2;

    private boolean areIdentical(Node root1, Node root2) {

        /* base cases */
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        /* Check if the data of both roots is same and data of left and right 
           subtrees are also same */
        return (root1.data == root2.data
                && areIdentical(root1.left, root2.left)
                && areIdentical(root1.right, root2.right));
    }

    private boolean isSubtree(Node T, Node S) {
        /* base cases */
        if (S == null) {
            return true;
        }

        if (T == null) {
            return false;
        }

        /* Check the tree with root as current node */
        if (areIdentical(T, S)) {
            return true;
        }

        /* If the tree with root as current node doesn't match then 
           try left and right subtrees one by one */
        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }

    public static void main(String args[]) {

        CheckSubtree tree = new CheckSubtree();

        // TREE 1 
        /* Construct the following tree 
              26 
             /  \ 
            10   3 
           /  \   \ 
          4    6   3 
           \ 
            30  
        */
        tree.root1 = new Node(26);
        tree.root1.right = new Node(3);
        tree.root1.right.right = new Node(3);
        tree.root1.left = new Node(10);
        tree.root1.left.left = new Node(4);
        tree.root1.left.left.right = new Node(30);
        tree.root1.left.right = new Node(6);

        // TREE 2 
        /* Construct the following tree 
          10 
         /  \ 
        4    6 
         \ 
         30  
        */
        tree.root2 = new Node(10);
        tree.root2.right = new Node(6);
        tree.root2.left = new Node(4);
        tree.root2.left.right = new Node(30);

        if (tree.isSubtree(tree.root1, tree.root2)) {
            System.out.println("Tree 2 is subtree of Tree 1 ");
        } else {
            System.out.println("Tree 2 is not a subtree of Tree 1");
        }
    }

}
