/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.misc;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/check-leaves-level/
 *
 * Check if all leaves are at same level
 */
public class CheckLeafLevel {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
            right = left = null;
        }
    }

    tNode root;

    class Leaf {

        int leaflevel = 0;
    }

    Leaf mylevel = new Leaf();

    private boolean checkUtil(tNode node, int level, Leaf leafLevel) {
        // Base case
        if (node == null) {
            return true;
        }

        // If a leaf node is encountered
        if (node.left == null && node.right == null) {
            // When a leaf node is found first time
            if (leafLevel.leaflevel == 0) {
                // Set first found leaf's level
                leafLevel.leaflevel = level;
                return true;
            }

            // If this is not first leaf node, compare its level with
            // first leaf's level, This will return true or false
            return (level == leafLevel.leaflevel);
        }

        // If this node is not leaf, recursively check left and right 
        // subtrees
        return checkUtil(node.left, level + 1, leafLevel)
                && checkUtil(node.right, level + 1, leafLevel);
    }

    /* The main function to check if all leafs are at same level.
       It mainly uses checkUtil() */
    boolean check(tNode node) {
        int level = 0;
        return checkUtil(node, level, mylevel);
    }

    public static void main(String args[]) {
        CheckLeafLevel tree = new CheckLeafLevel();
        tree.root = new tNode(12);
        tree.root.left = new tNode(5);
        tree.root.right = new tNode(7);
        tree.root.left.left = new tNode(3);
        tree.root.right.right = new tNode(1);
//        tree.root.right.right.left = new tNode(0);

        if (tree.check(tree.root)) {
            System.out.println("Leaves are at same level");
        } else {
            System.out.println("Leaves are not at same level");
        }
    }
}
