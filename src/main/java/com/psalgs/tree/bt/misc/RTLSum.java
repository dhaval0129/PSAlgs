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
 * http://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
 *
 * Root to leaf path sum equal to a given number
 */
public class RTLSum {

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

    private boolean checkRTLSum(tNode node, int sum) {

        if (node == null) {
            return (sum == 0);
        } else {
            boolean ans = false;
            int subSum = sum - node.data;
            if (subSum == 0 && node.left == null && node.right == null) {
                return true;
            }

            if (node.left != null) {
                ans = ans || checkRTLSum(node.left, subSum);
            }

            if (node.right != null) {
                ans = ans || checkRTLSum(node.right, subSum);
            }
            return ans;
        }
    }
    
    public static void main(String args[]) {
        int sum = 23;

        RTLSum tree = new RTLSum();
        tree.root = new tNode(10);
        tree.root.left = new tNode(8);
        tree.root.right = new tNode(2);
        tree.root.left.left = new tNode(3);
        tree.root.left.right = new tNode(5);
        tree.root.right.left = new tNode(2);

        boolean result = tree.checkRTLSum(tree.root, sum);

        if (result) {
            System.out.println("Sum exists in the tree");
        } else {
            System.out.println("Sum does not exists in the tree");
        }

    }
}
