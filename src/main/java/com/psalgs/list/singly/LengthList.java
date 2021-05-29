/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.list.singly;

/**
 *
 * @author djoshi
 */
public class LengthList {

    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    /* Inserts a new Node at front of the list. */
    private void push(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    /* Returns count of nodes in linked list */
    private int getCount() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    
    // Recursive solution
    private int getCountRec(Node node) {
        if(node == null) {
            return 0;
        }
        
        return 1 + getCountRec(node.next);
    }
    
    private int getCnt() {
        return getCountRec(head);
    } 

    public static void main(String[] args) {
        /* Start with the empty list */
        LengthList llist = new LengthList();
        llist.push(1);
        llist.push(3);
        llist.push(1);
        llist.push(2);
        llist.push(1);

        System.out.println("Count of nodes is "+ llist.getCount());
        System.out.println("Count nodes recursively: "+llist.getCnt());
    }

}
