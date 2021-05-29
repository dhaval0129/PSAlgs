/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.construct;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/construct-a-special-tree-from-given-preorder-traversal/
 *
 * Construct a special tree from given pre-order traversal
 * 
 *       int pre[] = new int[]{10, 30, 20, 5, 15};
 *       char preLN[] = new char[]{'N', 'N', 'L', 'L', 'L'};
 */
public class BuildTree3 {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    static class Index {
        int index = 0;
    }

    tNode root;
    Index myindex = new Index();

    private tNode constructTree(int[] pre, char[] preLN,
            int n, tNode root) {
        return constructTreeUtil(pre, preLN, myindex, n, root);
    }

    private tNode constructTreeUtil(int[] pre, char[] preLN,
            Index index_ptr, int n, tNode temp) {

        int index = index_ptr.index;
        // Base Case: All nodes are constructed
        if (index == n) {
            return null;
        }

        temp = new tNode(pre[index]);
        (index_ptr.index)++;

        if (preLN[index] == 'N') {
            temp.left = constructTreeUtil(pre, preLN, index_ptr, n, temp.left);
            temp.right = constructTreeUtil(pre, preLN, index_ptr, n, temp.right);
        }

        return temp;
    }

    private void printInorder(tNode node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String args[]) {
        BuildTree3 tree = new BuildTree3();
        int pre[] = new int[]{10, 30, 20, 5, 15};
        char preLN[] = new char[]{'N', 'N', 'L', 'L', 'L'};
        int n = pre.length;

        //construct the above tree
        tNode node = tree.constructTree(pre, preLN, n, tree.root);
        System.out.println("Following is Inorder Traversal of the"
                + "Constructed Binary Tree: ");
        tree.printInorder(node);
        System.out.println();
    }
}
