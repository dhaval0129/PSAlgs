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
 * Reference: http://www.geeksforgeeks.org/write-a-function-to-get-nth-node-in-a-linked-list/
 */
public class nthNode {

    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    // add node to front of the list
    private void push(int d) {
        Node n = new Node(d);
        n.next = head;
        head = n;
    }

    private int GetNth(int d) {
        Node n = head;
        int count = 0;
        
        while (n != null) {
            if (count == d) {
                return n.data;
            }
            count++;
            n = n.next;
        }

        assert(false);
        return 0;
    }

    public static void main(String[] args) {
        /* Start with empty list */
        nthNode llist = new nthNode();

        /* Use push() to construct below list 1->12->1->4->1  */
        llist.push(1);
        llist.push(4);
        llist.push(1);
        llist.push(12);
        llist.push(1);

        /* Check the count function */
        int n = 30;
        System.out.println("Element at index "+ n +" is " + llist.GetNth(n));
    }

}
