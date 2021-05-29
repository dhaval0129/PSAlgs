/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.anagram;

import java.util.LinkedList;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together-set-2/
 *
 * Given a sequence of words, print all anagrams together
 *
 */
public class PrintAnagrams2 {

    static final int NO_OF_CHARS = 26;

    static class TrieNode {

        boolean isEnd; // indicates end of word
        TrieNode[] child = new TrieNode[NO_OF_CHARS];
        LinkedList<Integer> head;

        public TrieNode() {
            isEnd = false;
            head = new LinkedList<>();
            for (int i = 0; i < NO_OF_CHARS; i++) {
                child[i] = null;
            }
        }
    }


    public static void main(String args[]) {
        String wordArr[] = {"cat", "dog", "tac", "god", "act", "gdo"};
        int size = wordArr.length;
//        printAnagramsTogether(wordArr, size);
    }
}
