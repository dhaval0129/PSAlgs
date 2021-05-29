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
 * http://www.geeksforgeeks.org/linked-list-in-zig-zag-fashion/
 *
 *
 * Rearrange a Linked List in Zig-Zag fashion
 * 
 * Given a linked list, rearrange it such that converted list 
 * should be of the form a < b > c < d > e < f where a, b, c.. are consecutive data node of linked list
 *
 */
public class ZigZagList {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node head;

    private void zigZagList() {
        boolean flag = true;
        Node curr = head;

        while (curr.next != null) {
            if (flag) { // "<" relation expected
                /* If we have a situation like A > B > C
               where A, B and C are consecutive Nodes
               in list we get A > B < C by swapping B
               and C */
               if(curr.data > curr.next.data)
                   swap(curr,curr.next);
            } else { // ">" relation expected 
                /* If we have a situation like A < B < C where
               A, B and C  are consecutive Nodes in list we
               get A < C > B by swapping B and C */
               if(curr.data < curr.next.data)
                   swap(curr,curr.next);
            }
            curr = curr.next;
            flag = !flag;
        }
    }
    
    private void swap(Node a,Node b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }

    private void printList() {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        ZigZagList llist = new ZigZagList();
        llist.head = new Node(4);
        llist.head.next = new Node(3);
        llist.head.next.next = new Node(7);
        llist.head.next.next.next = new Node(8);
        llist.head.next.next.next.next = new Node(6);
        llist.head.next.next.next.next.next = new Node(2);
        llist.head.next.next.next.next.next.next = new Node(1);

        llist.printList();
        llist.zigZagList();
        llist.printList();
    }

}
