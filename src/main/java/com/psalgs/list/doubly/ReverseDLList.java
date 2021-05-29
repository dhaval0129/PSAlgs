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
 * http://www.geeksforgeeks.org/reverse-a-doubly-linked-list/
 * 
 * Reverse a Doubly Linked List
 * 
 */
public class ReverseDLList {

    class Node {

        int data;
        Node next;
        Node prev;

        Node(int d) {
            data = d;
            next = prev = null;
        }
    }

    Node head;
    Node tail;

    private void push(int d) {
        Node node = new Node(d);
        node.next = head;

        if (head != null) {
            head.prev = node;
        }
        head = node;

        if (tail == null) {
            tail = node;
        }
    }

    private void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private void reverseDLL() {
        Node curr = head;
        Node prev = null;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            
            // exchange the next and prev pointers
            curr.next = prev;
            curr.prev = next;
            
            prev = curr;
            curr = next;
        }
        
        // swap head and tail pointers
        Node temp = head;
        head = tail;
        tail = temp;
    }

    public static void main(String args[]) {
        ReverseDLList dbllist = new ReverseDLList();
        dbllist.push(0);
        dbllist.push(1);
        dbllist.push(2);
        dbllist.push(3);
        dbllist.push(4);
        dbllist.push(5);
        dbllist.printList();
        System.out.println("Reversed doubly linked list");
        dbllist.reverseDLL();
        dbllist.printList();
    }

}
