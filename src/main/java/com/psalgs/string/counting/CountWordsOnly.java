/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.counting;

/**
 *
 * @author djoshi
 * 
 * http://www.geeksforgeeks.org/count-words-in-a-given-string/
 * 
 * Count words in a given string
 * 
 */
public class CountWordsOnly {

    private static int countWords(String s) {

        int len = s.length();
        int wc = 1; // because first line is word
        boolean word = false;
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c == ' ' || c == '\n' || c == '\t') {
                word = true;
            } else if(word ){
                word = false;
                ++wc;
            }
        }
        return wc;
    }

    public static void main(String args[]) {
        String str = "One two     three\n four\tfive  ";
        System.out.println("No of words : " + countWords(str));
    }
}
