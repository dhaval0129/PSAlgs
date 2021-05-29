/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dc;

/**
 * Median of two sorted arrays
 *
 * There are 2 sorted arrays A and B of size n each. Write an algorithm to find
 * the median of the array obtained after merging the above 2 arrays(i.e. array
 * of length 2n). The complexity should be O(log(n))
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 * 
 * Time Complexity: O(n)
 *
 */
public class ArrayMedian {

    // function to calculate median
    static int getMedian(int ar1[], int ar2[], int n) {
        int i = 0;
        int j = 0;
        int count;
        int m1 = -1, m2 = -1;

        /* Since there are 2n elements, median will 
           be average of elements at index n-1 and 
           n in the array obtained after merging ar1 
           and ar2 */
        for (count = 0; count <= n; count++) {
            /* Below is to handle case where all 
              elements of ar1[] are smaller than 
              smallest(or first) element of ar2[] */
            if (i == n) {
                m1 = m2;
                m2 = ar2[0];
                break;
            } else if (j == n) {
                /* Below is to handle case where all 
               elements of ar2[] are smaller than 
               smallest(or first) element of ar1[] */
                m1 = m2;
                m2 = ar1[0];
                break;
            }

            if (ar1[i] < ar2[j]) {
                /* Store the prev median */
                m1 = m2;
                m2 = ar1[i];
                i++;
            } else {
                /* Store the prev median */
                m1 = m2;
                m2 = ar2[j];
                j++;
            }
        }
        return (m1 + m2) / 2;
    }

    public static void main(String args[]) {
        int ar1[] = {1, 12, 15, 26, 38};
        int ar2[] = {2, 13, 17, 30, 45};

        int m = ar1.length;
        int n = ar2.length;
        if (m == n) {
            System.out.println("Median is " + getMedian(ar1, ar2, m));
        } else {
            System.out.println("Arrays are of unequal size");
        }
    }

}
