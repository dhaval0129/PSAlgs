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
 * http://www.geeksforgeeks.org/find-a-triplet-from-three-linked-lists-with-sum-equal-to-a-given-number/
 *
 * Find a triplet from three linked lists with sum equal to a given number
 *
 */
public class Triplet {

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

    /* A function to chech if there are three elements in a, b
      and c whose sum is equal to givenNumber.  The function
      assumes that the list b is sorted in ascending order and
      c is sorted in descending order. */
    boolean isSumSorted(Triplet la, Triplet lb, Triplet lc,
            int givenNumber) {
        Node a = la.head;

        // Traverse all nodes of la
        while (a != null) {
            Node b = lb.head;
            Node c = lc.head;

            // for every node in la pick 2 nodes from lb and lc
            while (b != null && c != null) {
                int sum = a.data + b.data + c.data;
                if (sum == givenNumber) {
                    System.out.println("Triplet found " + a.data + " " + b.data + " " + c.data);
                    return true;
                } else if (sum < givenNumber) {
                    // If sum is smaller then look for greater value of b
                    b = b.next;
                } else {
                    c = c.next;
                }
            }
            a = a.next;
        }
        System.out.println("No Triplet found");
        return false;
    }

    public static void main(String args[]) {
        Triplet llist1 = new Triplet();
        Triplet llist2 = new Triplet();
        Triplet llist3 = new Triplet();

        /* Create Linked List llist1 100->15->5->20 */
        llist1.push(20);
        llist1.push(5);
        llist1.push(15);
        llist1.push(100);

        /*create a sorted linked list 'b' 2->4->9->10 */
        llist2.push(10);
        llist2.push(9);
        llist2.push(4);
        llist2.push(2);

        /*create another sorted linked list 'c' 8->4->2->1 */
        llist3.push(1);
        llist3.push(2);
        llist3.push(4);
        llist3.push(8);

        int givenNumber = 25;
        llist1.isSumSorted(llist1, llist2, llist3, givenNumber);
    }

}
