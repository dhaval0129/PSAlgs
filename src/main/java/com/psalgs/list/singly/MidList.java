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
 * http://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
 * 
 */
public class MidList {

    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }

    }

    Node head;

    /**
     * Traverse linked list using two pointers. 
     * Move one pointer by one and other pointer by two. 
     * When the fast pointer reaches end slow pointer will reach middle of the linked list
     */
    private void printMiddle() {
        Node slow_ptr = head;
        Node fast_ptr = head;

        while (fast_ptr != null && fast_ptr.next != null) {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }

        System.out.println("middle element: " + slow_ptr.data);
    }

    /* This function prints contents of linked list
       starting from  the given node */
    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + "->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }

    //insert to first element of the list
    private void push(int d) {
        Node n = new Node(d);
        n.next = head;
        head = n;
    }

    public static void main(String[] args) {
        MidList llist = new MidList();
        for (int i = 5; i > 0; --i) {
            llist.push(i);
            llist.printList();
            llist.printMiddle();
        }
    }
}
