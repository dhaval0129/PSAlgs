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
 * http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list-by-changing-links/
 *
 *
 */
public class PairSwap {

    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    private void push(int d) {
        Node n = new Node(d);
        n.next = head;
        head = n;
    }

    private void printList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    private void pairSwap() {
        Node current = head;
        Node prev = null;

        while (current != null) {
            Node next = current.next;
            current.next = next.next;
            next.next = current;
            
            if (prev == null) {
                head = next;
            } else {
                prev.next = next;
            }
            prev = current;
            current = current.next;
        }
    }

    public static void main(String args[]) {
        PairSwap llist = new PairSwap();
        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(4);
        llist.push(5);
        llist.push(6);
        llist.push(7);
        llist.push(8);
        llist.printList();
        llist.pairSwap();
        llist.printList();
    }
}
