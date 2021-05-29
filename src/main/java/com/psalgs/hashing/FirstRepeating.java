/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.hashing;

import java.util.HashMap;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/find-first-repeating-element-array-integers/
 *
 * Find the first repeating element in an array of integers
 *
 */
public class FirstRepeating {

    private static void printFirstRepeating(int[] arr) {
        int len = arr.length;
        HashMap<Integer, Integer> hM = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if(hM.get(arr[i]) != null) {
                int count = hM.get(arr[i]);
                // Incase question is last repeated element in string
                // It is good keep character/values in map
                hM.put(arr[i],++count); 
                System.out.println("First Repeated Element: "+arr[i]);
                break;
            } else {
                hM.put(arr[i],1);
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = {10, 5, 3, 4, 3, 5, 6};
        printFirstRepeating(arr);
    }
}
