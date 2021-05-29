/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/interesting-method-generate-binary-numbers-1-n/
 *
 * An Interesting Method to Generate Binary Numbers from 1 to n
 *
 */
public class GenerateBinaryNo {

    private static void generatePrintBinary(int n) {
        // Create an empty queue of strings
        Queue<String> q = new LinkedList<>();

        // Enqueue the first binary number
        q.add("1");

        // This loops is like BFS of a tree with 1 as root
        // 0 as left child and 1 as right child and so on
        while (n-- > 0) {
            String s1 = q.remove();
            System.out.println(s1);

            // Append "0" to s1 and enqueue it
            q.add(s1 + "0");

            // Append "1" to s2 and enqueue it. Note that s2 contains
            // the previous front
            q.add(s1 + "1");
        }
    }

    public static void main(String args[]) {
        int n = 10;
        generatePrintBinary(n);
    }
}
