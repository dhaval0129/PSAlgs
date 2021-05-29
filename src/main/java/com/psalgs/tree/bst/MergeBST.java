/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bst;

import java.util.ArrayList;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/merge-two-balanced-binary-search-trees/
 *
 * Merge Two Balanced Binary Search Trees
 * 
 * 1] convert first tree to list 1 using inorder traversal
 * 2] convert second tree to list 2 using inorder traversal
 * 3] merge both list 1 and list 2 based on the comparison of value
 * 4] create new BST of merged list 3
 *
 */
public class MergeBST {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;

    private void inorder() {
        inorderUtil(this.root);
    }

    private void inorderUtil(tNode node) {
        if (node == null) {
            return;
        }

        inorderUtil(node.left);
        System.out.print(node.data + " ");
        inorderUtil(node.right);
    }

    private ArrayList<Integer> storeInorderUtil(tNode node, ArrayList<Integer> list) {
        if (node == null) {
            return list;
        }

        storeInorderUtil(node.left, list);
        list.add(node.data);
        storeInorderUtil(node.right, list);
        return list;
    }

    private ArrayList<Integer> storeInorder(tNode node) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = storeInorderUtil(node, list1);
        return list2;
    }

    private ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {

        // list3 will contain the merge of list1 and list2
        ArrayList<Integer> list3 = new ArrayList<>();
        int i = 0, j = 0;
        int m = list1.size();
        int n = list2.size();

        while (i < m && j < n) {
            // Smaller one goes into list3
            if (list1.get(i) < list2.get(j)) {
                list3.add(list1.get(i));
                i++;
            } else {
                list3.add(list2.get(j));
                j++;
            }
        }

        while (i < m) {
            list3.add(list1.get(i));
            i++;
        }

        while (j < n) {
            list3.add(list2.get(j));
            j++;
        }

        return list3;
    }

    private tNode ALtoBST(ArrayList<Integer> list, int start, int end) {
        // base case
        if (start > end) {
            return null;
        }

        // Get the middle element and make it root
        int mid = (start + end) / 2;
        tNode node = new tNode(list.get(mid));

        node.left = ALtoBST(list, start, mid - 1);

        node.right = ALtoBST(list, mid + 1, end);

        return node;
    }

    private tNode mergeTrees(tNode node1, tNode node2) {
        ArrayList<Integer> list1 = storeInorder(node1);
        ArrayList<Integer> list2 = storeInorder(node2);

        // Merges both list1 and list2 into list3
        ArrayList<Integer> list3 = merge(list1, list2);

        // convert merged list to bst
        tNode node = ALtoBST(list3, 0, list3.size() - 1);
        return node;
    }

    public static void main(String args[]) {
        /* Creating following tree as First balanced BST
                100
                / \
               50 300
              / \
             20 70
         */
        MergeBST tree1 = new MergeBST();
        tree1.root = new tNode(100);
        tree1.root.left = new tNode(50);
        tree1.root.right = new tNode(300);
        tree1.root.left.left = new tNode(20);
        tree1.root.left.right = new tNode(70);

        /* Creating following tree as second balanced BST
                80
               / \
              40 120
         */
        MergeBST tree2 = new MergeBST();
        tree2.root = new tNode(80);
        tree2.root.left = new tNode(40);
        tree2.root.right = new tNode(120);

        MergeBST tree = new MergeBST();
        tree.root = tree.mergeTrees(tree1.root, tree2.root);
        tree.inorder();
        System.out.println();
    }

}
