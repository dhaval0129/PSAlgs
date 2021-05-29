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
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 *
 */
public class ReverseList2 {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node head;

    private static void printList() {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private static void reverseList(int m, int n) {
        Node curr = head;
        Node prev = null;
        Node next = null;
        
        // start and end nodes are used below to track end points
        // of original list are needed for connection when middle list is reversed 
        Node start = null; 
        Node end = null;
        
        int i = 1;

        while (i < m) {
            i++;
            prev = curr;
            curr = curr.next;
        }
        
        start = prev;
        end = curr;

        while (i <= n) {
           
            next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
            i++;
        }
        
        start.next = prev;
        end.next = curr;
    }

    public static void main(String args[]) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        int start = 2;
        int end = 4;

        printList();
        reverseList(start, end);
        printList();
    }
}
