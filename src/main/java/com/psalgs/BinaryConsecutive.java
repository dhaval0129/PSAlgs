/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs;

/**
 *
 * @author djoshi
 */
public class BinaryConsecutive {
    
    static int maxCount = 1;
    static int curCount = 1;
    static boolean firstTime;
    static int prev;
    
    private static void binary(int n) {
        while(n != 0) {
            int x = n%2;
            //System.out.println(prev+" "+x);
            if(firstTime && prev == x) {
                curCount++;
                if(curCount > maxCount)
                    maxCount = curCount;
            } else {
                curCount = 1;
            }
            firstTime = true;
            prev = x;
            n = n/2; 
        }        
    }

    public static void main(String[] args) {
        int n = 439;

        binary(n);       
        System.out.println(maxCount);
    }
    
}
