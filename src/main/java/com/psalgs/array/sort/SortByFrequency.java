/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/sort-elements-by-frequency/
 *
 * http://www.geeksforgeeks.org/sort-elements-by-frequency-set-2/
 *
 * https://self-learning-java-tutorial.blogspot.com/2014/08/sort-elements-by-frequency.html
 *
 * Sort elements by frequency (No. of times it is repeated )
 *
 * Hint: It can also be by implementing BST with freq value in node class and
 * then do the inorder traversal
 */
public class SortByFrequency {

    private static void sortByFrequency(int[] arr, int n) {
        Map<Integer, Integer> hM = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (hM.containsKey(arr[i])) {
                int count = hM.get(arr[i]);
                ++count;
                hM.put(arr[i], count);
            } else {
                hM.put(arr[i], 1);
            }
        }

        // Refer BiggestNumber.java example com.psalgs.array.arrangement similar comparision
        List list = new LinkedList(hM.entrySet());
        Collections.sort(list, new Comparator() {

            @Override
            public int compare(Object obj1, Object obj2) {
                return ((Comparable) ((Map.Entry) (obj1)).getValue())
                        .compareTo(((Map.Entry) (obj2)).getValue());
            }
        });

        int count = 0;
        /* Place the elements in to the array based on frequency */
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();

            int key = (int) entry.getKey();
            int val = (int) entry.getValue();

            for (int i = 0; i < val; i++) {
                arr[count] = key;
                count++;
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12};
        int n = arr.length;
        sortByFrequency(arr, n);

        System.out.println("\nAfter Sorting");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
