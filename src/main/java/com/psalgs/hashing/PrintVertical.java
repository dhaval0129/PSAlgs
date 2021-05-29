/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.hashing;

import java.util.HashMap;

/**
 *
 * @author djoshi
 * 
 * http://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
 * 
 * Print a Binary Tree in Vertical Order
 * 
 */
public class PrintVertical {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;
    int min;

    private void printVertical(tNode node, HashMap<Integer, String> map, int id) {
        // base case
        if (node == null) {
            return;
        }

        if (id < min) {
            min = id;
        }

        if (map.get(id) != null) {
            String s = map.get(id);
            s += " " + node.data;
            map.put(id, s);
        } else {
            map.put(id, node.data + "");
        }

        printVertical(node.left, map, id - 1);
        printVertical(node.right, map, id + 1);
    }

    private void print(HashMap<Integer, String> map) {
        for (int i = min; i < map.size() + min; i++) {
            System.out.println(map.get(i));
        }
    }

    public static void main(String args[]) {
        PrintVertical tree = new PrintVertical();
        HashMap<Integer, String> map = new HashMap<>();

        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.right.left = new tNode(6);
        tree.root.right.right = new tNode(7);
        tree.root.right.left.right = new tNode(8);
        tree.root.right.right.right = new tNode(9);

        tree.printVertical(tree.root, map, 0);
        tree.print(map);
    }
}
