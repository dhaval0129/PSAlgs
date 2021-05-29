/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.matrix;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/find-distinct-elements-common-rows-matrix/
 *
 * Find distinct elements common to all rows of a matrix
 *
 * Time Complexity: O(n ^ 2)
 *
 * Space Complexity: O(n)
 *
 */
public class FindDistinctElements {

    private static void findAndPrintCommonElements(int[][] matrix, int n) {
        int rows = matrix.length;
        int cols = matrix[1].length;

        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int value = matrix[i][j];

                if (hm.get(value) == null && i == 0) {
                    // for first row of matrix add all the values
                    hm.put(value, 0);
                } else if( hm.get(value) != null){
                    // for other rows check if value is there in hashmap
                    int count = hm.get(value);
                    hm.put(value, ++count);
                }
            }
        }

        for (int key: hm.keySet()) {
            if(hm.get(key) > 0){
                System.out.print(key +" ");
            }
        }
    }

    public static void main(String[] args) {
        int mat[][] = {
            {12, 1, 14, 3, 16},
            {14, 2, 1, 3, 35},
            {14, 1, 14, 3, 11},
            {14, 25, 3, 2, 1},
            {1, 18, 3, 21, 14}
        };

        int n = 5;
        findAndPrintCommonElements(mat, n);
    }
}
