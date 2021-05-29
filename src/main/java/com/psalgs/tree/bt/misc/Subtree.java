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
 * http://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
 *
 * Check if a binary tree is subtree of another binary tree
 *
 * Time Complexity: O(m x n) 
 */
public class Subtree {

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

    private boolean areIdentical(tNode root1, tNode root2) {
        /* base cases */
        if (root1 == null && root2 == null) {
            return true;
        }

        /* Check if the data of both roots is same and data of left and right
           subtrees are also same */
        return (root1.data == root2.data
                && areIdentical(root1.left, root2.left)
                && areIdentical(root1.right, root2.right));
    }

    private boolean isSubtree(tNode T, tNode S) {
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
        return isSubtree(T.left,S) || isSubtree(T.right,S);
    }

    public static void main(String args[]) {
        Subtree tree = new Subtree();

        // TREE 1
        /* Construct the following tree
              26
             /  \
            10   3
           /  \    \
          4    6    3
           \
            30  */
        tree.root1 = new tNode(26);
        tree.root1.right = new tNode(3);
        tree.root1.right.right = new tNode(3);
        tree.root1.left = new tNode(10);
        tree.root1.left.left = new tNode(4);
        tree.root1.left.left.right = new tNode(30);
        tree.root1.left.right = new tNode(6);

        // TREE 2
        /* Construct the following sub-tree
           10
         /   \
        4     6
         \
         30  */
        tree.root2 = new tNode(10);
        tree.root2.right = new tNode(6);
        tree.root2.left = new tNode(4);
        tree.root2.left.right = new tNode(30);

        if (tree.isSubtree(tree.root1, tree.root2)) {
            System.out.println("Tree 2 is subtree of Tree 1 ");
        } else {
            System.out.println("Tree 2 is not a subtree of Tree 1");
        }
    }
}
