/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.anagram;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
 *
 * Given a sequence of words, print all anagrams together
 *
 */
public class PrintAnagrams {

    static class Word {

        String str;
        int index;

        Word(String str, int index) {
            this.index = index;
            this.str = str;
        }
    }

    static class DupArray {

        Word[] array;
        int size;

        public DupArray(String str[], int size) {
            this.size = size;
            array = new Word[size];

            for (int i = 0; i < size; i++) {
                array[i] = new Word(str[i], i);
            }
        }
    }

    static class compStr implements Comparator<Word> {

        @Override
        public int compare(Word a, Word b) {
            return a.str.compareTo(b.str);
        }
    }

    private static void printAnagramsTogether(String wordArr[], int size) {
        // Step 1: Create a copy of all words present
        // in given wordArr. The copy will also have 
        // original indexes of words
        DupArray dupArray = new DupArray(wordArr, size);

        // Step 2: Iterate through all words in 
        // dupArray and sort individual words.
        for (int i = 0; i < size; i++) {
            char[] char_arr = dupArray.array[i].str.toCharArray();
            Arrays.sort(char_arr);
            dupArray.array[i].str = new String(char_arr);
        }

        // Step 3: Now sort the array of words in dupArray
        Arrays.sort(dupArray.array, new compStr());

        // Step 4: Now all words in dupArray are together,
        // but these words are changed. Use the index 
        // member of word struct to get the corresponding
        // original word
        for (int i = 0; i < size; i++) {
            System.out.print(wordArr[dupArray.array[i].index] + " ");
        }
    }

    public static void main(String args[]) {
        String wordArr[] = {"cat", "dog", "tac", "god", "act"};
        int size = wordArr.length;
        printAnagramsTogether(wordArr, size);
        System.out.println();
    }
}
