/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.arrangement;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/replace-every-element-with-the-greatest-on-right-side/
 *
 * Replace every element with the greatest element on right side 
 * 
 * (Hint: Start from right)
 *
 * Time Complexity O(n)
 *
 */
public class NextGreatestElement {

    private static void nextGreatest(int[] arr) {
        int n = arr.length;
        int max_right = arr[n - 1];
        arr[n - 1] = -1;

        for (int i = n - 2; i >= 0; i--) {
            int temp = arr[i];
            
            arr[i] = max_right;
            
            if( max_right < temp) {
                max_right = temp;
            }
        }
        
    }

    private static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {16, 17, 4, 3, 5, 2};
        nextGreatest(arr);
        System.out.println("The modified array:");
        printArray(arr);
    }
}
