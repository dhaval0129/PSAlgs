/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.sort;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/
 *
 * http://fourprogramsdaily.blogspot.com/2014/08/sort-array-according-to-order-defined.html
 *
 * Sort an array according to the order defined by another array
 *
 */
public class SortRelativeToAnother {

    private static int[] sortArrayByAnotherOrder(int[] a, int[] b) {
        HashMap<Integer, Integer> hM = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            if (hM.containsKey(a[i])) {
                int count = hM.get(a[i]);
                hM.put(a[i], ++count);
            } else {
                hM.put(a[i], 1);
            }
        }

        int l = 0;

        for (int i = 0; i < b.length; i++) {
            if (hM.containsKey(b[i])) {
                int count = hM.get(b[i]);
                
                for(int j = 0; j < count; j++) {
                    a[l++] = b[i]; 
                }
                // remove elements which are done copying
                hM.remove(b[i]);
            } 
        }
        
        // put rest of element from hash map into the array
        for(int key: hM.keySet()) {
            a[l++] = key;
        }
        
        return a;
    }

    public static void main(String args[]) {
        int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int A2[] = {2, 1, 8, 3};
        int[] arr = sortArrayByAnotherOrder(A1, A2);
        
        System.out.println(Arrays.toString(arr));
    }
}
