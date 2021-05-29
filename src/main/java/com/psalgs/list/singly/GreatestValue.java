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
 * http://www.geeksforgeeks.org/point-arbit-pointer-greatest-value-right-side-node-linked-list/
 *
 * Point arbit pointer to greatest value right side node in a linked list
 *
 * An Efficient Solution can work in O(n) time. Below are steps.
 *
 * Reverse given linked list. 
 * 
 * Start traversing linked list and store maximum value node encountered so far.
 * 
 * Make arbit of every node to point to max. 
 * 
 * If the data in current node is more than max node so far, update max. 
 * 
 * Reverse modified linked list and return head
 * 
 */
public class GreatestValue {

    static class Node {

        int data;
        Node next, arbit;

        Node(int d) {
            data = d;
            next = null;
            arbit = null;
        }
    }

    static Node head;

    private void printList() {
        Node curr = head;
        System.out.println("Node\t" + "Next Pointer\t" + "Arbit Pointer");
        while (curr.next != null) {
            System.out.print(curr.data + "\t" + curr.next.data + "\t");
            if (curr.arbit == null) {
                System.out.print("null\n");
            } else {
                System.out.print(curr.arbit.data + "\n");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    private void populateArbit() {
        reverseList();

        Node max = head;
        Node curr = head.next;

        while (curr != null) {
            curr.arbit = max;

            if (max.data < curr.data) {
                max = curr;
            }

            curr = curr.next;
        }

        reverseList();
    }

    private void reverseList() {
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String args[]) {
        GreatestValue llist = new GreatestValue();
        llist.head = new Node(5);
        llist.head.next = new Node(10);
        llist.head.next.next = new Node(2);
        llist.head.next.next.next = new Node(3);
        llist.printList();
        llist.populateArbit();
        llist.printList();
    }
}
