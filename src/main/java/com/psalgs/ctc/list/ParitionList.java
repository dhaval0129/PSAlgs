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
 * Write code to partition a linked list around a value x, such that all nodes
 * less than x come before all nodes greater than or equal to x. If x is
 * contained within the list, the values of x only need to be after the elements
 * less than x
 * 
 *  solution :
 *  
 * 1] get the partition node data value at position X
 * 2] Create list L1 with less node data value
 * 3] Create list L2 with node data value greater than or equal to node data value
 * 4] Join L1 and L2 with node data value in front and back
 * 5] 
 */
public class ParitionList {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            this.data = d;
            next = null;
        }
    }

    static Node head;

    private static void printList(Node node) {
        Node curr = node;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    
    private static Node partition(Node curr, int x) {
        Node head = curr;
        Node tail = curr;
        
        while(curr != null) {
            Node next = curr.next;
            
            if(curr.data < x) {
                curr.next = head;
                head = curr;
            } else {
                tail.next = curr;
                tail = curr;
            }
            curr = next;
        }
        
        tail.next = null;
        return head;
    }

    public static void main(String args[]) {
        head = new Node(3);
        head.next = new Node(5);
        head.next.next = new Node(8);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);

        printList(head);
        Node n = partition(head, 5);
        printList(n);
    }
}
