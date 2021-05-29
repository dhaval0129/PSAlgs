/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.list.singly;

/**
 *
 * @author djoshi.
 *
 * http://www.geeksforgeeks.org/write-a-recursive-function-to-print-reverse-of-a-linked-list/
 *
 * Write a recursive function to print reverse of a Linked List
 *
 */
public class PrintReverse {

    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    private void printReverse(Node head) {
        if (head == null) {
            return;
        }

        printReverse(head.next);
        System.out.print(head.data + "->");
    }

    /* Utility Functions */
    /* Inserts a new Node at front of the list. */
    private void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  put in the data*/
        Node new_node = new Node(new_data);
        /* 3. Make next of new Node as head */
        new_node.next = head;
        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    private void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String args[]) {
        // Let us create linked list 1->2->3->4
        PrintReverse llist = new PrintReverse();
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
        System.out.println("Original Linkedlist");
        llist.printList();
        System.out.println("Reversed Print (Recursion) ");
        llist.printReverse(llist.head);
        System.out.println("NULL");
    }
}
