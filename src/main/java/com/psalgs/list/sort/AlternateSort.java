/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.list.sort;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/how-to-sort-a-linked-list-that-is-sorted-alternating-ascending-and-descending-orders/
 *
 * Input List: 10->40->53->30->67->12->89->NULL Output List:
 * 10->12->30->43->53->67->89->NULL
 *
 * Sort a linked list that is sorted alternating ascending and descending orders?
 * 
 */
public class AlternateSort {

    Node head;

    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node newNode(int key) {
        return new Node(key);
    }

    private void sort() {
        Node Ahead = new Node(0);
        Node Dhead = new Node(0);

        // Split the list into lists
        splitList(Ahead, Dhead);

        Ahead = Ahead.next;
        Dhead = Dhead.next;

        // Reverse the descending list
        Dhead = reverseList(Dhead);

        head = mergeList(Ahead, Dhead);

    }

    private Node mergeList(Node head1,Node head2) {
        // Base cases
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        
        Node temp = null;
        
        if(head1.data < head2.data) {
            temp = head1;
            head1.next = mergeList(head1.next,head2);
        } else {
            temp = head2;
            head2.next = mergeList(head1,head2.next);
        }
        
        return temp;
    }

    private Node reverseList(Node n) {
        Node curr = n;
        Node prev = null;

        while (curr != null) {
            Node next = curr.next;
            // reverse node logic
            curr.next = prev;
            // increment prev and next pointer
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private void splitList(Node Ahead, Node Dhead) {
        Node ascn = Ahead;
        Node dscn = Dhead;
        Node curr = head;

        while (curr != null) {
            ascn.next = curr;
            ascn = ascn.next;
            curr = curr.next;

            if (curr != null) {
                dscn.next = curr;
                dscn = dscn.next;
                curr = curr.next;
            }
        }
        ascn.next = null;
        dscn.next = null;
    }

    private void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        AlternateSort llist = new AlternateSort();
        llist.head = llist.newNode(10);
        llist.head.next = llist.newNode(40);
        llist.head.next.next = llist.newNode(53);
        llist.head.next.next.next = llist.newNode(30);
        llist.head.next.next.next.next = llist.newNode(67);
        llist.head.next.next.next.next.next = llist.newNode(12);
        llist.head.next.next.next.next.next.next = llist.newNode(89);

        System.out.println("Given linked list");
        llist.printList();

        llist.sort();

        System.out.println("Sorted linked list");
        llist.printList();
    }

}
