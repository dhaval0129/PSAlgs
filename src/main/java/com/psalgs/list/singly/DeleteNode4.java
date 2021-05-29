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
 * http://www.geeksforgeeks.org/delete-n-nodes-after-m-nodes-of-a-linked-list/
 *
 * Delete N nodes after M nodes of a linked list
 *
 * Input: M = 2, N = 2 
 * Linked List: 1->2->3->4->5->6->7->8 
 * Output: Linked List: 1->2->5->6
 *
 */
public class DeleteNode4 {

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
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    private void deleteNode(int m, int n) {
        Node current = head;
        Node prev = null;

        while (current != null) {

            for (int i = 0; i < m && current != null; i++) {
                prev = current;
                current = current.next;
            }

            for (int i = 0; i < n && current != null; i++) {
                // delete the node
                Node next = current.next;
                prev.next = next;
                current = next;
            }
        }
    }

    public static void main(String args[]) {
        DeleteNode4 llist = new DeleteNode4();
        llist.push(10);
        llist.push(9);
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
        llist.printList();

        int m = 2, n = 2;
        llist.deleteNode(m, n);

        llist.printList();
    }
}
