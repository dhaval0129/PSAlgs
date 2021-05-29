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
public class DeleteMidPoints {

    class Node {

        int x, y;
        Node next;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
            next = null;
        }

    }

    Node head;

    private void push(int x, int y) {
        Node n = new Node(x, y);
        n.next = head;
        head = n;
    }

    private void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print("(" + temp.x + "," + temp.y + ")->");
            temp = temp.next;
        }
        System.out.println();
    }

    private void deleteMidPoints() {
        Node current = head;
        Node prev = null;

        while (current != null && current.next != null) {
            Node next = current.next;

            if ((current.y == next.y) || (current.x == next.x)) {
                // delete the next node
                current.next = next.next;
            }
            current = current.next;
        }
    }

    public static void main(String args[]) {
        DeleteMidPoints llist = new DeleteMidPoints();
        llist.push(40, 5);
        llist.push(20, 5);
        llist.push(10, 5);
        llist.push(10, 8);
        llist.push(10, 10);
        llist.push(3, 10);
        llist.push(1, 10);
        llist.push(0, 10);

        System.out.println("Given list");
        llist.printList();
        llist.deleteMidPoints();
        System.out.println("Modified Linked List is");
        llist.printList();
    }

}
