/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.misc;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/
 *
 * Check if a binary tree is subtree of another binary tree
 * 
 * Note: Check with either in-order or pre-order traversal
 *
 */
public class Subtree2 {

    static class tNode {

        char data;
        tNode left;
        tNode right;

        tNode(char d) {
            data = d;
            left = right = null;
        }
    }

    class Passing {

        int i;
        int m = 0;
        int n = 0;
    }

    static tNode root;
    Passing p = new Passing();

    // A utility function to store inorder traversal of tree rooted
    // with root in an array arr[]. Note that i is passed as reference
    private void storeInorder(tNode node, char arr[], Passing i) {
        if (node == null) {
//            arr[i.i++] = '$';
            return;
        }
        storeInorder(node.left, arr, i);
        arr[i.i++] = node.data;
        storeInorder(node.right, arr, i);
    }

    // A utility function to store preorder traversal of tree rooted
    // with root in an array arr[]. Note that i is passed as reference
    private void storePreOrder(tNode node, char arr[], Passing i) {
        if (node == null) {
//            arr[i.i++] = '$';
            return;
        }
        arr[i.i++] = node.data;
        storePreOrder(node.left, arr, i);
        storePreOrder(node.right, arr, i);
    }

    private boolean isSubtree(tNode T, tNode S) {
        /* base cases */
        if (S == null) {
            return true;
        }
        if (T == null) {
            return false;
        }

        // Store Inorder traversals of T and S in inT[0..m-1]
        // and inS[0..n-1] respectively
        char inT[] = new char[100];
        char inS[] = new char[100];
        storeInorder(T, inT, p);
        p.m = p.i;
        p.i = 0;
        storeInorder(S, inS, p);
        p.n = p.i;
        p.i = 0;
        
        String op1 = String.valueOf(inT);
        String op2 = String.valueOf(inS);

        // If inS[] is not a substring of inT[], return false
        if (!strstr(op1.trim(), op2.trim())) {
            return false;
        }

        // Store Preorder traversals of T and S in inT[0..m-1]
        // and inS[0..n-1] respectively
        // Re-init to 0 after last traversal
        p.m = 0;
        p.n = 0;
        char preT[] = new char[100];
        char preS[] = new char[100];
        
        storePreOrder(T, preT, p);
        p.m = p.i;
        p.i = 0;
        storePreOrder(S, preS, p);
        p.n = p.i;
        p.i = 0;
        
        String op3 = String.valueOf(preT);
        String op4 = String.valueOf(preS);

        // If inS[] is not a substring of preS[], return false
        // Else return true
        return (strstr(op3.trim(), op4.trim()));
    }

    private boolean strstr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return false;
        }

        int hLength = haystack.length();
        int nLength = needle.length();

        if (hLength < nLength) {
            return false;
        }

        if (nLength == 0) {
            return false;
        }
        
        return haystack.contains(needle);
        
//        for (int i = 0; i < hLength; i++) {
//            if (haystack.charAt(i) == needle.charAt(0)) {
//                for (int j=0; j < nLength && i < hLength; j++,i++) {
//                    if (haystack.charAt(i) != needle.charAt(j)) {
//                        return false;
//                    }
//                }
//            }
//        }
//
//        return true;
    }

    public static void main(String args[]) {
        Subtree2 tree = new Subtree2();
        tNode T = new tNode('a');
        T.left = new tNode('b');
        T.right = new tNode('d');
        T.left.left = new tNode('c');
        T.right.right = new tNode('e');

        tNode S = new tNode('a');
        S.left = new tNode('b');
        S.right = new tNode('d');
        S.left.left = new tNode('c');

        if (tree.isSubtree(T, S)) {
            System.out.println("Yes , S is a subtree of T");
        } else {
            System.out.println("No, S is not a subtree of T");
        }
    }
}
