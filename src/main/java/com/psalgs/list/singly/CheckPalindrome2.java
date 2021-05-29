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
 * http://www.geeksforgeeks.org/check-linked-list-strings-form-palindrome/
 *
 * Check if a linked list of strings forms a palindrome
 */
public class CheckPalindrome2 {

    static class Node {

        String data;
        Node next;

        Node(String d) {
            data = d;
            next = null;
        }
    }

    static Node head;
    // make sure you init to blank or else it will concat null
    String palindrome = "";

    private void printList() {
        Node curr = head;

        while (curr != null) {
            palindrome += curr.data;
            System.out.print(curr.data);
            curr = curr.next;
        }
        System.out.println();
    }

    private boolean isPalindrome() {
        int len = palindrome.length();

        for (int i = 0; i < len / 2; i++) {
            char c1 = palindrome.charAt(i);
            char c2 = palindrome.charAt(len - i - 1);
            if (c1 != c2) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        CheckPalindrome2 llist = new CheckPalindrome2();
        llist.head = new Node("a");
        llist.head.next = new Node("bc");
        llist.head.next.next = new Node("d");
        llist.head.next.next.next = new Node("dcb");
        llist.head.next.next.next.next = new Node("a");
        llist.printList();
        System.out.println("Is String " + llist.palindrome + " palindrome: " + llist.isPalindrome());
    }
}
