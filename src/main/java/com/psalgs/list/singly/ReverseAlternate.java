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
 * http://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
 *
 * Reverse alternate K nodes in a Singly Linked List
 *
 * Inputs: 1->2->3->4->5->6->7->8->9->NULL and k = 3 Output:
 * 3->2->1->4->5->6->9->8->7->NULL.
 */
public class ReverseAlternate {

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

    private Node kAltReverse(Node node, int k) {
        Node current = node;
        Node prev = null;
        Node next = null;
        int count1 = 0;

        /*1) reverse first k nodes of the linked list */
        while (count1 < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            // increment to next node
            current = next;
            count1++;
        }

        /* 2) Now head points to the kth node.  So change next 
         of head to (k+1)th node*/
        if (node != null) {
            node.next = current;
        }

        /* 3) We do not want to reverse next k nodes. So move the current 
         pointer to skip next k nodes */
        int count2 = 0;
        while (count2 < k - 1 && current != null) {
            current = current.next;
            count2++;
        }

        /* 4) Recursively call for the list starting from current->next.
         And make rest of the list as next of first node */
        if (current != null) {
            current.next = kAltReverse(current.next, 3);
        }

        /* 5) prev is new head of the input list */
        return prev;
    }

    public static void main(String args[]) {
        ReverseAlternate llist = new ReverseAlternate();
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
        llist.head = llist.kAltReverse(llist.head, 3);
        llist.printList();
    }

}
