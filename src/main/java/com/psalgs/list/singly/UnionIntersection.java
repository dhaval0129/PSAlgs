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
 * http://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/
 * 
 * Union and Intersection of two Linked Lists
 * 
 */
public class UnionIntersection {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    private void push(int d) {
        Node node = new Node(d);
        node.next = head;
        head = node;
    }

    private void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    private boolean isPresent(Node head, int data) {
        Node t = head;

        while (t != null) {
            if (t.data == data) {
                return true;
            }
            t = t.next;
        }
        return false;
    }

    private void getIntersection(Node head1, Node head2) {
        Node t1 = head1;

        while (t1 != null) {
            if (isPresent(head2, t1.data)) {
                push(t1.data);
            }
            t1 = t1.next;
        }
    }

    private void getUnion(Node head1, Node head2) {
        Node t1 = head1;
        Node t2 = head2;

        while (t1 != null) {
            push(t1.data);
            t1 = t1.next;
        }

        while (t2 != null) {
            if (!isPresent(head2, t2.data)) {
                push(t2.data);
            }
            t2 = t2.next;
        }
    }

    public static void main(String args[]) {
        UnionIntersection llist1 = new UnionIntersection();
        UnionIntersection llist2 = new UnionIntersection();
        UnionIntersection union = new UnionIntersection();
        UnionIntersection intersection = new UnionIntersection();

        /*create a linked lits 10->15->5->20 */
        llist1.push(20);
        llist1.push(4);
        llist1.push(15);
        llist1.push(10);

        /*create a linked lits 8->4->2->10 */
        llist2.push(10);
        llist2.push(2);
        llist2.push(4);
        llist2.push(8);

        intersection.getIntersection(llist1.head, llist2.head);
        union.getUnion(llist1.head, llist2.head);

        System.out.println("First List is");
        llist1.printList();

        System.out.println("\nSecond List is");
        llist2.printList();

        System.out.println("\nIntersection List is");
        intersection.printList();

        System.out.println("\nUnion List is");
        union.printList();
        System.out.println();
    }

}
