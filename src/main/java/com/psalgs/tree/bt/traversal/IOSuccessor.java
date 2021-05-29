/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bt.traversal;

/**
 *
 * @author djoshi
 */
public class IOSuccessor {
    
    static class tNode {
        
        int data;
        tNode left, right, next;
        
        tNode(int d) {
            data = d;
            left = right = next = null;
        }
    }
    
    tNode root; 
    static tNode next = null; 
    
    private void populateNext(tNode node)  { 
        // The first visited node will be the rightmost node 
        // next of the rightmost node will be NULL 
        if (node != null)  
        { 
            // First set the next pointer in right subtree 
            populateNext(node.right); 
   
            // Set the next as previously visited node in reverse Inorder 
            node.next = next; 
   
            // Change the prev for subsequent node 
            next = node; 
   
            // Finally, set the next pointer in left subtree 
            populateNext(node.left); 
        } 
    } 
    
    public static void main(String args[]) {
        /* Constructed binary tree is 
            10 
           /   \ 
          8      12 
         / 
        3    
        */
        IOSuccessor tree = new IOSuccessor(); 
        tree.root = new tNode(10); 
        tree.root.left = new tNode(8); 
        tree.root.right = new tNode(12); 
        tree.root.left.left = new tNode(3); 
   
        // Populates nextRight pointer in all nodes 
        tree.populateNext(tree.root); 
   
        // Let us see the populated values 
        tNode ptr = tree.root.left.left; 
        while (ptr != null)  
        { 
            // -1 is printed if there is no successor 
            int print = ptr.next != null ? ptr.next.data : -1; 
            System.out.println("Next of " + ptr.data + " is: " + print); 
            ptr = ptr.next; 
        } 
    }
}
