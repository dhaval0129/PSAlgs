/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.misc;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/bottom-view-binary-tree/
 *
 * Bottom View of a Binary Tree
 *
 */
public class BottomView {

    static class tNode {

        int data, hd;
        tNode right, left;

        tNode(int d) {
            data = d;
            hd = Integer.MAX_VALUE;
            right = left = null;
        }
    }

    tNode root;

    private void bottomView() {
        if (root == null) {
            return;
        }

        // Initialize a variable 'hd' with 0 for the root element.
        int hd = 0;
        // TreeMap which stores key value pair sorted on key value
        Map<Integer, Integer> map = new TreeMap<>();
        // Queue to store tree nodes in level order traversal
        Queue<tNode> queue = new LinkedList<>();
        // Assign initialized horizontal distance value to root
        // node and add it to the queue.
        root.hd = hd;
        queue.add(root);

        while (!queue.isEmpty()) {
            tNode temp = queue.poll();
                        
            hd = temp.hd;
            map.put(hd, temp.data);

            if (temp.left != null) {
                temp.left.hd = hd - 1;
                queue.add(temp.left);
            }

            if (temp.right != null) {
                temp.right.hd = hd + 1;
                queue.add(temp.right);
            }
        }
        
        for(int key: map.keySet()) {
            System.out.print(map.get(key) + " ");
        }
    }

    public static void main(String args[]) {
        BottomView tree = new BottomView();
        tree.root = new tNode(20);
        tree.root.left = new tNode(8);
        tree.root.right = new tNode(22);
        tree.root.left.left = new tNode(5);
        tree.root.left.right = new tNode(3);
        tree.root.right.left = new tNode(4);
        tree.root.right.right = new tNode(25);
        tree.root.left.right.left = new tNode(10);
        tree.root.left.right.right = new tNode(14);
        System.out.println("Bottom view of the given binary tree:");
        tree.bottomView();
    }
}
