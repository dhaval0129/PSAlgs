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
 * http://www.geeksforgeeks.org/function-to-find-number-of-customers-who-could-not-get-a-computer/
 *
 * Function to find Number of customers who could not get a computer
 *
 */
public class CustomerSimulation {

    private static final int MAX_CHAR = 26;

    private static int runCustomerSimulation(int n, char[] seq) {
        char[] seen = new char[MAX_CHAR];

        //initialize result which is number of customers who could not get any computer
        int res = 0;
        int occupied = 0;

        for (int i = 0; i < seq.length; i++) {
            // find index of current character in seen[0...25]
            int index = seq[i] - 'A';

            // If first occurrence of 'seq[i]'
            if (seen[index] == 0) {
                // set the current character as seen
                seen[index] = 1;
                // If number of occupied computers is less than
                // n, then assign a computer to new customer
                if (occupied < n) {
                    occupied++;
                    // Set the current character as occupying a computer
                    seen[index] = 2;
                } else {
                    res++;
                }
            } else {
                // Decrement occupied only if this customer was using a computer
                if (seen[index] == 2) {
                    occupied--;
                }
                seen[index] = 0;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        System.out.println(runCustomerSimulation(2, "ABBAJJKZKZ".toCharArray()));
        System.out.println(runCustomerSimulation(3, "GACCBDDBAGEE".toCharArray()));
        System.out.println(runCustomerSimulation(3, "GACCBGDDBAEE".toCharArray()));
        System.out.println(runCustomerSimulation(1, "ABCBCA".toCharArray()));
        System.out.println(runCustomerSimulation(1, "ABCBCADEED".toCharArray()));
    }
}
