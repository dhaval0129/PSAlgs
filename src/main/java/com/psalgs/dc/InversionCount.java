/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dc;

/**
 *
 * @author djoshi
 *
 * Reference: http://www.geeksforgeeks.org/counting-inversions/
 *
 */
public class InversionCount {

    static int arr[] = {1, 20, 6, 4, 5};
    
    // O(n ^ 2 ) similar to bubble sort 
    static int getInvCount(int n) {
        int inv_count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    inv_count++;
                }
            }
        }

        return inv_count;
    }
    
    
    

    public static void main(String args[]) {
        System.out.println("Number of inversions are " + getInvCount(arr.length));
    }

}
