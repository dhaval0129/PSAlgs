/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.misc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/
 *
 * Find the first non-repeating character from a stream of characters
 *
 */
public class FirstNonRepeatingCharStream {

    private final static int MAX_CHAR = 128;

    static void findFirstNonRepeating() {
        List<Character> list = new ArrayList<>();
        boolean[] repeated = new boolean[MAX_CHAR];

        // Let us consider following stream and see the process
        String stream = "geeksforgeeksandgeeksquizfor";
        for (int i = 0; i < stream.length(); i++) {
            char x = stream.charAt(i);
            System.out.println("Reading " + x + " from stream n");

            if (!repeated[x]) {
                // If the character is not in list, then add this at 
                // the end of DLL.
                if (!(list.contains(x))) {
                    list.add(x);
                } else {
                    // since charcter is repeated second time
                    // remove it from list and set array to true;
                    list.remove((Character) x);
                    repeated[x] = true; // Also mark it as repeated
                }
            }

            // Print the current first non-repeating character from stream
            if (!list.isEmpty()) {
                System.out.print("First non-repeating character so far is ");
                System.out.println(list.get(0));
            }
        }

    }

    public static void main(String args[]) {
        findFirstNonRepeating();
    }
}
