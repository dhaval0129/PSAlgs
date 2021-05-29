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
 * http://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
 *
 * Find the largest BST subtree in a given Binary Tree
 *
 * Time Complexity: O(n)
 */
public class LargestSubtree {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    static class Value {

        int max_size = 0;
        boolean isBST = false;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }

    tNode root;
    Value val = new Value();

    private int largestBST(tNode node) {
        largestBSTUtil(node, val, val, val, val);
        return val.max_size;
    }

    private int largestBSTUtil(tNode node, Value min_ref, Value max_ref,
            Value max_size_ref, Value is_bst_ref) {

        // base case
        if (node == null) {
            is_bst_ref.isBST = true; // An empty tree is BST
            return 0; // Size of the BST is 0
        }

        int min = Integer.MAX_VALUE;

        /* A flag variable for left subtree property
         i.e., max(root->left) < root->data */
        boolean left_flag = false;
        /* A flag variable for right subtree property
         i.e., min(root->right) > root->data */
        boolean right_flag = false;

        int ls, rs; // To store sizes of left and right subtrees

        /* Following tasks are done by recursive call for left subtree
         a) Get the maximum value in left subtree (Stored in *max_ref)
         b) Check whether Left Subtree is BST or not (Stored in *is_bst_ref)
         c) Get the size of maximum size BST in left subtree (updates *max_size) */
        max_ref.max = Integer.MIN_VALUE;
        ls = largestBSTUtil(node.left, min_ref, max_ref, max_size_ref, is_bst_ref);
        if (is_bst_ref.isBST == true && node.data > max_ref.max) {
            left_flag = true;
        }

        /* Before updating *min_ref, store the min value in left subtree. So that we
         have the correct minimum value for this subtree */
        min = min_ref.min;

        /* The following recursive call does similar (similar to left subtree) 
         task for right subtree */
        min_ref.min = Integer.MAX_VALUE;
        rs = largestBSTUtil(node.right, min_ref, max_ref, max_size_ref, is_bst_ref);
        if (is_bst_ref.isBST == true && node.data < min_ref.min) {
            right_flag = true;
        }

        // Update min and max values for the parent recursive calls
        if (min < min_ref.min) {
            min_ref.min = min;
        }

        if (node.data < min_ref.min) { // For leaf nodes
            min_ref.min = node.data;
        }

        if (node.data > max_ref.max) {
            max_ref.max = node.data;
        }

        /* If both left and right subtrees are BST. And left and right
         subtree properties hold for this node, then this tree is BST.
         So return the size of this tree */
        if (left_flag && right_flag) {
            if (ls + rs + 1 > max_size_ref.max_size) {
                max_size_ref.max_size = ls + rs + 1;
            }
            return ls + rs + 1;
        } else {
            //Since this subtree is not BST, set is_bst flag for parent calls
            is_bst_ref.isBST = false;
            return 0;
        }
    }

    public static void main(String args[]) {
        /* Let us construct the following Tree
                50
               /  \
             10    60
            /  \   /  \
           5   20 55    70
          /    / \
         45   65  80
         */
        LargestSubtree tree = new LargestSubtree();
        tree.root = new tNode(50);
        tree.root.left = new tNode(10);
        tree.root.right = new tNode(60);
        tree.root.left.left = new tNode(5);
        tree.root.left.right = new tNode(20);
        tree.root.right.left = new tNode(55);
        tree.root.right.left.left = new tNode(45);
        tree.root.right.right = new tNode(70);
        tree.root.right.right.left = new tNode(65);
        tree.root.right.right.right = new tNode(80);
        /* The complete tree is not BST as 45 is in right subtree of 50.
         The following subtree is the largest BST
             60
            /  \
          55    70
          /     /  \
        45     65   80
         */
        System.out.println("Size of largest BST is " + tree.largestBST(tree.root));
    }

}
