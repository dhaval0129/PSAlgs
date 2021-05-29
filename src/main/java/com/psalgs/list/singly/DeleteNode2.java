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
 * http://www.geeksforgeeks.org/delete-nodes-which-have-a-greater-value-on-right-side/
 *
 * Delete nodes which have a greater value on right side
 *
 */
public class DeleteNode2 {

    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    /* Deletes nodes which have a node with greater
       value node on left side */
    void delLesserNodes() {
        /* 1.Reverse the linked list */
        reverseList();

        /* 2) In the reversed list, delete nodes which
           have a node with greater value node on left
           side. Note that head node is never deleted
           because it is the leftmost node.*/
        _delLesserNodes();

        /* 3) Reverse the linked list again to retain
           the original order */
        reverseList();
    }

    /* Deletes nodes which have greater value node(s)
       on left side */
    private void _delLesserNodes() {
        Node current = head;

        /* Initialise max */
        Node maxnode = head;
        Node temp;

        while (current != null && current.next != null) {
            /* If current is smaller than max, then delete
               current */
            if (current.next.data < maxnode.data) {
                temp = current.next;
                current.next = temp.next;
                temp = null;
            } else {
                /* If current is greater than max, then update
                max and move current */
                current = current.next;
                maxnode = current;
            }
        }
    }

    // O(n)
    private void deleteNode() {
        Node current = head;
        Node prev_node = null;
        Node next_node = null;

        while (current != null && current.next != null) {
            next_node = current.next;
            if (current.data < next_node.data) {
                // delete the current node
                if (prev_node != null) {
                    prev_node.next = next_node;
                } else {
                    head = next_node;
                }
                current.next = null;
            } else {
                prev_node = current;
            }
            current = next_node;
        }
    }

    private Node reverseList() {
        Node current = head;
        Node prev = null;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return prev;
    }

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

    public static void main(String args[]) {
        DeleteNode2 llist = new DeleteNode2();
        llist.push(12);
        llist.addToEnd(15);
        llist.addToEnd(10);
        llist.addToEnd(11);
        llist.addToEnd(5);
        llist.addToEnd(6);
        llist.addToEnd(2);
        llist.addToEnd(3);
        llist.printList();
//        llist.delLesserNodes();
        llist.deleteNode();
        llist.printList();
    }
}
