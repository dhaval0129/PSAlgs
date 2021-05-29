/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.list.sort;

/**
 *
 * @author djoshi
 * 
 * http://www.geeksforgeeks.org/insertion-sort-for-singly-linked-list/
 * 
 * 
 */
public class InsertionSort {

    Node head;
    Node sorted;

    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    private void push(int data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
    }

    private void printlist(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    private void insertionSort(Node headref) {
        sorted = null;
        Node current = headref;

        while (current != null) {
            Node next = current.next;
            sortedInsert(current);
            current = next;
        }
        head = sorted;
    }

    private void sortedInsert(Node newNode) {
        if (sorted == null || sorted.data >= newNode.data) {
            newNode.next = sorted;
            sorted = newNode;
        } else {
            Node current = sorted;
            while (current.next != null && current.next.data < newNode.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public static void main(String args[]) {
        InsertionSort list = new InsertionSort();
        list.push(5);
        list.push(20);
        list.push(4);
        list.push(3);
        list.push(30);
        System.out.println("Linked List before Sorting..");
        list.printlist(list.head);
        list.insertionSort(list.head);
        System.out.println("\nLinkedList After sorting");
        list.printlist(list.head);
    }

}
