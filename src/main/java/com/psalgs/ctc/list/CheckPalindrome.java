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
 * Implement a function to check if a linked list is a palindrome
 *
 * Reverse and clone existing list compare original list and reversed clone list
 *
 */
public class CheckPalindrome {

    static class Node {

        String data;
        Node next;

        Node(String d) {
            data = d;
            next = null;
        }
    }

    static Node head, headClone;

    private static void printList(Node node) {
        Node curr = node;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private static Node reverseAndClone() {
        Node curr = head;
        Node prev = null;
        Node temp = headClone;

        while (curr != null) {
            temp = new Node(curr.data);
            temp.next = prev;
            prev = temp;

            curr = curr.next;
        }

        headClone = temp;
        return headClone;
    }

    private static boolean checkIfPalindrome(Node node1, Node node2) {

        while (node1 != null || node2 != null) {
            if (node1.data != node2.data) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }

    public static void main(String args[]) {
        head = new Node("a");
        head.next = new Node("b");
        head.next.next = new Node("c");
        head.next.next.next = new Node("b");
        head.next.next.next.next = new Node("a");

        printList(head);
        reverseAndClone();
        printList(headClone);
        
        System.out.println("\nCheck if list is palindrome: " + checkIfPalindrome(head, headClone));
                
    }

}
