/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.counting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/print-words-together-set-characters/
 *
 * Group words with same set of characters
 *
 */
public class GroupWords {

    private static final int MAX_CHAR = 26;

    // Generates a key from given string. The key
    // contains all unique characters of given string
    // in sorted order.
    private static String getKey(String str) {
        boolean[] visited = new boolean[MAX_CHAR];
        Arrays.fill(visited, false);

        // store all unique characters of current
        // word in key
        for (int j = 0; j < str.length(); j++) {
            visited[str.charAt(j) - 'a'] = true;
        }

        String key = "";
        for (int j = 0; j < MAX_CHAR; j++) {
            if (visited[j]) {
                key = key + (char) ('a' + j);
            }
        }
        return key;
    }

    // Print all words together with same character sets.
    private static void wordsWithSameCharSet(String words[], int n) {
        // Stores indexes of all words that have same
        // set of unique characters.
        //unordered_map <string, vector <int> > Hash;
        HashMap<String, ArrayList<Integer>> Hash = new HashMap<>();

        // Traverse all words
        for (int i = 0; i < n; i++) {
            String key = getKey(words[i]);

            // if the key is already in the map
            // then get its corresponding value
            // and update the list and put it in the map
            if (Hash.containsKey(key)) {
                ArrayList<Integer> get_al = Hash.get(key);
                get_al.add(i);
                Hash.put(key, get_al);
            } else {
                ArrayList<Integer> new_al = new ArrayList<>();
                new_al.add(i);
                Hash.put(key, new_al);
            }
        }

        // print all words that have the same unique character set
        for (Entry<String, ArrayList<Integer>> it : Hash.entrySet()) {
            ArrayList<Integer> get = it.getValue();
            for (Integer v : get) {
                System.out.print(words[v] + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        String words[] = {"may", "student", "students", "dog",
            "studentssess", "god", "cat", "act", "tab",
            "bat", "flow", "wolf", "lambs", "amy", "yam",
            "balms", "looped", "poodle"};
        int n = words.length;
        wordsWithSameCharSet(words, n);
    }

}
