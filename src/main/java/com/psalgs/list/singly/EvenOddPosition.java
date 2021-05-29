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
 * http://www.geeksforgeeks.org/rearrange-a-linked-list-such-that-all-even-and-odd-positioned-nodes-are-together/
 *
 * Rearrange a linked list such that all even and odd positioned nodes are together
 *
 */
public class EvenOddPosition {

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

    private void reArrangeEvenOdd() {
        // Corner case
        if (head == null) {
            return;
        }

        // Initialize first nodes of even and
        // odd lists
        Node odd = head;
        Node even = head.next;
        Node evenFirst  = head.next;
        Node curr = head.next.next;
      
        // Remember the first node of even list so
        // that we can connect the even list at the
        // end of odd list.

        int count = 1;
        while (curr != null) {

            if (count % 2 == 0) {
                even.next = curr;
                even = curr;
            } else {
                odd.next = curr;
                odd = curr;
            }
            count++;
            curr = curr.next;
        }

        odd.next = evenFirst;
    }

    public static void main(String args[]) {
        EvenOddPosition llist = new EvenOddPosition();
        llist.head = new Node(10);
        llist.head.next = new Node(22);
        llist.head.next.next = new Node(30);
        llist.head.next.next.next = new Node(43);
        llist.head.next.next.next.next = new Node(56);
        llist.head.next.next.next.next.next = new Node(70);
        llist.printList();
        llist.reArrangeEvenOdd();
        llist.printList();
    }

}
