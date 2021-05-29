/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.list.circular;

/**
 *
 * @author djoshi
 */
public class SortedInsert {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node head;

    private void traverseCList() {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;

            if (curr == head) {
                break;
            }
        }
        System.out.println();
    }

    private void insert(int d) {
        Node n = new Node(d);
        Node curr = head;
        Node prev = null;

        while (true) {

            if (curr.next != head && curr.data <= d) {
                prev = curr;
                curr = curr.next;
            } else {
                // If node to be inserted is the first node
                if (curr == head) {
                    // traverse to end of list and point last node to new head node
                    while (curr.next != head) {
                        curr = curr.next;
                    }
                    curr.next = n;
                    n.next = head;
                    head = n;
                } else if (curr.next == head) {
                    // node to be inserted is the last node
                    curr.next = n;
                    n.next = head;
                } else {
                    // if node to be inserted is in middle
                    n.next = prev.next;
                    prev.next = n;
                }
                break;
            }
        }

    }

    public static void main(String args[]) {
        SortedInsert llist = new SortedInsert();
        llist.head = new Node(1);
        llist.head.next = new Node(3);
        llist.head.next.next = new Node(5);
        llist.head.next.next.next = new Node(7);
        llist.head.next.next.next.next = new Node(9);
        llist.head.next.next.next.next.next = new Node(11);
        llist.head.next.next.next.next.next.next = head;
        llist.traverseCList();
        System.out.println("Insert in the middle of list");
        llist.insert(8);
        llist.traverseCList();
        System.out.println("Insert at the end of list");
        llist.insert(12);
        llist.traverseCList();
        System.out.println("Insert at the begining of list");
        llist.insert(0);
        llist.traverseCList();
    }
}
