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
 * http://www.geeksforgeeks.org/delete-a-linked-list-node-at-a-given-position/
 *
 * Delete a Linked List node at a given position
 *
 */
public class DeleteNode6 {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node head;

    private void printList() {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private void deletePos(int key) {
        Node curr = head;
        Node prev = null;

        int count = 0;

        while (curr != null) {
            Node next = curr.next;

            if (count == key) {
                // if node is first node
                if (key == 0) {
                    head = next;
                } else {
                    prev.next = next;
                }
            }

            count++;
            prev = curr;
            curr = curr.next;
        }
    }

    public static void main(String args[]) {
        DeleteNode6 llist = new DeleteNode6();
        llist.head = new Node(8);
        llist.head.next = new Node(2);
        llist.head.next.next = new Node(3);
        llist.head.next.next.next = new Node(1);
        llist.head.next.next.next.next = new Node(7);
        llist.printList();
        System.out.println("Delete Node from third position");
        llist.deletePos(3);
        llist.printList();
        System.out.println("Delete Node from zero position");
        llist.deletePos(0);
        llist.printList();
    }

}
