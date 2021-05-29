/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.list.doubly;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/doubly-linked-list/
 *
 */
public class DLinkedList {

    class Node {

        int data;
        Node next, prev;

        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }
    }

    static Node head;
    static Node tail;

    private void addFirst(int d) {
        Node temp = new Node(d);
        temp.prev = null;
        temp.next = head;

        if (head != null) {
            head.prev = temp;
        }

        if (tail == null) {
            tail = temp;
        }

        head = temp;
    }

    private void addLast(int d) {
        Node temp = new Node(d);

        if (tail != null) {
            tail.next = temp;
            temp.prev = tail;
        }
        tail = temp;

        if (head == null) {
            head = temp;
        }
    }

    private void addPos(int pos, int d) {
        Node curr = head;
        Node temp = new Node(d);
        int count = 1;

        while (count <= pos) {
            count++;
            curr = curr.next;
        }

        temp.next = curr.next;
        temp.prev = curr;
        curr.next = temp;
    }

    private void iterateForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private void iterateBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        DLinkedList dlist = new DLinkedList();
        dlist.addFirst(5);
        dlist.addFirst(3);
        dlist.addFirst(1);
        dlist.addFirst(0);
        dlist.addLast(7);
        dlist.iterateForward();
        dlist.iterateBackward();
        System.out.println("Adding to postion 2");
        dlist.addPos(2, 4);
        dlist.iterateForward();
    }

}
