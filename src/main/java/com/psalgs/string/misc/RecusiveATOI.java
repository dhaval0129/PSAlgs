/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.misc;

/**
 *
 * @author djoshi
 * 
 * http://www.geeksforgeeks.org/recursive-implementation-of-atoi/
 * 
 * Recursive Implementation of atoi()
 */
public class RecusiveATOI {
    
    private static int atoiRecursive(String str, int n) {
        if(n == 1){
            return str.charAt(n - 1) - '0';
        }
        
        return (10 * atoiRecursive(str, n - 1) + str.charAt(n - 1) - '0');
    }
    
    public static void main(String args[]) {
        String str = "112";
        int n = str.length();
        System.out.println(atoiRecursive(str, n));
        
    }
}
