/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.binary;

import java.util.ArrayList;

/**
 *
 * @author djoshi
 * 
 * http://www.geeksforgeeks.org/length-longest-sub-string-can-make-removed/
 * 
 * Length of Longest sub-string that can be removed
 * 
 */
public class RemoveSubstring {

    // User defined class Pair
    static class Pair {

        char first;
        int second;

        Pair(char first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private static int longestNull(String str) {
        ArrayList<Pair> arr = new ArrayList<>();

        // store {'@',-1} in arr , here this value
        // will work as base index
        arr.add(new Pair('@', -1));
        // Initialize result
        int maxlen = 0;

        for (int i = 0; i < str.length(); ++i) {
            // make pair of char and index , then 
            // store them into arr
            arr.add(new Pair(str.charAt(i), i));

            // now if last three elements of arr[]
            // are making sub-string "100" or not
            while (arr.size() >= 3
                    && arr.get(arr.size() - 3).first == '1'
                    && arr.get(arr.size() - 2).first == '0'
                    && arr.get(arr.size() - 1).first == '0') {
                // if above condition is true then 
                // delete sub-string "100" from arr[]
                arr.remove(arr.size() - 3);
                arr.remove(arr.size() - 2);
                arr.remove(arr.size() - 1);
            }
            
            // index of current last element in arr[]
            int tmp = arr.get(arr.size() - 1).second;
            
            maxlen = Math.max(maxlen, i - tmp);
        }
        return maxlen;
    }

    public static void main(String args[]) {
        System.out.println(longestNull("1011100000100"));
    }

}
