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
 * http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 *
 * Time complexity of this solution is O(h) where h is height of tree Also, the
 * solution requires O(h) extra space in function call stack for recursive
 * function calls. We can avoid extra space using iterative solution.
 *
 */
public class LcaBST {

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

    private tNode lca(tNode node, int n1, int n2) {
        // base case
        if (node == null) {
            return null;
        }

        if (node.data > n1 && node.data > n2) {
            lca(node.left, n1, n2);
        }

        if (node.data < n1 && node.data < n2) {
            lca(node.right, n1, n2);
        }

        return node;
    }
    
    private tNode lca_Itr(tNode node, int n1, int n2) {

        while (node != null) {
            // n1 and n2 are smaller the current node 
            // then LcaBST is left subtree
            if(node.data > n1 && node.data > n2) {
                node = node.left;
            } else if(node.data < n1 && node.data < n2) {
                // if n1 and n2 are greater then current node then
                // LcaBST is in right subtree
                node = node.right;
            } else {
                break;
            }
        }
        
        return node;
    }

    public static void main(String args[]) {
        LcaBST tree = new LcaBST();
        tree.root = new tNode(20);
        tree.root.left = new tNode(8);
        tree.root.right = new tNode(22);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(12);
        tree.root.left.right.left = new tNode(10);
        tree.root.left.right.right = new tNode(14);

        int n1 = 10, n2 = 14;
        tNode t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 14;
        n2 = 8;
        t = tree.lca_Itr(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 10;
        n2 = 22;
        t = tree.lca_Itr(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
    }

}
