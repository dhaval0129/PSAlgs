/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.list.singly;

/**
 *
 * @author djoshi
 */
public class RemoveCycle {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node head;

    // Function to print the linked list
    private void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Function that detects loop in the list
    private int detectRemoveCycle(Node node) {
        Node slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet at same point then loop is present
            if (slow == fast) {
//                System.out.print(slow.data + " " + fast.data);
                removeCycle(slow, node);
                return 1;
            }
        }
        return 0;
    }

    // Function to remove loop
    private void removeCycle(Node loop, Node curr) {
        Node ptr1 = curr;
        Node ptr2 = loop;

        while (true) {
            ptr2 = loop;
            while (ptr2.next != loop && ptr2.next != ptr1) {
                ptr2 = ptr2.next;
            }

            if (ptr2.next == ptr1) {
                break;
            }
            ptr1 = ptr1.next;
        }
        ptr2.next = null;
    }

    public static void main(String args[]) {
        RemoveCycle list = new RemoveCycle();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        // Creating a loop for testing 
        head.next.next.next.next.next = head.next.next;
        list.detectRemoveCycle(head);
        System.out.println("Linked List after removing loop : ");
        list.printList(head);
    }
}
