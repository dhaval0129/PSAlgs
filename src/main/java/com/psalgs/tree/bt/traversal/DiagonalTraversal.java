/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.traversal;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/
 *
 * Diagonal Traversal of Binary Tree.
 * 
 * Reference: http://www.ideserve.co.in/learn/diagonal-sum-of-a-binary-tree
 *
 */
public class DiagonalTraversal {

    static class tNode {

        int data;
        tNode left;
        tNode right;

        tNode(int d) {
            data = d;
            right = left = null;
        }
    }

    // Root of Binary Tree
    tNode root;

    private void computeDiagSum(HashMap<Integer, String> diagonalSum) {
        computeDiagSum(root, 0, diagonalSum);
    }

    // Time Complexity is O(n)
    // Space Complexity is O(n)
    private void computeDiagSum(tNode node, int currDiagonal,
            HashMap<Integer, String> diagonalSum) {
        
        if (node == null) {
            return;
        }

        computeDiagSum(node.left, currDiagonal + 1, diagonalSum);
        
        String nodeData = (diagonalSum.get(currDiagonal) == null)
                ? "" : diagonalSum.get(currDiagonal);
        
        nodeData = nodeData + node.data +" ";
        diagonalSum.put(currDiagonal, nodeData);

        computeDiagSum(node.right, currDiagonal, diagonalSum);
    }

    public static void main(String args[]) {
        DiagonalTraversal tree = new DiagonalTraversal();
        tree.root = new tNode(8);
        tree.root.left = new tNode(3);
        tree.root.right = new tNode(10);
        tree.root.left.left = new tNode(1);
        tree.root.left.right = new tNode(6);
        tree.root.left.right.left = new tNode(4);
        tree.root.left.right.right = new tNode(7);
        tree.root.right.right = new tNode(14);
        tree.root.right.right.left = new tNode(13);
        
        HashMap<Integer, String> diagSum = new HashMap<>();
        tree.computeDiagSum(diagSum);

        for (Map.Entry<Integer, String> entry : diagSum.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
