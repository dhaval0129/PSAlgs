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
 *
 * http://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
 *
 * http://www.programcreek.com/2012/12/leetcode-merge-two-sorted-lists-java/
 *
 * http://algorithms.tutorialhorizon.com/merge-or-combine-two-sorted-linked-lists/
 *
 * Merge tow sorted linked lists
 */
public class MergeList {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    private void addToFront(int d) {
        Node n = new Node(d);
        n.next = head;
        head = n;
    }

    private void addAtEnd(int d) {
        Node n = new Node(d);
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = n;
    }

    private static Node addAtEnd(int d, Node node) {
        Node n = new Node(d);
        Node temp = node;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = n;
        return temp;
    }

    private void addAtMiddle(int d) {
        Node n = new Node(d);
        Node temp = head;
        Node prev = null;

        while (temp.data <= d) {
            prev = temp;
            temp = temp.next;
        }

        n.next = temp;
        prev.next = n;
    }

    private void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private Node mergeList_Rec(Node one, Node two) {
        if (one == null) {
            return two;
        }

        if (two == null) {;
            return one;
        }

        if (one.data < two.data) {
            one.next = mergeList_Rec(one.next, two);
            return one;
        } else {
            two.next = mergeList_Rec(one, two.next);
            return two;
        }
    }

    private Node mergeList_Itr(Node one, Node two) {
        if (one == null) {
            return one;
        }

        if (two == null) {
            return two;
        }

        Node list = null;

        while (one != null && two != null) {
            int data;
            if (one.data <= two.data) {
//                System.out.print(one.data + " ");
                data = one.data;
                one = one.next;
            } else {
//                System.out.print(two.data);
                data = two.data;
                two = two.next;
            }

            if (list == null) {
                list = new Node(data);
            } else {
                addAtEnd(data, list);
            }
//            System.out.println("=" + list.data);
        }

        while (one != null) {
            addAtEnd(one.data, list);
            one = one.next;
        }

        while (two != null) {
            addAtEnd(two.data, list);
            two = two.next;
        }
        return list;
    }

    public static void main(String args[]) {
        MergeList one = new MergeList();
        MergeList two = new MergeList();
        one.addToFront(7);
        one.addToFront(3);
        one.addToFront(1);
        two.addToFront(6);
        two.addToFront(4);
        two.addToFront(2);
        two.addAtEnd(9);
        one.addAtMiddle(5);
        one.printList(one.head);
        two.printList(two.head);
//        System.out.println("Merged List through recursion ");
//        Node result1 = one.mergeList_Rec(one.head, two.head);
//        one.printList(result1);
        System.out.println("Merged List through Iteration ");
        Node result2 = one.mergeList_Itr(one.head, two.head);
        one.printList(result2);
    }

}
