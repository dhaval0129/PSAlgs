/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.rotations;

import java.util.Arrays;

/**
 *
 * @author djoshi
 */
public class RotateArray3 {

    private static int arr[] = {1, 2, 3, 4, 5};

    private static void rotate() {
        int n = arr.length;
        int x = arr[n - 1];
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = x; 
    }

    public static void main(String[] args) {
        System.out.println("Given Array is");
        System.out.println(Arrays.toString(arr));

        rotate();

        System.out.println("Rotated Array is");
        System.out.println(Arrays.toString(arr));
    }
}
