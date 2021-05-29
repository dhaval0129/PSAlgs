/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.traversal;

import java.util.HashMap;

/**
 *
 * @author djoshi
 */
public class VerticalOrder2 {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
            right = left = null;
        }
    }

    class Values {
        int max;
        int min;
    }

    Values values = new Values();
    tNode root;
    static HashMap<Integer, String> verticalMap = new HashMap<>();

    private void verticalOrder(tNode node, int key) {
        if (node == null) {
            return;
        }

        if (key > values.max) {
            values.max = key;
        }

        if (key < values.min) {
            values.min = key;
        }

        String value = (verticalMap.get(key) == null ? "" : verticalMap.get(key));
        String sum = value + node.data + " ";
        verticalMap.put(key, sum);

        verticalOrder(node.left, key + 1);
        verticalOrder(node.right, key - 1);
    }
    
    private void printVerticalOrder() {
        for (int i = values.min; i <= values.max; i++) {
            System.out.println(verticalMap.get(i));
        }
    }

    public static void main(String args[]) {
        VerticalOrder2 tree = new VerticalOrder2();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.right.left = new tNode(6);
        tree.root.right.right = new tNode(7);
        tree.root.right.left.right = new tNode(8);
        tree.root.right.right.right = new tNode(9);

        System.out.println("vertical order traversal is :");
        tree.verticalOrder(tree.root, 0);
        tree.printVerticalOrder();        
    }

}
