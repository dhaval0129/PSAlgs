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
 * Detect loop in a linked list
 * 
 * https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
 * 
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 * 
 */
public class LoopDetection {

    static class Node {

        char data;
        Node next;

        Node(char d) {
            data = d;
            next = null;
        }
    }

    static Node head;

    private static void printList() {
        Node curr = head;

        while (curr != null) {
            System.out.println(curr.data + " ");
            curr = curr.next;
        }
    }

    private static boolean loopDectection() {
        Node fast = head, slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                System.out.println("Cycle exists in singly list");
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        head = new Node('A');
        head.next = new Node('B');
        head.next.next = new Node('C');
        head.next.next.next = new Node('D');
        head.next.next.next.next = new Node('E');

        // connect E to C
        head.next.next.next.next.next = head.next.next;

        //printList();
        loopDectection();

    }

}
