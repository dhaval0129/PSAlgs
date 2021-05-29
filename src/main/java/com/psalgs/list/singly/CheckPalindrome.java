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
 * http://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
 *
 */
public class CheckPalindrome {

    class Node {

        char data;
        Node next;

        Node(char c) {
            data = c;
            next = null;
        }
    }

    Node head;  // head of list
    Node slow_ptr, fast_ptr; 
    Node second_half;

    private boolean isPalindrome(Node head) {
        slow_ptr = head;
        fast_ptr = head;
        Node prev_slow_ptr = head;
        Node midNode = null;
        boolean result = true;

        if (head != null && head.next != null) {
            /* Get the middle of the list. Move slow_ptr by 1
               and fast_ptrr by 2, slow_ptr will have the middle
               node */
            while (fast_ptr != null && fast_ptr.next != null) {
                fast_ptr = fast_ptr.next.next;
                /*We need previous of the slow_ptr for
                  linked lists  with odd elements */
                prev_slow_ptr = slow_ptr;
                slow_ptr = slow_ptr.next;
            }

            /* 
               fast_ptr would become NULL when there are even elements 
               in the list and not NULL for odd elements. 
               We need to skip the middle node for odd case and 
               store it somewhere so that we can restore the original list 
             */
            if (fast_ptr != null) {
                midNode = slow_ptr;
                slow_ptr = slow_ptr.next;
            }

            // Now reverse the second half and compare it with first half
            second_half = slow_ptr;
            prev_slow_ptr.next = null; // NULL terminate first half
            reverse(); // reverse the second half
            result = compareLists(head, second_half);

            /* Construct the original list back */
            reverse(); // Reverse the second half again

            if (midNode != null) {
                // If there was a mid node (odd size case) which                                                         
                // was not part of either first half or second half.
                prev_slow_ptr.next = midNode;
                midNode.next = second_half;
            } else {
                prev_slow_ptr.next = second_half;
            }

        }

        return result;
    }

    /* Function to reverse the linked list  Note that this
       function may change the head */
    private void reverse() {
        Node prev = null;
        Node current = second_half;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        second_half = prev;
    }

    private boolean compareLists(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.data == temp2.data) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else {
                return false;
            }
        }

        /* Both are empty reurn 1*/
        if (temp1 == null && temp2 == null) {
            return true;
        }

        return false;
    }

    private void push(char data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
    }

    private void printList(Node temp) {

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String args[]) {
        CheckPalindrome llist = new CheckPalindrome();
        char str[] = {'a', 'b', 'a', 'c', 'a', 'b', 'a'};

        for (int i = 0; i < str.length; i++) {
            llist.push(str[i]);
            llist.printList(llist.head);
            if (llist.isPalindrome(llist.head) != false) {
                System.out.println("Is Palindrome");
                System.out.println("");
            } else {
                System.out.println("Not Palindrome");
                System.out.println("");
            }
        }
    }

}
