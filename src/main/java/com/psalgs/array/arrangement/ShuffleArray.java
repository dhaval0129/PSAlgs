/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.arrangement;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/shuffle-a-given-array/
 *
 * Shuffle a given array
 *
 */
public class ShuffleArray {

    private static void randomize(int[] arr, int n) {
        Random r = new Random();

        for (int i = n - 1; i > 0; i--) {
            int index = r.nextInt(i);

            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        randomize(arr, n);
    }
}
