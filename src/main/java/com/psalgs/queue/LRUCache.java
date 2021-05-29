/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.queue;

import java.util.HashMap;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/lru-cache-implementation/
 *
 * https://www.programcreek.com/2013/03/leetcode-lru-cache-java/
 *
 * Implement LRU ( Least Recently Used ) Cache
 *
 * The LRU cache is a hash table of keys and doubly linked nodes. The hash table
 * makes the time of get() to be O(1). The list of double linked nodes make the
 * nodes adding/removal in operations O(1).
 *
 */
public class LRUCache {

    static class Node {

        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = null;
    Node end = null;

    private LRUCache(int capacity) {
        this.capacity = capacity;
    }

    // add the key to cache
    private void set(int key, int value) {
        // If key already exists then update node value
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            // update the new key saying it has been used recently
            remove(old);
            setHead(old);
        } else {
            // If key is new key then add and make it head
            // remove the end node from hash table if capacity exceeds
            Node created = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
                setHead(created);
            } else { // if it does not exceed the capacity then just make it head
                setHead(created);
            }
            map.put(key, created);
        }
    }

    // Remove the key from cache because it has been accessed
    private int get(int key) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            //map.remove(key); // no need to remove since key already there
            remove(temp); // remove node from doubly linked list and make it head
            setHead(temp);
            return temp.value;
        }
        return -1;
    }

    // set head and end nodes
    private void setHead(Node node) {
        node.next = head;
        node.prev = null;

        // just the check condition
        if (head != null) {
            head.prev = node;
        }
        head = node;

        // If node is the first node
        if (end == null) {
            end = head;
        }
    }

    // Remove node from cache
    private void remove(Node node) {
        // check if node is not the head node;
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        // check if node is end\tail node
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            end = node.prev;
        }
    }

    private void print() {        
        Node curr = head;
        
        while(curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        
//        for (int k : map.keySet()) {
//            Node temp = map.get(k);
//            System.out.println("key: "+k+" value: "+temp.value);
//        }
    }

    public static void main(String args[]) {
        LRUCache cache = new LRUCache(5);
        cache.set(1, 10);
        cache.set(2, 20);
        cache.set(3, 30);
        cache.set(4, 40);
        cache.set(5, 50);
        cache.get(3);
        cache.get(5);
        cache.print();
    }

}
