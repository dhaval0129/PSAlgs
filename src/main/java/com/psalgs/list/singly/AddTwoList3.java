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
 * http://www.geeksforgeeks.org/add-1-number-represented-linked-list/
 *
 * Add 1 to a number represented as linked list
 *
 */
public class AddTwoList3 {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node head;

    private void printList() {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private void addOne() {
        // first we will reverse the list
        reverseList();
        // second we add one to reversed list and forward the carry
        add();
        // third we reverse list again
        reverseList();
    }

    private void add() {
        int carry = 0;
        int sum = 0;
        Node curr = head;
        boolean flag = true;

        while (curr != null) {
            if (flag) {
                sum = carry + 1 + curr.data;
                flag = false;
            } else {
                sum = carry + curr.data;
            }
            carry = sum / 10;
            curr.data = sum % 10;
            curr = curr.next;
        }
    }

    private void reverseList() {
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public static void main(String args[]) {
        AddTwoList3 llist = new AddTwoList3();
        llist.head = new Node(1);
        llist.head.next = new Node(9);
        llist.head.next.next = new Node(9);
        llist.head.next.next.next = new Node(9);
        llist.printList();
        llist.addOne();
        llist.printList();

    }
}
