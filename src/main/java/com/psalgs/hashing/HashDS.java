/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/
 *
 * Design a data structure that supports insert, delete, search and getRandom in
 * constant time
 *
 */
public class HashDS {

    ArrayList<Integer> arr;
    HashMap<Integer, Integer> hash;

    public HashDS() {
        arr = new ArrayList<>();
        hash = new HashMap<>();
    }

    private void add(int x) {
        //If element is already present, then nothing to do
        if (hash.get(x) != null) {
            return;
        }
        // Else put element at the end of arr[]
        int s = arr.size();
        arr.add(x);
        hash.put(x, s);
    }

    private int search(int x) {
        return hash.get(x);
    }

    private void remove(int x) {
        // Check if element is present
        Integer index = hash.get(x);
        if (index == null) {
            return;
        }

        // If present remove element from hash
        hash.remove(x);

        // swap element with last element so that remove from 
        // arr[] can be done with O(1) time
        int size = arr.size();
        Integer last = arr.get(size - 1);
        // swap last value with index value
        Collections.swap(arr, index, size - 1);

        // Remove last element (This is O(1))
        arr.remove(size - 1);

        // Update hash table for new index of last element
        hash.put(last, index);
    }

    private int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(arr.size());

        // Return element at randomly picked index
        return arr.get(index);
    }

    public static void main(String args[]) {
        HashDS ds = new HashDS();
        ds.add(10);
        ds.add(20);
        ds.add(30);
        ds.add(40);
        System.out.println(ds.search(30));
        ds.remove(20);
        ds.add(50);
        System.out.println(ds.search(50));
        System.out.println(ds.getRandom());
    }
}
