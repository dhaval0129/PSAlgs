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
 * http://www.geeksforgeeks.org/find-distance-two-given-nodes/
 *
 * Find distance between two given keys of a Binary Tree
 * 
 * // not working solution
 *
 */
public class DistanceNodes {

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

    private int findLevel(tNode root, int k, int level) {
        //base case
        if (root == null) {
            return -1;
        }

        if (root.data == k) {
            return level;
        }

        int l = findLevel(root.left, k, level + 1);
        return (l != -1) ? l : findLevel(root.left, k, level + 1);
    }

    private int findDistance(tNode root, int n1, int n2) {
        // Initialize d1 (distance of n1 from root), d2 (distance of n2 
        // from root) and dist(distance between n1 and n2)
        int d1 = -1;
        int d2 = -1;
        int dist = 0;
        tNode lca = findDistUtil(root, n1, n2, d1, d2, dist, 1);

        // If both n1 and n2 were present in Binary Tree, return dist
        if (d1 != -1 && d2 != -1) {
            return dist;
        }

        // If n1 is ancestor of n2, consider n1 as root and find level 
        // of n2 in subtree rooted with n1
        if (d1 != -1) {
            dist = findLevel(lca, n2, 0);
            return dist;
        }

        // If n2 is ancestor of n1, consider n2 as root and find level 
        // of n1 in subtree rooted with n2
        if (d2 != -1) {
            dist = findLevel(lca, n1, 0);
            return dist;
        }

        return -1;
    }

    private tNode findDistUtil(tNode root, int n1, int n2, int d1, int d2, int dist, int lvl) {
        // base case
        if (root == null) {
            return null;
        }

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (root.data == n1) {
            d1 = lvl;
            return root;
        }

        if (root.data == n2) {
            d2 = lvl;
            return root;
        }

        tNode left_lca = findDistUtil(root.left, n1, n2, d1, d2, dist, lvl + 1);
        tNode right_lca = findDistUtil(root.right, n1, n2, d1, d2, dist, lvl + 1);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null) {
            dist = d1 + d2 - 2 * lvl;
            return root;
        }

        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }

    public static void main(String args[]) {
        DistanceNodes tree = new DistanceNodes();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.right.left = new tNode(6);
        tree.root.right.right = new tNode(7);

        System.out.println("LCA(4, 5): " + tree.findDistance(tree.root, 4, 5));
        System.out.println("LCA(4, 6): " + tree.findDistance(tree.root, 4, 6));
        System.out.println("LCA(3, 4): " + tree.findDistance(tree.root, 3, 4));
        System.out.println("LCA(2, 4): " + tree.findDistance(tree.root, 2, 4));
    }
}
