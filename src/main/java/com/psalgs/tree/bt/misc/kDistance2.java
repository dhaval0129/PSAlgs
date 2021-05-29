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
 * http://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/
 *
 * Print all nodes that are at distance k from a leaf node
 *
 */
public class kDistance2 {

    static class tNode {

        int data;
        tNode right;
        tNode left;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;

    private void printKDistfromLeaf(tNode node, int k) {
        int path[] = new int[1000];
        boolean visited[] = new boolean[10];
        kDistFromLeafUtil(node, path, visited, 0, k);
    }

    /* This function prints all nodes that are distance k from a leaf node
     path[] --> Store ancestors of a node
     visited[] --> Stores true if a node is printed as output.  A node may
     be k distance away from many leaves, we want to print it once */
    private void kDistFromLeafUtil(tNode node, int path[], boolean visited[],
            int pathLen, int k) {
        // base case
        if (node == null) {
            return;
        }

        path[pathLen] = node.data;
        visited[pathLen] = false;
        pathLen++;

        if (node.left == null && node.right == null
                && pathLen - k - 1 >= 0 && visited[pathLen - k - 1] == false) {
            System.out.print(path[pathLen - k - 1] + " ");
            visited[pathLen - k - 1] = true;
            return;
        }

        /* If not leaf node, recur for left and right subtrees */
        kDistFromLeafUtil(node.left, path, visited, pathLen, k);
        kDistFromLeafUtil(node.right, path, visited, pathLen, k);
    }

    public static void main(String args[]) {
        kDistance2 tree = new kDistance2();
        /* Let us construct the tree shown in above diagram */
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.right.left = new tNode(6);
        tree.root.right.right = new tNode(7);
        tree.root.right.left.right = new tNode(8);

        System.out.println("Nodes at distance 2 are :");
        tree.printKDistfromLeaf(tree.root, 2);
        System.out.println();
    }
}
