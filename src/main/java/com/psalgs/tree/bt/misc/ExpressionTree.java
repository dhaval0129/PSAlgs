/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.misc;

import java.util.Stack;

/**
 * 
 * @author djoshi
 * 
 * http://www.geeksforgeeks.org/expression-tree/
 * 
 * 
 */
public class ExpressionTree {

    static class tNode {

        char data;
        tNode left;
        tNode right;

        tNode(char d) {
            data = d;
            left = right = null;
        }
    }

    private boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*'
                || c == '/' || c == '^') {
            return true;
        }
        return false;
    }

    private tNode constructTree(char postfix[]) {
        Stack<tNode> st = new Stack();
        tNode t, t1, t2;

        for (int i = 0; i < postfix.length; i++) {
            // If operand, simply push into stack
            if (!isOperator(postfix[i])) {
                t = new tNode(postfix[i]);
                st.push(t);
            } else {
                t = new tNode(postfix[i]);

                t1 = st.pop();
                t2 = st.pop();

                //  make them children
                t.right = t1;
                t.left = t2;

                // Add this subexpression to stack
                st.push(t);
            }
        }

        // only element will be root of expression
        // tree
        t = st.pop();
        return t;
    }

    // Utility function to do inorder traversal
    private void inorder(tNode t) {
        if (t != null) {
            inorder(t.left);
            System.out.print(t.data + " ");
            inorder(t.right);
        }
    }

    public static void main(String args[]) {

        ExpressionTree et = new ExpressionTree();
        String postfix = "ab+ef*g*-";
        char[] charArray = postfix.toCharArray();
        tNode root = et.constructTree(charArray);
        System.out.println("infix expression is");
        et.inorder(root);
        System.out.println();

    }

}
