/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.stack;

import java.util.Stack;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
 *
 * Check if a given array can represent Preorder Traversal of Binary Search Tree
 *
 * Time Complexity O(n)
 *
 */
public class ArrayBST {

    private boolean canRepresentBST(int pre[]) {
        Stack<Integer> s = new Stack<>();
        int n = pre.length;
        int root = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            // If we find a node who is on right side
            // and smaller than root, return false
            if (pre[i] < root) {
                return false;
            }

            // If pre[i] is in right subtree of stack top,
            // Keep removing items smaller than pre[i]
            // and make the last removed item as new
            // root.
            while (!s.isEmpty() && s.peek() < pre[i]) {
                root = s.pop();
            }

            // At this point either stack is empty or
            // pre[i] is smaller than root, push pre[i]
            s.push(pre[i]);
        }
        return true;
    }

    public static void main(String args[]) {
        ArrayBST bst = new ArrayBST();

        int[] pre1 = {40, 30, 35, 80, 100};
        if (bst.canRepresentBST(pre1)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        int[] pre2 = {40, 30, 35, 20, 80, 100};
        if (bst.canRepresentBST(pre2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

}
