/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.list.circular;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/split-a-circular-linked-list-into-two-halves/
 *
 *
 */
public class SplitCList {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node head;
    static Node head1;
    static Node head2;

    private void splitList() {
        Node slow_ptr = head;
        Node fast_ptr = head;

        if (head == null) {
            return;
        }

        while (fast_ptr.next != head
                && fast_ptr.next.next != head) {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }

        /* If there are even elements in list then move fast_ptr */
        if (fast_ptr.next.next == head) {
            fast_ptr = fast_ptr.next;
        }

        /* Set the head pointer of first half */
        head1 = head;

        /* Set the head pointer of second half */
        if (head.next != head) {
            head2 = slow_ptr.next;
        }
        
         /* Make second half circular */
        fast_ptr.next = slow_ptr.next;
        
        /* Make first half circular */
        slow_ptr.next = head;
    }

    private void traverseClist(Node head) {
        Node curr = head;

        while (true) {
            System.out.print(curr.data + " ");
            curr = curr.next;

            if (curr == head) {
                break;
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        SplitCList llist = new SplitCList();
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head;
        
        llist.traverseClist(head);
        llist.splitList();
        System.out.println("Split list in two parts");
        llist.traverseClist(head1);
        llist.traverseClist(head2);
    }

}
