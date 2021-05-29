/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.misc;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
 *
 * Maximum width of a binary tree
 *
 * Maximum width of a tree is maximum of widths of all levels. width of tree at
 * each level is total nodes on that level
 *
 */
public class TreeWidth {

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

    private int getMaxWidth(tNode root) {
        int maxLevel = 0;
        Queue<tNode> bfsQ = new LinkedList<>();
        bfsQ.add(root);

        while (!bfsQ.isEmpty()) {
            int noOfNodes = bfsQ.size();

            if (noOfNodes > maxLevel) {
                maxLevel = noOfNodes;
            }

            while (noOfNodes > 0) {
                tNode node = bfsQ.poll();
                System.out.print(node.data + " ");
                
                if (node.left != null) {
                    bfsQ.add(node.left);
                }

                if (node.right != null) {
                    bfsQ.add(node.right);
                }
                noOfNodes--;
            }
        }
        System.out.println("\n");
        return maxLevel;
    }

    public static void main(String args[]) {
        TreeWidth tree = new TreeWidth();
        /*
        Constructed binary tree is:
              1
            /  \
           2    3
         /  \    \
        4   5     8 
                 /  \
                6    7
         */
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.right.right = new tNode(8);
        tree.root.right.right.left = new tNode(6);
        tree.root.right.right.right = new tNode(7);
        System.out.print("BFS Traversal: ");
        System.out.println("Maximum width is " + tree.getMaxWidth(tree.root) +"\n");
    }
}
