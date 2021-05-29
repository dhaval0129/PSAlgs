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
 * http://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
 *
 * Find a pair with given sum in a Balanced BST
 * 
 * 1] Convert BST to Linked List
 * 2] Run the Binary search type of algorithm by adding values 
 *    of start and end
 * 
 * Time Complexity o(n)
 *
 */
public class FindSum {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;

    private void insert(int key) {
        root = insertRec(root, key);
    }

    private tNode insertRec(tNode node, int key) {
        if (node == null) {
            node = new tNode(key);
        }

        if (key < node.data) {
            node.left = insertRec(node.left, key);
        } else if (key > node.data) {
            node.right = insertRec(node.right, key);
        }

        return node;
    }

    private void inorder(tNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    private ArrayList<Integer> treeToList(tNode node, ArrayList<Integer> list) {
        // base case
        if (node == null) {
            return list;
        }
        treeToList(node.left, list);
        list.add(node.data);
        treeToList(node.right, list);

        return list;
    }

    private boolean isPairPresent(tNode node, int target) {
        // This list a1 is passed as an argument
        // in treeToList method 
        // which is later on filled by the values of BST
        ArrayList<Integer> a1 = new ArrayList<>();

        // a2 list contains all the values of BST 
        // returned by treeToList method
        ArrayList<Integer> a2 = treeToList(node, a1);

        int start = 0;
        int end = a2.size() - 1;

        while (start < end) {
            if (a2.get(start) + a2.get(end) == target) {
                System.out.println("Pair Found: " + a2.get(start)
                        + " + " + a2.get(end) + " " + "= " + target);
                return true;
            }

            if (a2.get(start) + a2.get(end) > target) {
                end--;
            }

            if (a2.get(start) + a2.get(end) < target) {
                start++;
            }
        }
        
        System.out.println("No such values are found!");
        return false;
    }

    public static void main(String[] args) {
        FindSum tree = new FindSum();
        /*
                15
               /   \
              10    20
             / \   /  \
            8  12 16  25    */
        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.insert(8);
        tree.insert(12);
        tree.insert(16);
        tree.insert(25);

        tree.isPairPresent(tree.root, 33);
    }
}
