/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.list.singly;

import java.util.UUID;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/select-a-random-node-from-a-singly-linked-list/
 *
 * Select a Random Node from a Singly Linked List
 *
 */
public class RandomNode {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // A reservoir sampling based function to print a
    // random node from a linked list
    private void printRandom(Node node) {
        // If list is empty
        if (node == null) {
            return;
        }

        // Use a different seed value so that we don't get
        // same result each time we run this program
        Math.abs(UUID.randomUUID().getMostSignificantBits());
        
        // Initialize result as first node
        int result = node.data;

        Node current = node;
        int n;
        for (n = 2; current != null; n++) {
            if (Math.random() % n == 0) {
                result = current.data;
            }
            current = current.next;
        }
        System.out.println("Randomly selected key is " + result);
    }

    public static void main(String[] args) {

        RandomNode list = new RandomNode();
        list.head = new Node(5);
        list.head.next = new Node(20);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(3);
        list.head.next.next.next.next = new Node(30);

        list.printRandom(head);

    }
}
