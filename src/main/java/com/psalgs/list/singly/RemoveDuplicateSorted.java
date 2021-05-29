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
 * http://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/
 *
 * Remove duplicates from a sorted linked list
 * 
 */
public class RemoveDuplicateSorted {

    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    /* compare current node to next node
     * if duplicate is found then exchange the node pointer to next node
     * else increment to next node
     */
    private void removeDuplicates() {
        Node current = head;

        while (current.next != null) {
            if (current.data == current.next.data) {
                Node next_node = current.next;
                current.next = next_node.next; // move to next node
//                next_node.next = null; // no need to point to null java will do garbage collection
            } else {
                current = current.next;
            }
        }
    }

    /* Inserts a new Node at front of the list. */
    private void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    /* Function to print linked list */
    private void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        RemoveDuplicateSorted llist = new RemoveDuplicateSorted();
        llist.push(20);
        llist.push(13);
        llist.push(13);
        llist.push(11);
        llist.push(11);
        llist.push(11);

        System.out.println("List before removal of duplicates");
        llist.printList();

        llist.removeDuplicates();

        System.out.println("List after removal of elements");
        llist.printList();
    }
}
