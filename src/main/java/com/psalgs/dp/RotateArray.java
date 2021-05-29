/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp;

/**
 *
 * @author djoshi
 */
public class RotateArray {
    
    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        
        for(int i=0; i<k; i++) {
            int temp = a[0];
                for(int j=0; j<n; j++) {
                    if(j < n-1) 
                        a[j] = a[j+1];
                    else 
                        a[j] = temp; 
                }
        }
        
        return a;
    }
    
    public static int[] arrayLeftRotationSolved(int[] a,int n, int k) {
        int temp;
        int next = 0;
        
        for(int i=0; i<k; i++){
            next = a[a.length-1];
            a[a.length-1] = a[0];
            
            for(int j=0; j<a.length-1; j++){
                temp = a[a.length-j-2]; 
                a[a.length-j-2] = next;
                next = temp;               
            }
        }
        return a;
    }
    
    
    public static void main(String args[]) {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        int n = a.length;
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, 2);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
        System.out.println();
    }
}
