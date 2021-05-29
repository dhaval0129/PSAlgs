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
 * ( Naive Approach )
 * 
 * Time Complexity O (n ^ 2)
 */
public class RemoveDuplicateUnsorted2 {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node head;

    private static Node removeDuplicates(Node curr) {
        Node newHead = null;
        Node first = null;

        while (curr != null) {

            int d = curr.data;
            boolean flag = false;

            Node prev = null;

            if (newHead == null) {
                newHead = new Node(d);
                first = newHead;
                flag = true;
            } else {
                while (newHead != null) {

                    if (newHead.data == d) {
                        flag = true;
                        break;
                    }

                    prev = newHead;
                    newHead = newHead.next;
                }
            }

            if (!flag) {
                Node node = new Node(d);
                prev.next = node;
                newHead = prev;
            }

            flag = false;
            newHead = first;
            curr = curr.next;
        }

        return newHead;
    }

    private static void printList(Node head) {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println("NULL");
    }

    public static void main(String args[]) {
        RemoveDuplicateUnsorted llist = new RemoveDuplicateUnsorted();
        head = new Node(2);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(2);

        System.out.print("Original List : ");
        printList(head);
        System.out.print("Updated List: ");
        Node x = removeDuplicates(head);
        printList(x);
    }

}
