/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.bst;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/floor-and-ceil-from-a-bst/
 *
 * Floor or Ceil in a BST
 *
 * Ceil Value Node: Node with smallest data larger than or equal to key value.
 * 
 * Floor Value Node: Node with largest data smaller than or equal to key value.
 *
 */
public class FindCeilFloor {

    static class tNode {

        int data;
        tNode left, right;

        tNode(int d) {
            data = d;
            left = right = null;
        }
    }

    static tNode root;

    private int Ceil(tNode node, int input) {
        // base case
        if (node == null) {
            return -1;
        }

        // We found equal key
        if (node.data == input) {
            return node.data;
        }

        // If root's key is smaller, ceil must be in right subtree
        // or you can also do (input < node.data )
        if (node.data < input) {
            return Ceil(node.right, input);
        }

        int ceil = Ceil(node.left, input);
        return (ceil >= input) ? ceil : node.data;
    }
    
    private int Floor(tNode node, int input) {
        if(node == null) {
            return -1;
        }
        
        if(node.data == input) {
            return node.data;
        }
        
        if(node.data > input) {
            return Floor(node.left, input);
        }
        
        int floor = Floor(node.right, input);
        return (floor <= input) ? node.data: floor;
    }

    public static void main(String args[]) {
        FindCeilFloor tree = new FindCeilFloor();
        root = new tNode(8);
        root.left = new tNode(4);
        root.right = new tNode(12);
        root.left.left = new tNode(2);
        root.left.right = new tNode(6);
        root.right.left = new tNode(10);
        root.right.right = new tNode(14);

        for (int i = 0; i < 16; i++) {
            System.out.println(i + " Ceil " + tree.Ceil(root, i) + " Floor "+tree.Floor(root, i));
        }
    }

}
