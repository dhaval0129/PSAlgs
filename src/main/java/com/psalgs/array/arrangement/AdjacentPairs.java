/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.arrangement;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/minimum-number-of-swaps-required-for-arranging-pairs-adjacent-to-each-other/
 *
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/recursion/SetPairTogether.java
 *
 * Minimum number of swaps required for arranging pairs adjacent to each other.
 *
 * Explanation:
 * 
 * Given an array arrange whole given array in such a way that arrangement matches to
 * the given pairs. If this arrangement is in opposite direction then also it
 * can be considered valid for example: if 1,3 can be seen as 3,1
 *
 * Time Complexity O( 2 ^ n)
 *
 */
public class AdjacentPairs {

    private static int findMinimumSwaps(int[] input, Map<Integer, Integer> pair) {
        // declare index map
        Map<Integer, Integer> index = new HashMap<>();
        
        // put all array values in map as <array value,index> to <k,v>
        for (int i = 0; i < input.length; i++) {
            index.put(input[i], i);
        }
        return findMinimumSwapsUtil(input, pair, index, 0);
    }

    private static int findMinimumSwapsUtil(int[] input, Map<Integer, Integer> pair,
            Map<Integer, Integer> index, int current) {

        // base case
        if (current == input.length) {
            return 0;
        }

        int v1 = input[current];
        int v2 = input[current + 1];
        int pv2 = pair.get(v1);

        // If pair is available in given pair of set
        if (pv2 == v2) {
            return findMinimumSwapsUtil(input, pair, index, current + 2);
        } else { // do the swap until pair can made
            // get array index by value
            int idx1 = index.get(v1); 
            int idx2 = index.get(v2);

            // get array index by pair
            int idx3 = index.get(pair.get(v1));
            int idx4 = index.get(pair.get(v2));

            // swap 2nd and 3rd index and find if there is pair
            swap(index, input, idx2, idx3);
            int val1 = findMinimumSwapsUtil(input, pair, index, current + 2);
            swap(index, input, idx2, idx3); // reset back to original position

            // swap 1st and 4th index and find if there is pair
            swap(index, input, idx1, idx4);
            int val2 = findMinimumSwapsUtil(input, pair, index, current + 2);
            swap(index, input, idx1, idx4); // reset back to original position

            return 1 + Math.min(val1, val2);
        }
    }

    private static void swap(Map<Integer, Integer> index, int[] input, int i, int j) {
//        index.compute(input[i], (k, v) -> j);
//        index.compute(input[j], (k, v) -> i);
        int t = input[i];
        input[i] = input[j];
        input[j] = t;
    }

    public static void main(String args[]) {
        int input[] = {3, 5, 6, 4, 1, 2};
        Map<Integer, Integer> pair = new HashMap<>();
        pair.put(1, 3);
        pair.put(3, 1);
        pair.put(2, 6);
        pair.put(6, 2);
        pair.put(4, 5);
        pair.put(5, 4);
        System.out.println(findMinimumSwaps(input, pair));
    }
}
