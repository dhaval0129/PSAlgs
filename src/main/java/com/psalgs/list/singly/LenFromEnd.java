/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.list.singly;

/**
 *
 * @author djoshi
 * 
 * Reference: http://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
 */
public class LenFromEnd {

    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    /* Function to get the nth node from the last of a
       linked list */
    private void printNthFromLast(int n) {
        int len = 0;
        Node temp = head;

        while (temp != null) {
            temp = temp.next;
            len++;
        }

        if (n > len) {
            return;
        }

        temp = head;

        for (int i = 0; i < len - n; i++) {
            temp = temp.next;
        }

        System.out.println(" Value at " + n + " is " + temp.data);
    }

    private void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Add to front of list
    private void push(int d) {
        Node n = new Node(d);
        n.next = head;
        head = n;
    }

    public static void main(String args[]) {
        LenFromEnd llist = new LenFromEnd();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(35);
        llist.printList();
        llist.printNthFromLast(4);
    }
}
