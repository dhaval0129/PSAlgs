/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.stack;

import java.util.Stack;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
 *
 * Evaluation of Postfix Expression
 *
 */
public class EvalPostfix {

    private static int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();;

                switch (c) {
                    case '*':
                        stack.push(operand2 * operand1);
                        break;
                    case '/':
                        stack.push(operand2 / operand1);
                        break;
                    case '^':
                        stack.push(operand2 ^ operand1);
                        break;
                    case '+':
                        stack.push(operand2 + operand1);
                        break;
                    case '-':
                        stack.push(operand2 - operand1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String exp = "231*+9-";
        System.out.println(evaluatePostfix(exp));
    }
}
