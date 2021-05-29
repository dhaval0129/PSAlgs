/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp.medium;

import java.util.Arrays;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-21-box-stacking-problem/
 *
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/BoxStacking.java
 *
 * http://algorithms.tutorialhorizon.com/dynamic-programming-box-stacking-problem/
 *
 * https://people.cs.clemson.edu/~bcdean/dp_practice/
 *
 * https://www.youtube.com/watch?v=9mod_xRB-O0
 *
 * https://www.youtube.com/watch?v=KgWy0fY0dRM
 *
 * Box Stacking Problem ( Variation of LIS problem )
 *
 * Time Complexity O(n ^ 2)
 */
public class BoxStacking {

    static class Box implements Comparable<Box> {

        int height;
        int width;
        int depth;

        public Box(int height, int width, int depth) {
            this.height = height;
            this.width = width;
            this.depth = depth;
        }

        @Override
        public int compareTo(Box b) {
            int area = b.depth * b.width;
            int currArea = this.depth * this.width;

            return area - currArea;
        }
    }

    private static int solve_DP(int[][] x) {
        int n = x.length;
        Box[] boxes = new Box[n * 3];

        for (int i = 0; i < n; i++) {
            int h = x[i][0];
            int w = x[i][1];
            int d = x[i][2];

            boxes[i * 3] = new Box(h, w, d); // normal dimension
            boxes[i * 3 + 1] = new Box(w, h, d); // first dimension
            boxes[i * 3 + 2] = new Box(d, h, w); // second dimension
        }

        // O(n*log n)
        Arrays.sort(boxes);

        //Display all the possible boxes.
        System.out.println("All possible combination of boxes after rotation");
        for (int i = 0; i < boxes.length; i++) {
            System.out.println(boxes[i].height + " " + boxes[i].width + " " + boxes[i].depth);
        }

        // This is implementation of LIS algorithm
        int[] optHeight = new int[boxes.length + 1];
        //if there are no boxes then optimal height = 0
        optHeight[0] = 0;

        for (int i = 1; i < optHeight.length; i++) {
            int maxHeightIndex = 0;

            for (int j = i - 1; j >= 0; j--) {
                //first check if box can be placed or not
                if (boxes[j].width > boxes[i - 1].width
                        && boxes[j].depth > boxes[i - 1].depth) {

                    if (optHeight[maxHeightIndex] < optHeight[j + 1]) {
                        maxHeightIndex = j + 1;
                    }
                }
            }
            // Add Max height + current box height
            optHeight[i] = optHeight[maxHeightIndex] + boxes[i - 1].height;
        }
//        System.out.println(Arrays.toString(optHeight));
        return optHeight[optHeight.length - 1];
    }

    public static void main(String args[]) {
        int[][] x = {
            {4, 7, 9},
            {5, 8, 9},
            {11, 20, 40},
            {1, 2, 3}
        };

        BoxStacking boxStacking = new BoxStacking();
        System.out.println("Max height which can be obtained :" + boxStacking.solve_DP(x));
    }

}
