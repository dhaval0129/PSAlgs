/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.convert;

/**
 *
 * @author djoshi
 * 
 * http://www.geeksforgeeks.org/convert-ternary-expression-binary-tree/
 * 
 * Convert Ternary Expression to a Binary Tree
 * 
 * Time Complexity : O(n) [ here n is length of String ]
 * 
 */
public class TreeTE {

    static class tNode {

        char data;
        tNode left;
        tNode right;

        tNode(char d) {
            data = d;
            left = right = null;
        }
    }

    tNode root;

    private String treeTE(tNode node, String s) {

        if (node == null) {
            return s;
        }

        String a = treeTE(node.left, node.data + "?");
        String b = treeTE(node.right, ":" + node.data);

        return a + b;
    }

    public void printTree(tNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }

    private tNode convertExpression(char[] exp, int i) {
        
        //base case
        if(i >= exp.length) {
            return null;
        }
        
        tNode node = new tNode(exp[i]);
        i++;
        
        if(i < exp.length && exp[i] == '?') {
            node.left = convertExpression(exp, ++i);
        }
        
        if(i < exp.length && exp[i] == ':') {
            node.right = convertExpression(exp, ++i);
        }
        
        return node;
    }

    public static void main(String args[]) {
        String exp = "a?b?c:d:e";
        TreeTE tree = new TreeTE();
        char[] expression = exp.toCharArray();
        tNode root = tree.convertExpression(expression, 0);
        tree.printTree(root);
    }

}
