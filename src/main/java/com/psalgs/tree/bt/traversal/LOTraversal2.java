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
 * http://www.geeksforgeeks.org/perfect-binary-tree-specific-level-order-traversal/
 * 
 * Perfect Binary Tree Specific Level Order Traversal
 * 
 */
public class LOTraversal2 {

    static class tNode {

        int data;
        tNode right;
        tNode left;

        tNode(int d) {
            data = d;
            right = left = null;
        }
    }

    tNode root;

    private void levelOrderTraversal(tNode node) {
        Queue<tNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            tNode current = queue.poll();
            System.out.print(current.data +" ");
            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        LOTraversal2 tree = new LOTraversal2();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
  
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.right.left = new tNode(6);
        tree.root.right.right = new tNode(7);
  
        tree.root.left.left.left = new tNode(8);
        tree.root.left.left.right = new tNode(9);
        tree.root.left.right.left = new tNode(10);
        tree.root.left.right.right = new tNode(11);
        tree.root.right.left.left = new tNode(12);
        tree.root.right.left.right = new tNode(13);
        tree.root.right.right.left = new tNode(14);
        tree.root.right.right.right = new tNode(15);
  
        tree.root.left.left.left.left = new tNode(16);
        tree.root.left.left.left.right = new tNode(17);
        tree.root.left.left.right.left = new tNode(18);
        tree.root.left.left.right.right = new tNode(19);
        tree.root.left.right.left.left = new tNode(20);
        tree.root.left.right.left.right = new tNode(21);
        tree.root.left.right.right.left = new tNode(22);
        tree.root.left.right.right.right = new tNode(23);
        tree.root.right.left.left.left = new tNode(24);
        tree.root.right.left.left.right = new tNode(25);
        tree.root.right.left.right.left = new tNode(26);
        tree.root.right.left.right.right = new tNode(27);
        tree.root.right.right.left.left = new tNode(28);
        tree.root.right.right.left.right = new tNode(29);
        tree.root.right.right.right.left = new tNode(30);
        tree.root.right.right.right.right = new tNode(31);

        System.out.println("Level order traversal or BFS of binary tree is ");
        tree.levelOrderTraversal(tree.root);
    }

}
