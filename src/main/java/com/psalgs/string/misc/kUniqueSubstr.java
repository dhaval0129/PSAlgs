/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.misc;

import java.util.HashMap;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
 *
 * https://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/
 *
 * Time Complexity: O(n)
 *
 */
public class kUniqueSubstr {

    public static int kUniqueSubstr(String s, int k) {
        if (k == 0 || s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() < k) {
            return s.length();
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int maxLen = k;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            if (map.size() > k) {
                maxLen = Math.max(maxLen, i - left);

                while (map.size() > k) {
                    char fc = s.charAt(left);
                    if (map.get(fc) == 1) {
                        map.remove(fc);
                    } else {
                        map.put(fc, map.get(fc) - 1);
                    }
                    left++;
                }
            }
        }
        maxLen = Math.max(maxLen, s.length() - left);
        System.out.println("Max substring is: " + s.substring(left));
        return maxLen;
    }

    public static void main(String args[]) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println("Max substring size: " + kUniqueSubstr(s, k));
    }
}
