/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author djoshi
 */

/*
Given an array of integers, return an list of integers which contains
[1st integer, Sum of next 2 integers (2nd, 3rd), Sum of next 3 integers (4th, 5th, 6th)…] and so on
7th , 8th , 9th , `10th , 
Input 
[1,6,8,5,9,4,7,2]
Output 
[1,14,18,9]
 */
public class ArraySum {
  
    public static void main(String args[]) {
        System.out.println(summation(new int[]{1,6,8,5,9,4,7,2}));
    }
    
    private static List<Integer> summation(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int len = arr.length;
        int count = 0;
        
        for(int i = 0; i < len; i++) {
            int sum = 0;
            int j = 0;
            while(j <= i && count < len) {
                sum += arr[count++];
                j++;
            }
            res.add(sum);
            if(count > len - 1) {
                break;
            }
        }
        
        return res;
    }
}
