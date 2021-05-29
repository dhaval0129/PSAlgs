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
 * http://www.geeksforgeeks.org/flatten-a-linked-list-with-next-and-child-pointers/
 * 
 * Flatten a multilevel linked list
 * 
 */
public class FlattenMultilevel {

    static Node head;

    class Node {

        int data;
        Node next, child;

        Node(int d) {
            data = d;
            next = child = null;
        }
    }

    // A utility function to create a linked list with n nodes. The data
    // of nodes is taken from arr[].  All child pointers are set as NULL
    private Node createList(int arr[]) {
        Node node = null;
        Node p = null;

        int n = arr.length;

        for (int i = 0; i < n; ++i) {
            if (node == null) {
                node = p = new Node(arr[i]);
            } else {
                p.next = new Node(arr[i]);
                p = p.next;
            }
            p.next = p.child = null;
        }
        return node;
    }

    private Node createList() {
        int arr1[] = new int[]{10, 5, 12, 7, 11};
        int arr2[] = new int[]{4, 20, 13};
        int arr3[] = new int[]{17, 6};
        int arr4[] = new int[]{9, 8};
        int arr5[] = new int[]{19, 15};
        int arr6[] = new int[]{2};
        int arr7[] = new int[]{16};
        int arr8[] = new int[]{3};

        /* create 8 linked lists */
        Node head1 = createList(arr1);
        Node head2 = createList(arr2);
        Node head3 = createList(arr3);
        Node head4 = createList(arr4);
        Node head5 = createList(arr5);
        Node head6 = createList(arr6);
        Node head7 = createList(arr7);
        Node head8 = createList(arr8);

        /* modify child pointers to create the list shown above */
        head1.child = head2;
        head1.next.next.next.child = head3;
        head3.child = head4;
        head4.child = head5;
        head2.next.child = head6;
        head2.next.next.child = head7;
        head7.child = head8;

        /* Return head pointer of first linked list.  Note that all nodes are
         reachable from head1 */
        return head1;
    }

    private void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    /* The main function that flattens a multilevel linked list */
    private void flattenList(Node node) {
        if (node == null) {
            return;
        }

        Node tail = node;

        while (tail.next != null) {
            tail = tail.next;
        }
        
        Node curr = node;
        Node tmp;
        
        while(curr != null) {
            
            if(curr.child != null) {
                tail.next = curr.child;
                tmp = curr.child;
                
                while( tmp.next != null) {
                    tmp = tmp.next;
                }
                tail = tmp;
            }
            
            curr = curr.next;
        }

    }

    public static void main(String[] args) {
        FlattenMultilevel list = new FlattenMultilevel();
        head = list.createList();
        list.flattenList(head);
        list.printList(head);
    }

}
