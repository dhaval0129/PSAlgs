/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.misc;

/**
 *
 * @author djoshi
 */
public class PrintRNode {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    // class to access maximum level by reference
    class Max_level {

        int max_level;
    }

    tNode root;
    Max_level max = new Max_level();

    private void rightView() {
        int level = 1;
        rightViewUtil(root, level, max);
    }

    private void rightViewUtil(tNode node, int level, Max_level max) {
        if (node == null) {
            return;
        }

        if (max.max_level < level) {
            System.out.print(node.data + " ");
            max.max_level = level;
        }
        rightViewUtil(node.right, level + 1, max);
        rightViewUtil(node.left, level + 1, max);
    }

    public static void main(String args[]) {
        PrintRNode tree = new PrintRNode();
        tree.root = new tNode(1);
        tree.root.left = new tNode(2);
        tree.root.right = new tNode(3);
        tree.root.left.left = new tNode(4);
        tree.root.left.right = new tNode(5);
        tree.root.right.left = new tNode(6);
        tree.root.right.right = new tNode(7);
        tree.root.right.left.right = new tNode(8);

        tree.rightView();
    }
}
