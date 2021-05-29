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
 * http://www.geeksforgeeks.org/merge-a-linked-list-into-another-linked-list-at-alternate-positions/
 *
 * Merge a linked list into another linked list at alternate positions
 *
 */
public class MergeList2 {

    class Node {

        int data;
        Node next;

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

    private void printList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    private void merge(MergeList2 list1, MergeList2 list2) {
        Node n1 = list1.head;
        Node n2 = list2.head;
        
        while(n1 != null ) {
            Node l1_next = n1.next;
            Node l2_next = n2.next;
                        
            // add node from second list
            n1.next = n2;
            n2.next = l1_next;
            
            n1 = l1_next;
            n2 = l2_next;
        }
        
        list2.head = n2;
    }

    public static void main(String args[]) {
        MergeList2 llist1 = new MergeList2();
        MergeList2 llist2 = new MergeList2();
        llist1.push(3);
        llist1.push(2);
        llist1.push(1);

        System.out.println("First Linked List:");
        llist1.printList();

        llist2.push(8);
        llist2.push(7);
        llist2.push(6);
        llist2.push(5);
        llist2.push(4);

        System.out.println("Second Linked List:");
        llist2.printList();
        
        llist1.merge(llist1,llist2);

        System.out.println("Modified first linked list:");
        llist1.printList();

        System.out.println("Modified second linked list:");
        llist2.printList();
    }
}
