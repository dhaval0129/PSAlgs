/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author djoshi
 */
public class Itr_HeightBT {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;

    private int treeHeight(tNode node) {
        if (node == null) {
            return 0;
        }

        int height = 0;
        Queue<tNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {

            int noOfNodes = queue.size();

            height++;

            while (noOfNodes > 0) {
                tNode curr = queue.poll();

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
                noOfNodes--;
            }
        }

        return height;
    }

    public static void main(String args[]) {
        Itr_HeightBT tree = new Itr_HeightBT();
        // Let us create a binary tree shown in above diagram
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        System.out.println("Height of tree is " + tree.treeHeight(tree.root));
    }

}
