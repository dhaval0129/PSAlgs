/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.hashing;

import java.util.HashSet;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/check-two-given-sets-disjoint/
 *
 * How to check if two given sets are disjoint ?
 *
 * If there are no common elements in two sets it is called disjoint set
 * 
 * Time Complexity is O(m + n) hash set operations like add() and contains() work in O(1) time
 * 
 */
public class DisjointSets {

    private static boolean areDisjoint(int[] s1, int[] s2) {
        // Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();

        // Traverse the first set and store its elements in hash
        for (int i = 0; i < s1.length; i++) {
            set.add(s1[i]);
        }

        // Traverse the second set and check if any element of it is alreadu in hash or not.
        for (int i = 0; i < s2.length; i++) {
            if (set.contains(s2[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        int set1[] = {10, 5, 3, 4, 6};
        int set2[] = {8, 7, 9, 3};

        if (areDisjoint(set1, set2)) {
            System.out.println("Set are disjoint sets");
        } else {
            System.out.println("Not disjoint sets");
        }
    }

}
