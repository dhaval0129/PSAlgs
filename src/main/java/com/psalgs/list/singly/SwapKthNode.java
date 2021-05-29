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
 * http://www.geeksforgeeks.org/swap-kth-node-from-beginning-with-kth-node-from-end-in-a-linked-list/
 *
 * Swap Kth node from beginning with Kth node from end in a Linked List
 */
public class SwapKthNode {

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;
    static int len;

    private int getCount() {
        int count = 1;
        Node curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        return count;
    }

    private void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private void swapKth(int k) {
        int swap = len - k - 1;
        int count = 1;
        Node curr = head;
        
        Node prev1 = null;
        Node prev2 = null;
        Node prev = null;
        Node swap1 = null;
        Node swap2 = null;
        
        while(curr != null) {
            
            if(count == k) {
                prev1 = prev;
                swap1 = curr;
            }
            
            if(count == swap) {
                prev2 = prev;
                swap2 = curr;
            }
            count++;
            prev = curr;
            curr = curr.next;
        }
        
        // swap the nodes;
        Node next1 = swap1.next;
        Node next2 = swap2.next;
        prev1.next = swap2;
        swap2.next = next1;
        prev2.next = swap1;
        swap1.next = next2;
        
    }

    public static void main(String args[]) {
        SwapKthNode llist = new SwapKthNode();
        llist.head = new Node(1);
        llist.head.next = new Node(2);
        llist.head.next.next = new Node(3);
        llist.head.next.next.next = new Node(4);
        llist.head.next.next.next.next = new Node(5);
        llist.head.next.next.next.next.next = new Node(6);
        llist.head.next.next.next.next.next.next = new Node(7);
        llist.head.next.next.next.next.next.next.next = new Node(8);
        llist.printList();
        len = llist.getCount();
        llist.swapKth(2);
//        for (int i = 1; i <= len; i++) {
//            llist.swapKth(i);
//        }
        llist.printList();
    }

}
