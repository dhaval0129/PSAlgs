/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.statistics;

import java.util.Comparator;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/kth-smallest-element-in-a-row-wise-and-column-wise-sorted-2d-array-set-1/
 * 
 * https://github.com/hrishikesh-mishra/ds/blob/master/src/com/hrishikeshmishra/practices/binaryheap/KthSmallestElementInMatrix.java
 *
 * kth smallest element in a row-wise and column-wise sorted 2D array
 *
 */
public class kSmallest2DArray {

    private static class Node {

        int value;
        int row;
        int column;

        Node(int value, int row, int column) {
            this.value = value;
            this.row = row;
            this.column = column;
        }

        @Override
        public String toString() {
            return "(v=" + value + ",R=" + row + ",C=" + column + ")";
        }
    }

    private static class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o1.value, o2.value);
        }
    }

    public static int findKthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int totalNumberOfElementsInMatrix = n * n;

        if( k > totalNumberOfElementsInMatrix) {
            throw new RuntimeException("K out of range of provided matrix");
        }
//        
//        // Create binary head
//        ArrayBinaryHeap<Node> binaryHeap = new ArrayBinaryHeap<>( n * n, new NodeComparator());
//        
//        // Array to hold current head of each columns of matrix
//        int[] currentHeadPointers = new int[matrix.length];
          return 0;
    }

    public static void main(String args[]) {
        int[][] matrix = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {24, 29, 37, 48},
            {32, 33, 39, 50}
        };

        System.out.println("When k == 3 then : " + findKthSmallest(matrix, 3));
    }
}
