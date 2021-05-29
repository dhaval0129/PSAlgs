/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.list.singly;

import java.util.HashMap;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/
 *
 * Remove duplicates from a sorted linked list
 *
 * Hint: Use Hashing
 *
 * We traverse the link list from head to end. For every newly encountered
 * element, we check whether it is in the hash table: if yes, we remove it.
 * otherwise we put it in the hash table.
 *
 * Time Complexity:
 *
 * O(n) on average (assuming that hash table access time is O(1) on average)
 *
 * http://algorithms.tutorialhorizon.com/remove-duplicates-from-an-unsorted-linked-list/
 *
 */
public class RemoveDuplicateUnsorted {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    private Node removeDuplicates(Node head) {
        HashMap<Integer, Integer> ht = new HashMap<>();
        
        if (head == null) {
            return null;
        }

        Node curr = head.next;
        Node prev = head;
        Node temp; //keeping it so that last node would be eligible for garbage collection
        ht.put(head.data, 1);

        while (curr != null) {
            int data = curr.data;

            if (ht.containsKey(data)) {
                // delete the duplicate node and exchange the pointers
                prev.next = curr.next;
                temp = curr;
                temp = null;
            } else {
                // Move to next node and update prev pointer
                ht.put(data, 1);
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    public void printList(Node head) {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println("NULL");
    }

    public static void main(String args[]) {
        RemoveDuplicateUnsorted llist = new RemoveDuplicateUnsorted();
        llist.head = new Node(2);
        llist.head.next = new Node(2);
        llist.head.next.next = new Node(2);
        llist.head.next.next.next = new Node(3);
        llist.head.next.next.next.next = new Node(4);
        llist.head.next.next.next.next.next = new Node(4);
        llist.head.next.next.next.next.next.next = new Node(2);
        System.out.print("Original List : ");

        llist.printList(llist.head);
        System.out.print("Updated List: ");
        Node x = llist.removeDuplicates(llist.head);
        llist.printList(x);
    }

}
