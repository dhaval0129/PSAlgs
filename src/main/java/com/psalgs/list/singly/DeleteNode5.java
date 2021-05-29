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
 * http://www.geeksforgeeks.org/delete-last-occurrence-of-an-item-from-linked-list/
 *
 * Delete last occurrence of an item from linked list
 *
 */
public class DeleteNode5 {

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
    
    private void deleteLastOccur(int key) {
        Node curr = head;
        Node prev = null;
        // delete node variables
        Node prev_del = null;
        Node next_del = head.next;
        
        while(curr != null) {
            if(curr.data == key) {
                prev_del = prev;
                next_del = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
        
        // delete last occurrence of node
        prev_del.next = next_del;
    }

    public static void main(String args[]) {
        DeleteNode5 llist = new DeleteNode5();
        llist.head = new Node(1);
        llist.head.next = new Node(2);
        llist.head.next.next = new Node(3);
        llist.head.next.next.next = new Node(5);
        llist.head.next.next.next.next = new Node(2);
        llist.head.next.next.next.next.next = new Node(10);
        llist.printList();
        int key = 2;
        llist.deleteLastOccur(key);
        System.out.println("Deleted last occurrence of key "+key);
        llist.printList();
    }

}
