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
 * http://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
 * 
 * http://www.geeksforgeeks.org/linked-list-set-3-deleting-node/
 * 
 * http://www.geeksforgeeks.org/delete-a-linked-list-node-at-a-given-position/
 * 
 * 
 */
public class LinkedList {

    Node head;

    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /**
     * Inserts a new Node at front of the list.
     *
     * @param new_data
     */
    private void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    /**
     * Inserts a new node after the given prev_node.
     *
     * @param prev_node
     * @param new_data
     */
    private void insertAfter(Node prev_node, int new_data) {
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
        }

        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    /**
     * Appends a new node at the end. This method is defined inside LinkedList
     * class shown above
     *
     * @param new_data
     */
    private void append(int new_data) {
        Node new_node = new Node(new_data);

        if (head == null) {
            head = new Node(new_data);
            return;
        }

        new_node.next = null;

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = new_node;
    }

    /**
     * Delete node based on key
     *
     * @param key
     */
    private void deleteNode(int key) {
        Node temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next; // Changed head
            return;
        }

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null) {
            return;
        }

        // Unlink the node from linked list
        prev.next = temp.next;
    }

    /**
     * Delete node based on given position Note: here we use double parameter
     * because in above delete method we have already used int parameter
     *
     * @param pos
     */
    private void deletePos(int pos) {
        // If linked list is empty
        if (head == null) {
            return;
        }

        // Store head node
        Node temp = head;

        // If head needs to be removed
        if (pos == 0) {
            head = temp.next;   // Change head
            return;
        }

        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }

        // If position is more than number of ndoes
        if (temp == null || temp.next == null) {
            return;
        }

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;
        temp.next = next; // Unlink the deleted node from list
    }

    private void printList() {
        Node n = head;

        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
    
    private int getCount() {
        Node temp = head;
        int count = 0;
        
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static void main(String args[]) {
        /* Start with the empty list */
        LinkedList llist = new LinkedList();
        // Insert 6.  So linked list becomes 6->NUllist
        llist.append(6);
        // Insert 7 at the beginning. So linked list becomes
        // 7->6->NUllist
        llist.push(7);
        // Insert 1 at the beginning. So linked list becomes
        // 1->7->6->NUllist
        llist.push(1);
        // Insert 4 at the end. So linked list becomes
        // 1->7->6->4->NUllist
        llist.append(4);
        // Insert 8, after 7. So linked list becomes
        // 1->7->8->6->4->NUllist
        llist.insertAfter(llist.head.next, 8);
        System.out.println("\nCreated Linked list is: ");
        llist.printList();
        
        // Delete node at position 8
        llist.deleteNode(8);
        System.out.println("deleted node 8");
        llist.printList();        
        // Delete node at position 2  which is 7
        System.out.println("deleted node at position 2");
        llist.deletePos(1);
        llist.printList();
        System.out.println("Size of list: "+llist.getCount());
    }
}
