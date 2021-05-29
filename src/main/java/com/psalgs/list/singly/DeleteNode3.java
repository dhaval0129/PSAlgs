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
 *
 * http://www.geeksforgeeks.org/delete-alternate-nodes-of-a-linked-list/
 *
 * Delete alternate nodes of a Linked List
 */
public class DeleteNode3 {

    class Node {

        int data;
        Node next = null;

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
        Node n = new Node(d);
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = n;
    }

    private void addToMiddle(int d) {
        Node n = new Node(d);
        Node prev = null;
        Node next = null;
        Node current = head;

        while (current.data < d) {
            prev = current;
            next = current.next;
            current = next;
        }

        n.next = prev.next;
        prev.next = n;
    }

    private void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    private void deleteAlt() {
        Node current = head;
        
        while(current != null && current.next != null) {
            // Node need to rename nodes
//            Node next = current.next;
//            current.next = next.next;
//            next.data = 0;
//            next.next = null;
//            current = current.next;
//            System.out.print(current.data +" ");
            current.next = current.next.next;
            current = current.next;
        }
    }

    public static void main(String args[]) {
        DeleteNode3 llist = new DeleteNode3();
        llist.push(1);
        llist.addToEnd(3);
        llist.addToEnd(5);
        llist.addToEnd(7);
        llist.addToEnd(9);
        llist.addToEnd(10);
        llist.addToEnd(12);
        llist.addToMiddle(6);
        llist.addToMiddle(11);
        llist.printList();
        System.out.println("Deleting Alternate Nodes");
        llist.deleteAlt();
        llist.printList();
    }

}
