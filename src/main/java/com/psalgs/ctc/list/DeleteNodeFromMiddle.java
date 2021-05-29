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
 * Implement an algorithm to delete a node in the middle (i.e., any node but the
 * first and last node, not necessarily the exact middle) of a singly linked
 * list
 */
public class DeleteNodeFromMiddle {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            this.data = d;
            next = null;
        }
    }

    static Node head;
    
    private static void deleteMiddleNode(int x) {
        Node curr = head;
        Node prev = null;
        
        int count = 1;
        while(curr != null) {
            
            if(count == x) {
                // delete the node
                prev.next = curr.next;
                break;
            }
            count++;
            prev = curr;
            curr = curr.next;
        }
    }

    private static void printList() {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        head = new DeleteNodeFromMiddle.Node(10);
        head.next = new DeleteNodeFromMiddle.Node(9);
        head.next.next = new DeleteNodeFromMiddle.Node(8);
        head.next.next.next = new DeleteNodeFromMiddle.Node(7);
        head.next.next.next.next = new DeleteNodeFromMiddle.Node(6);
        head.next.next.next.next.next = new DeleteNodeFromMiddle.Node(5);
        head.next.next.next.next.next.next = new DeleteNodeFromMiddle.Node(4);
        head.next.next.next.next.next.next.next = new DeleteNodeFromMiddle.Node(3);
        head.next.next.next.next.next.next.next.next = new DeleteNodeFromMiddle.Node(2);
        head.next.next.next.next.next.next.next.next.next = new DeleteNodeFromMiddle.Node(1);

        printList();
        // delete 3rd node
        deleteMiddleNode(3);
        printList();
    }
}
