/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.arrangement;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/segregate-even-and-odd-numbers/
 *
 * Segregate Even and Odd numbers
 *
 */
public class SegregateValues2 {

    private static int[] segregateEvenOdd(int[] arr) {
        int n = arr.length;
        int x = n - 1;
        for (int i = 0; i <= n / 2;) {
            int temp = arr[i];
            // if no. is odd number
            if (temp % 2 != 0) {
                // move the no. at end
                int temp2 = arr[x];
                arr[x] = arr[i];
                arr[i] = temp2;
                --x;
            } else {
                i++;
            }
        }

        return arr;
    }

    public static void main(String args[]) {
        int arr[] = {12, 34, 45, 9, 4, 90, 3};

        arr = segregateEvenOdd(arr);

        System.out.print("Array after segregation ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
