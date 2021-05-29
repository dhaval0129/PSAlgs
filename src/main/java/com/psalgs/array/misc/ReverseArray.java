/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.misc;

/**
 * 1] Reverse Array without using temp variable 
 *      a = a + b
 *      b = a - b
 *      a = a - b
 *      
 *      // Using Bit-wise Operator
 *      
 *      x = x ^ y;
 *      y = y ^ x;
 *      x = x ^ y; 
 * 
 * 2] Reverse Array without using - (minus) sign 
 *      use stack or recursion
 *      print backwards and copy the array
 *      a - b = a + ~b + 1
 *      Note: ( ~ NOT Operator )
 * 
 * @author djoshi
 */
public class ReverseArray {
    
    /**
     * Reverse Array without using temp variable  
     * 
     * @param arr
     * @return 
     */
    public static int[] reverseArray(int[] arr) {
        
        int n = arr.length;
        
        for(int i=0; i<(n/2); i++) {
            int a = arr[i];
            int b = arr[n-1-i];
            
            a = a + b;
            b = a - b;
            a = a - b;
            
            arr[i] = a;
            arr[n-1-i] = b;
        }
        
        return arr;
    }
    
    public static void main(String args[]) {
        int arr[] = {1,3,4,7,9,12,14,17,19,21,24,26};
        int result[] = reverseArray(arr);
        
        for(int i=0; i<result.length; i++)
            System.out.print(result[i] + " ");
        
        System.out.println("");  
    }
  
}
