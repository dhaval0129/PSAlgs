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
 * http://www.geeksforgeeks.org/delete-a-node-in-a-doubly-linked-list/
 * 
 * Delete a node in a Doubly Linked List
 * 
 */
public class DeleteNode {

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

    private void addFirst(int d) {
        Node temp = new Node(d);
        temp.next = head;
        head = temp;

        if (head != null) {
            temp = head.prev;
        }

        if (tail == null) {
            tail = temp;
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

    private void deleteNode(int d) {
        Node curr = head;
        Node prev = null;
        Node temp = new Node(d);

        while (curr != null) {
            if (curr.data == temp.data) {
                if (curr == head) {
                    // if node is head node
                    head = curr.next;
                    curr.next.prev = head;
                } else if (curr.next == tail) {
                    //if node is last node
                    tail = curr.prev;
                    prev.next = tail;
                } else {
                    // if node is middle node
                    prev.next = curr.next;
                    curr.next.prev = prev;
                }
            }
            prev = curr;
            curr = curr.next;
        }

    }

    public static void main(String args[]) {
        DeleteNode dllist = new DeleteNode();
        dllist.addFirst(0);
        dllist.addFirst(1);
        dllist.addFirst(2);
        dllist.addFirst(3);
        dllist.addFirst(4);
        dllist.addFirst(5);
        dllist.printList();
        System.out.println("Delete Head Node");
        dllist.deleteNode(5);
        dllist.printList();
        System.out.println("Delete Tail Node");
        dllist.deleteNode(0);
        dllist.printList();
        System.out.println("Delete Middle Node 2");
        dllist.deleteNode(2);
        dllist.printList();
    }

}
