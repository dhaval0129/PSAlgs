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
 * http://www.geeksforgeeks.org/circular-linked-list-set-2-traversal/
 * 
 */
public class TraverseCList {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node head;

    private void traverseCList() {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
            
            if (curr == head) {
                break;
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        TraverseCList llist = new TraverseCList();
        head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = head;
        llist.traverseCList();
    }

}
