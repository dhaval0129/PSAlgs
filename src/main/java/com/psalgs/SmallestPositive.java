/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author djoshi
 * 
 * https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
 */
public class SmallestPositive {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        Set<Integer> set = new HashSet<>();

        for (int a : A) {
            if (a > 0) {
                set.add(a);
            }
        }

        for (int i = 1; i <= N + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        
        return 1;
    }

    public static void main(String args[]) {
        int A[] = {1, 3, 6, 4, 1, 2};
        
        SmallestPositive sp = new SmallestPositive();
        System.out.println(sp.solution(A));
    }
}
