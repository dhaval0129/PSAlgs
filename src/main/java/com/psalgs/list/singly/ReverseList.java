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
 * Reference:
 * http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/
 *
 * https://www.youtube.com/watch?v=jY-EUKXYT20
 */
public class ReverseList {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node head;

    // Function to reverse the linked list
    // Iterative solution 
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;

        while (current != null) {
            // move next pointer to next node
            next = current.next;
            // point current node to previous
            current.next = prev;
            // make current node as previous
            prev = current;
            // make current node as next node
            // move ahead or increment to next node
            current = next;
        }
        node = prev;
        return node;
    }

    // Function to reverse linked list, prev is passed as NULL initially.
    // Recursive solution
    private Node reverseUtil(Node curr, Node prev) {

        /* If last node mark it as head */
        if (curr.next == null) {
            head = curr;
            /* Update next to prev node */
            curr.next = prev;
            return null;
        }

        /* Save curr->next node for recursive call */
        Node next = curr.next;

        /* and update next ..*/
        curr.next = prev;

        reverseUtil(next, curr);
        return head;
    }

    // prints content of double linked list
    private void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        ReverseList list = new ReverseList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);
        list.head.next.next.next.next.next.next.next = new Node(8);

        System.out.println("Given Linked list");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("Reverse linked list (Iterative Solution) ");
        list.printList(head);
        System.out.println("Reverse linked list (Recrusive Solution) ");
        Node res = list.reverseUtil(head, null);
        list.printList(res);
    }
}
