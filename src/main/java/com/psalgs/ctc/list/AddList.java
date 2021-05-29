/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.ctc.list;

/**
 *
 * @author djoshi
 */
public class AddList {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            this.data = d;
            next = null;
        }
    }

    static Node head1, head2;

    private static void printList(Node node) {
        Node curr = node;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private static Node addTwoList(Node first, Node second) {
        Node res = null;
        Node temp = null;
        Node prev = null;
        int carry = 0, sum;
        
        while (first != null || second != null) {

            sum = carry + (first != null ? first.data : 0)
                    + (second != null ? second.data : 0);

            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;

            temp = new Node(sum);

            if (res == null) {
                res = temp;
            } else {
                prev.next = temp;
            }
            
            prev = temp;

            if (first != null) {
                first = first.next;
            }

            if (second != null) {
                second = second.next;
            }

            
        }

        if (carry > 0) {
            temp.next = new Node(carry);
        }

        return res;
    }

    public static void main(String args[]) {
        head1 = new Node(7);
        head1.next = new Node(1);
        head1.next.next = new Node(6);
        printList(head1);

        head2 = new Node(5);
        head2.next = new Node(9);
        head2.next.next = new Node(2);
        printList(head2);

        Node result = addTwoList(head1, head2);
        System.out.println("\n----Result---- ");
        printList(result);
    }
}
