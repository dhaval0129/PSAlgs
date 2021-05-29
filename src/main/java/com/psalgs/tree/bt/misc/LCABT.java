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
 * http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 *
 * Lowest Common Ancestor in a Binary Tree
 *
 * Time Complexity O(n)
 *
 */
public class LCABT {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;

    private tNode findLCA(int n1, int n2) {
        return findLCAUtil(root, n1, n2);
    }

    // This function returns pointer to LCA of two given
    // values n1 and n2. This function assumes that n1 and
    // n2 are present in Binary Tree
    tNode findLCAUtil(tNode node, int n1, int n2) {
        // Base case
        if (node == null) {
            return null;
        }

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (node.data == n1 || node.data == n2) {
            return node;
        }

        // Look for keys in left and right subtrees
        tNode left_lca = findLCAUtil(node.left, n1, n2);
        tNode right_lca = findLCAUtil(node.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null) {
            return node;
        }

        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }

    public static void main(String args[]) {
        LCABT tree = new LCABT();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.right.left = new tNode(6);
        tree.root.right.right = new tNode(7);

        System.out.println("LCA(4, 5): " + tree.findLCA(4, 5).data);
        System.out.println("LCA(4, 6): " + tree.findLCA(4, 6).data);
        System.out.println("LCA(3, 4): " + tree.findLCA(3, 4).data);
        System.out.println("LCA(2, 4): " + tree.findLCA(2, 4).data);
    }
}
