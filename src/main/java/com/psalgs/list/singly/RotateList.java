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
 * O(m * n )
 */
public class RotateList {

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
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }
    
    private void rotateAfter(int k) {
        Node current = head;
        Node prev = null;
        int count = 0;
        while(count < k) {
            prev = current;
            current = current.next;
            count++;
        }
        prev.next = null;
        Node rPoint = current;
        
        while(current.next != null ) {
            current = current.next;
        }

        current.next = head;
        head = rPoint;
    }

    public static void main(String args[]) {
        RotateList llist = new RotateList();
        llist.push(60);
        llist.push(50);
        llist.push(40);
        llist.push(30);
        llist.push(20);
        llist.push(10);
        llist.printList();
        llist.rotateAfter(4);
        llist.printList();
    }

}
