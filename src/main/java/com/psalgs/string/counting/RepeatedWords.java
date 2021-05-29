/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.counting;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/count-words-appear-exactly-two-times-array-words/
 *
 * Count words that appear exactly two times in an array of words
 *
 */
public class RepeatedWords {

    private static int countWords(String str[], int n) {
        Map<String, Integer> map = new HashMap<>();
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(str[i])) {
                int count = map.get(str[i]);
                map.put(str[i], ++count);
            } else {
                map.put(str[i], 1);
            }
        }

        for (Map.Entry<String, Integer> it : map.entrySet()) {
            if (it.getValue() == 2) {
                res++;
            }
        }

        return res;
    }

    public static void main(String args[]) {
        String s[] = { "hate", "love", "peace", "love",
            "peace", "hate", "love", "peace",
            "love", "peace"};
        int n = s.length;
        System.out.println(countWords(s, n));
    }

}
