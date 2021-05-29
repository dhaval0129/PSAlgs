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
 * http://www.geeksforgeeks.org/sort-linked-list-already-sorted-absolute-values/
 *
 * Sort linked list which is already sorted on absolute values
 */
public class AbsValueSort {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node head;

    private void printList() {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private void absSort() {
        Node curr = head.next;
        Node prev = head;
        while (curr != null) {
            
            if (curr.data < 0) {
                // move the node with -ve value to first of the list since list is already sorted.
                prev.next = curr.next;
                curr.next = head;
                head = curr;
                // mark previous node as current
                curr = prev;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
    }

    public static void main(String args[]) {
        AbsValueSort llist = new AbsValueSort();
        llist.head = new Node(0);
        llist.head.next = new Node(1);
        llist.head.next.next = new Node(-2);
        llist.head.next.next.next = new Node(-3);
        llist.head.next.next.next.next = new Node(4);
        llist.head.next.next.next.next.next = new Node(5);
        llist.head.next.next.next.next.next.next = new Node(-5);
        llist.printList();
        llist.absSort();
        llist.printList();
    }

}
