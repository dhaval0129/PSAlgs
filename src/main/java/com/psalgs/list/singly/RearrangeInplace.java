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
 * http://www.geeksforgeeks.org/rearrange-a-given-linked-list-in-place/
 *
 * 1) Find the middle point using tortoise and hare method. 2) Split the linked
 * list in two halves using found middle point in step 1. 3) Reverse the second
 * half. 4) Do alternate merge of first and second halves.
 *
 */
public class RearrangeInplace {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node head;

    private void printlist(Node node) {
        if (node == null) {
            return;
        }
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }

    private Node reverseList(Node node) {
        Node curr = node;
        Node prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }

    private void rearrangeList(Node node) {
        // 1) Find the middle point using tortoise and hare method 
        Node slow = node, fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2) Split the linked list in two halves
        // node1, head of first half    1 -> 2 -> 3
        // node2, head of second half   4 -> 5
        Node node1 = node;
        Node node2 = slow.next;
        slow.next = null;

        // 3) Reverse the second half, i.e., 5 -> 4
        node2 = reverseList(node2);

        // 4) Merge alternate nodes
        Node curr = new Node(0);
        while (node1 != null || node2 != null) {
            // First add the element from first list
            if (node1 != null) {
                curr.next = node1;
                curr = curr.next;
                node1 = node1.next;
            }

            if (node2 != null) {
                curr.next = node2;
                curr = curr.next;
                node2 = node2.next;
            }
        }
        node = node.next;
    }

    public static void main(String args[]) {
        RearrangeInplace list = new RearrangeInplace();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        list.printlist(head); // print original list
        list.rearrangeList(head); // rearrange list as per ques
        System.out.println("");
        list.printlist(head); // print modified lis
    }
}
