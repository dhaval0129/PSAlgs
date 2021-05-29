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
 * http://www.geeksforgeeks.org/sum-of-two-linked-lists/
 *
 * Input: First List: 5->6->3 // represents number 563 Second List: 8->4->2 //
 * represents number 842 Output Resultant list: 1->4->0->5 // represents number
 * 1405
 *
 */
public class AddTwoList2 {

    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    private void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    Node head1, head2, result;
    Node cur;
    int carry;

    private void push(int val, int list) {
        Node node = new Node(val);

        if (list == 1) {
            node.next = head1;
            head1 = node;
        } else if (list == 2) {
            node.next = head2;
            head2 = node;
        } else {
            node.next = result;
            result = node;
        }
    }

    private int getSize(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    // Adds two linked lists of same size represented by
    // head1 and head2 and returns head of the resultant 
    // linked list. Carry is propagated while returning 
    // from the recursion
    private void addSameSize(Node n, Node m) {
        // Since the function assumes linked lists are of 
        // same size, check any of the two head pointers
        if (n == null) {
            return;
        }

        // Recursively add remaining nodes and get the carry
        addSameSize(n.next, m.next);

        // add digits of current nodes and propagated carry
        int sum = n.data + m.data + carry;
        carry = sum / 10;
        sum = sum % 10;

        // Push this to result list
        push(sum, 3);

    }

    private void propogateCarry(Node head1) {
        if (head1 != cur) {
            propogateCarry(head1.next);
            int sum = carry + head1.data;
            carry = sum / 10;
            sum %= 10;
            push(sum, 3);
        }
    }

    private void addLists() {
        if (head1 == null) {
            result = head1;
            return;
        }

        if (head2 == null) {
            result = head2;
            return;
        }

        int size1 = getSize(head1);
        int size2 = getSize(head2);

        if (size1 == size2) {
            addSameSize(head1, head2);
        } else {
            // First list should always be larger than second list.
            // If not, swap pointers
            if (size1 < size2) {
                Node temp = head1;
                head1 = head2;
                head2 = temp;
            }
            int diff = Math.abs(size1 - size2);

            // move diff. number of nodes in first list
            Node temp = head1;
            while (diff-- >= 0) {
                cur = temp;
                temp = temp.next;
            }

            // get addition of same size lists
            addSameSize(cur, head2);

            // get addition of remaining first list and carry
            propogateCarry(head1);

            // if some carry is still there, add a new node to 
            // the front of the result list. e.g. 999 and 87
            if (carry > 0) {
                push(carry, 3);
            }
        }

    }

    public static void main(String args[]) {
        AddTwoList2 list = new AddTwoList2();
        list.head1 = null;
        list.head2 = null;
        list.result = null;
        list.carry = 0;
        int arr1[] = {9, 9, 9};
        int arr2[] = {1, 8};

        // Create first list as 9->9->9
        for (int i = arr1.length - 1; i >= 0; --i) {
            list.push(arr1[i], 1);
        }

        // Create second list as 1->8
        for (int i = arr2.length - 1; i >= 0; --i) {
            list.push(arr2[i], 2);
        }

        list.addLists();
        list.printList(list.result);
    }

}
