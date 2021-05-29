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
 * http://www.geeksforgeeks.org/delete-alternate-nodes-of-a-linked-list/
 *
 * Delete alternate nodes of a Linked List
 *
 */
public class DeleteAlternate {

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
        Node node = new Node(d);
        node.next = head;
        head = node;
    }

    private void addToEnd(int d) {
        Node current = head;
        Node new_node = new Node(d);

        while (current.next != null) {
            current = current.next;
        }

        current.next = new_node;
        new_node.next = null;

    }

    private void printList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    private void deleteAlt() {
        if (head == null) {
            return;
        }

        Node prev = head;
        Node now = head.next;

        while (prev != null && now != null) {
            /* Change next link of previus node */
            prev.next = now.next;

            /* Free node */
            now = null;

            /*Update prev and now */
            prev = prev.next;
            if (prev != null) {
                now = prev.next;
            }
        }
    }

    public static void main(String args[]) {
        DeleteAlternate llist = new DeleteAlternate();
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
        llist.addToEnd(6);
        llist.printList();
        llist.deleteAlt();
        llist.printList();
    }
}
