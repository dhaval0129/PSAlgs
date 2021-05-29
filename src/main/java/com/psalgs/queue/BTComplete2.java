/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.queue;

import com.psalgs.queue.BTComplete2.tNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/?p=23449
 *
 * Check if binary tree is complete binary tree
 * 
 * Time Complexity O(n)
 *
 */
public class BTComplete2 {

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

    private static boolean isCompleteBT(tNode node) {
        if (node == null) {
            return true;
        }

        Queue<tNode> queue = new LinkedList<>();
        queue.add(node);
        boolean flag = false;

        while (!queue.isEmpty()) {
            tNode curr = queue.poll();

            if (curr.left != null) {
                if (flag) {
                    return false;
                }
                queue.add(curr.left);
            } else {
                flag = true;
            }

            if (curr.right != null) {
                if (flag) {
                    return false;
                }
                queue.add(curr.right);
            } else {
                flag = true;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        BTComplete2 tree = new BTComplete2();
        /* Let us construct the following Binary Tree which
          is not a complete Binary Tree
                1
              /   \
             2     3
            / \     \
           4   5     6
         */
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
//        tree.root.right.left = new tNode(6);
        tree.root.right.right= new tNode(6);

        if (isCompleteBT(tree.root)) {
            System.out.println("Complete Binary Tree");
        } else {
            System.out.println("NOT Complete Binary Tree");
        }
    }

}
