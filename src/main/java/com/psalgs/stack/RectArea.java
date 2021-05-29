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
 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 *
 * Largest Rectangular Area in a Histogram
 *
 * Time Complexity O(n)
 */
public class RectArea {

    private static int getMaxArea(int hist[], int n) {
        // Create an empty stack. The stack holds indexes of hist[] array
        // The bars stored in stack are always in increasing order of their
        // heights.
        Stack<Integer> s = new Stack<>();

        int max_area = 0; // Initialize max area
        int tp;  // To store top of stack
        int area_with_top = 0; // To store area with top bar as the smallest bar

        // Run through all bars of given histogram
        int i = 0;
        while (i < n) {
            if (s.isEmpty() || hist[s.peek()] <= hist[i]) {
                s.push(i++);
            } else {
                tp = s.pop();
                area_with_top = hist[tp] * (s.isEmpty() ? i : (i-1) - s.peek());
            }

            // update max area, if needed
            if (max_area < area_with_top) {
                max_area = area_with_top;
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (s.empty() == false) {
            tp = s.peek();
            s.pop();
            area_with_top = hist[tp] * (s.empty() ? i : ((i - 1 ) - s.peek()));
            if (max_area < area_with_top) {
                max_area = area_with_top;
            }
        }

        return max_area;
    }

    public static void main(String args[]) {
        int hist[] = {6, 2, 5, 4, 5, 1, 6};
        System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
    }
}
