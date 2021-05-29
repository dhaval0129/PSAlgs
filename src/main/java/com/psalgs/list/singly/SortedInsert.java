/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.list.singly;

/**
 *
 * @author djoshi
 */
public class SortedInsert {

    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    private void addFront(int d) {
        Node n = new Node(d);
        n.next = head;
        head = n;
    }

    private void addAtEnd(int d) {
        Node temp = head;
        Node n = new Node(d);

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = n;
    }

    private void sortedInsert(int d) {
        Node next = head;
        Node curr = new Node(d);
        Node prev = null;

        while (next != null && next.data <= d) {
            prev = next;
            next = next.next;
        }
        
        curr.next = next;
        prev.next = curr;
    }

    private void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        SortedInsert llist = new SortedInsert();
        llist.addFront(1);
        llist.addAtEnd(3);
        llist.addAtEnd(5);
        llist.addAtEnd(7);
        llist.addAtEnd(9);
        llist.addAtEnd(11);
        llist.printList();
        llist.sortedInsert(8);
        llist.printList();
    }
}
