/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.statistics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/
 *
 * https://stackoverflow.com/questions/24027482/find-k-most-occurring-elements-in-an-integer-array
 *
 * Find k numbers with most occurrences in the given array.
 *
 * ( Most Frequent Number)
 *
 * Time Complexity: O(k*log(d)), where d is the count of distinct elements in the array. 
 * 
 * Auxiliary Space: O(d), where d is the count of distinct elements in the array.
 *
 */
public class kNumberOccurrence {

    private static class Pair {

        int value;
        int count;

        Pair(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    private static void kMostFrequentNumber(int[] arr, int k) {
        Map<Integer, Pair> map = new HashMap<>();

        for (int a : arr) {
            int count = 1;
            Pair pair = new Pair(a, count);

            if (map.containsKey(a)) {
                pair = map.get(a);
                pair.count++;
            } else {
                map.put(a, pair);
            }
        }

        // Create List of types Pair class and put map.values() which will
        // return values of types Pair included with value and count;
        List<Pair> pairs = new ArrayList<>(map.values());
        // Now sort map accordance to Pair class using Comparator class
        // This will arrange list in asecending order of count
        pairs.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                // This will arrange in accordance to highest count in descending order
                int result = Integer.compare(p2.count, p1.count);
                // count for both pair is same so we compare value
                if (result == 0) {
                    // since count of pair is same, we now compare values for pairs
                    // and return the higer value
                    return Integer.compare(p2.value, p1.value);
                }
                return result;
            }
        });

        // Print first k pairs;
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            Pair pair = pairs.get(i);
            result[i] = pair.value;
        }

        System.out.println(k + " integers with most occurences: " + Arrays.toString(result));
    }

    public static void main(String args[]) {
        int arr[] = {3, 1, 4, 4, 5, 2, 6, 1, 1};
        int n = arr.length;
        int k = 2;

        kMostFrequentNumber(arr, k);
    }
}
