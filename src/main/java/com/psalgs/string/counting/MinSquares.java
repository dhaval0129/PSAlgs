/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.counting;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/minimum-sum-squares-characters-counts-given-string-removing-k-characters/
 *
 * Minimum sum of squares of character counts in a given string after removing k
 * characters
 *
 */
public class MinSquares {

    static final int MAX_CHAR = 26;

    // Defining a comparator class
    static class IntCompare implements Comparator<Integer> {

        @Override
        public int compare(Integer arg0, Integer arg1) {
            if (arg0 > arg1) {
                return -1;
            } else if (arg0 < arg1) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    // Main Function to calculate min sum of
    // squares of characters after k removals
    private static int minStringValue(String str, int k) {
        // find length of string
        int l = str.length();

        // if K is greater than length of string
        // so reduced string will become 0
        if (k >= l) {
            return 0;
        }

        // Else find Frequency of each character and
        // store in an array
        int[] frequency = new int[MAX_CHAR];
        for (int i = 0; i < l; i++) {
            frequency[str.charAt(i) - 'a']++;
        }

        // creating object for comparator
        Comparator<Integer> c = new IntCompare();

        // creating a priority queue with comparator
        // such that elements in the queue are in
        // descending order.
        PriorityQueue<Integer> q = new PriorityQueue<>(c);

        // Push each char frequency into a priority_queue
        for (int i = 0; i < MAX_CHAR; i++) {
            if (frequency[i] != 0) {
                q.add(frequency[i]);
            }
        }

        // Removal of K characters
        while (k != 0) {
            // Get top element in priority_queue,
            // remove it. Decrement by 1 and again
            // push into priority_queue
            int temp = q.poll();
            temp = temp - 1;
            q.add(temp);
            k--;
        }

        // After removal of K characters find sum
        // of squares of string Value
        int result = 0; // Initialize result
        while (!q.isEmpty()) {
            int temp = q.poll();
            result += temp * temp;
        }

        return result;
    }

    public static void main(String args[]) {
        String str = "abbccc";   // Input 1
        int k = 2;
        System.out.println(minStringValue(str, k));

        str = "aaab";           // Input 2
        k = 2;
        System.out.println(minStringValue(str, k));
    }
}
