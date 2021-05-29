/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.traversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/level-order-traversal-line-line-set-2-using-two-queues/
 *
 * Level order traversal line by line 
 * Note: Since two queue solution is expensive, We will do in one queue
 *
 */
public class LOTraversal3 {

    static class tNode {

        int data;
        tNode right;
        tNode left;

        tNode(int d) {
            data = d;
            right = left = null;
        }
    }

    static tNode root;

    private void levelOrderTraversal(tNode node) {
        Queue<tNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
  
            int noOfNodes = queue.size();

            while (noOfNodes-- > 0) {
                tNode root = queue.poll();
                System.out.print(root.data + " ");
                
                if (root.left != null) {
                    queue.add(root.left);
                }

                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            System.out.println();
        }

    }

    public static void main(String args[]) {
        LOTraversal3 tree = new LOTraversal3();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.right.left = new tNode(6);
        tree.levelOrderTraversal(root);
    }
}
