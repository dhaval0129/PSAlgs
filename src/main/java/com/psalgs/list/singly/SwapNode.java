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
 * Swap nodes in a linked list without swapping data
 *
 * Reference:
 * http://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
 *
 * Input: 10->15->12->13->20->14, x = 12, y = 20 Output: 10->15->20->13->12->14
 *
 */
public class SwapNode {

    Node head;

    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    private void swapNodes(int x, int y) {
        // Nothing to do if x and y are same
        if (x == y) {
            return;
        }

        // Search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y is not present, nothing to do
        if (currX == null || currY == null) {
            return;
        }

        // If x is not head of linked list
        if (prevX != null) {
            prevX.next = currY;
        } else { //make y the new head
            head = currY;
        }
        
        // If y is not head of linked list
        if (prevY != null) {
            prevY.next = currX;
        } else {// make x the new head
            head = currX;
        }
        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    private void push(int d) {
        Node node = new Node(d);
        node.next = head;
        head = node;
    }

    private void printList() {
        Node node = head;

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        SwapNode llist = new SwapNode();
        /* The constructed linked list is:
         1->2->3->4->5->6->7 */
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.print("\n Linked list before calling swapNodes() ");
        llist.printList();

        llist.swapNodes(4, 3);

        System.out.print("\n Linked list after calling swapNodes()  ");
        llist.printList();
    }

}
