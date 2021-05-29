/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.trie;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author djoshi
 *
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/suffixprefix/Trie.java
 *
 * https://www.youtube.com/watch?v=zIjfhVPRZCg
 *
 * https://www.youtube.com/watch?v=AXjmTQ8LEoI
 *
 * Trie is a tree data structure, can be used
 *
 * 1] Store dictionary 2] Prefix based search
 *
 * Insert/delete/search into trie data structure
 *
 * Reference: https://en.wikipedia.org/wiki/Trie
 *
 * Time Complexity O(L x N ), where l is average length of word and n is total
 * no. of words
 */
public class Trie {

    private class TrieNode {

        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Iterative implementation of trie
     *
     * @param word
     */
    private void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);

            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        //mark the current nodes endOfWord as true
        current.endOfWord = true;
    }

    /**
     * Recursive implementation of insert into trie
     *
     * @param word
     */
    public void insertRecursive(String word) {
        insertRecursive(root, word, 0);
    }

    private void insertRecursive(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //if end of word is reached then mark endOfWord as true on current node
            current.endOfWord = true;
            return;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);

        //if node does not exists in map then create one and put it into map
        if (node == null) {
            node = new TrieNode();
            current.children.put(ch, node);
        }
        insertRecursive(node, word, index + 1);
    }

    /**
     *
     * Iterative implementation of search into trie
     *
     * @param word
     * @return
     */
    private boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            //if node does not exist for given char then return false
            if (node == null) {
                return false;
            }
            current = node;
        }
        //return true of current's endOfWord is true else return false
        return current.endOfWord;
    }

    /**
     * Recursive implementation of search into trie.
     */
    private boolean searchRecursive(String word) {
        return searchRecursive(root, word, 0);
    }

    private boolean searchRecursive(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //return true of current's endOfWord is true else return false.
            return current.endOfWord;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        //if node does not exist for given char then return false
        if (node == null) {
            return false;
        }
        return searchRecursive(node, word, index + 1);
    }

    /**
     * Delete word from trie.
     *
     * @param word 
     */
    public void delete(String word) {
        delete(root, word, 0);
    }

    /**
     * Returns true if parent should delete the mapping
     */
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //when end of word is reached only delete if currrent.endOfWord is true.
            if (!current.endOfWord) {
                return false;
            }
            current.endOfWord = false;
            //if current has no other mapping then return true;
            return current.children.isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        //if true is returned then delete the mapping of character and trie node reference from map
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            // return true if no mappings are left in the map
            return current.children.isEmpty();
        }
        return false;
    }

    public static void main(String args[]) {
        String word1 = "abcd";
        String word2 = "defg";
        String word3 = "aeqp";

        Trie trie = new Trie();
        trie.insert(word1);
        trie.insert(word2);
        trie.insert(word3);

        System.out.println("Search defg: " + trie.search("defg"));
        System.out.println("Search ef: " + trie.search("ef"));

        trie.delete("ae");

    }
}
