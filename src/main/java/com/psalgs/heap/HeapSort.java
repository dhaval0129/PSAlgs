/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.heap;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/heap-sort/
 *
 * Heap Sort
 *
 * Min Heap: Parent is smaller than child node Max Heap: Parent is larger than
 * child node
 *
 * Time Complexity: Time complexity of heapify is O(Log n). Time complexity of
 * createAndBuildHeap() is O(n) and overall time complexity of Heap Sort is
 * O(nLogn).
 *
 */
public class HeapSort {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    // log(n)
    private void heapify(int arr[], int n, int i) {
        int largest = i; //Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than root
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected nodes in sub-tree
            // here the updated largest value will the one which is swapped
            heapify(arr, n, largest);
        }
    }

    //O(n log n)
    private void sort(int arr[]) {
        int n = arr.length;

        // Build heap (Max heap) rearrange array 
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap 
            heapify(arr, i, 0);
        }
    }

    private static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {4, 10, 3, 5, 1};

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is:");
        printArray(arr);
    }

}
