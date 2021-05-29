/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.greedy;

/**
 *
 * @author djoshi
 */
public class ActivitySelection {

    public static void printMaxActivities(int s[], int f[], int n) {
        int i, j;
        System.out.print("Following activities are selected : \n");
        // The first activity always gets selected
        i = 0;
        System.out.print(i + " ");

        for (j = 1; j < n; j++) {
            // If this activity has start time greater than or
            // equal to the finish time of previously selected
            // activity, then select it 
            if(s[j] >= f[i]) {
                System.out.print(j + " ");
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int s[] = {1, 3, 0, 5, 8, 5};
        int f[] = {2, 4, 6, 7, 9, 9};
        int n = s.length;

        printMaxActivities(s, f, n);
    }

}
