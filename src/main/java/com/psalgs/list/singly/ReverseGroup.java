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
 * http://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 * 
 * Reverse a Linked List in groups of given size
 *
Example:
Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 
Output:  3->2->1->6->5->4->8->7->NULL. 

Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
Output:  5->4->3->2->1->8->7->6->NULL. 
 */
public class ReverseGroup {

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

    private void addToEnd(int d) {
        Node node = new Node(d);
        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
        node.next = null;
    }

    private void printList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    private Node reverseAlt(Node head, int k) {
        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            // increment to next pointer
            current = next;
            count++;
        }

        /* Next is now a pointer to (k+1)th node 
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
        if( next != null) {
            head.next = reverseAlt(next,k);
        }
        
        return prev;
    }

    public static void main(String args[]) {
        ReverseGroup llist = new ReverseGroup();
        llist.push(1);
        llist.addToEnd(2);
        llist.addToEnd(3);
        llist.addToEnd(4);
        llist.addToEnd(5);
        llist.addToEnd(6);
        llist.addToEnd(7);
        llist.addToEnd(8);
        llist.addToEnd(9);
        llist.printList();
        llist.head = llist.reverseAlt(llist.head, 3);
        llist.printList();
    }
}
