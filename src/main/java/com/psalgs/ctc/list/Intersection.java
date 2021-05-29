/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.ctc.list;

/**
 *
 * @author djoshi
 *
 * Write a function to get the intersection point of two Linked Lists
 *
 * https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
 *
 */
public class Intersection {

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node head1, head2;

    private static int getNode() {
        int c1 = getCount(head1);
        int c2 = getCount(head2);
        int d;

        if (c1 > c2) {
            d = c1 - c2;
            return _getIntersectionNode(d, head1, head2);
        } else {
            d = c2 - c1;
            return _getIntersectionNode(d, head2, head1);
        }
    }

    private static int _getIntersectionNode(int d, Node node1, Node node2) {
        Node curr1 = node1;
        Node curr2 = node2;

        for (int i = 0; i < d; i++) {
            if (curr1 == null) {
                return -1;
            }
            curr1 = curr1.next;
        }

        while (curr1 != null && curr2 != null) {
            if (curr1.data == curr2.data) {
                return curr1.data;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return -1;
    }

    private static int getCount(Node node) {
        Node curr = node;
        int count = 0;

        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public static void main(String args[]) {

        // creating first linked list 
        head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(15);
        head1.next.next.next = new Node(15);
        head1.next.next.next.next = new Node(30);

        // creating second linked list 
        head2 = new Node(10);
        head2.next = new Node(15);
        head2.next.next = new Node(30);

        System.out.println("The node of intersection is " + getNode());
    }
}
