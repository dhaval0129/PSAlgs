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
 * Reference:
 * http://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/
 *
 * Segregate even and odd nodes in a Linked List
 *
 */
public class Segregate {

    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;
    Node end;

    private void push(int d) {
        Node n = new Node(d);
        n.next = head;
        head = n;
    }

    private void addToEnd(int d) {
        Node n = new Node(d);
        Node temp = head;

        if (end == null) {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        } else {
            end.next = n;
        }
        end = n;
    }

    private void printList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    private void segregateEvenOdd() {
        Node current = head;
        Node prev = null;
        Node next = null;
        Node odd = end;
        
        while (current != end) {
            next = current.next;
            if (current.data % 2 != 0) {
                // move to the last node;
                Node n = new Node(current.data);
                odd.next = n;
                odd = n;
                // next node

                if (prev != null) {
                    prev.next = next;
                } else {
                    head = next;
                }
                current.next = null;
            } else {
                prev = current;
            }
            current = next;
        }
    }

    public static void main(String args[]) {
        Segregate llist = new Segregate();
        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(4);
        llist.push(5);
        llist.push(6);
        llist.push(7);
        llist.addToEnd(8);
        llist.addToEnd(9);
        System.out.println("Original Linked List");
        llist.printList();
        llist.segregateEvenOdd();
        System.out.println("Modified Linked List");
        llist.printList();
    }
}
