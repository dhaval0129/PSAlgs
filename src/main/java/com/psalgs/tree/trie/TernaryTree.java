/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.tree.trie;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/ternary-search-tree/
 *
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/suffixprefix/TernaryTree.java
 *
 */
public class TernaryTree {

    class Node {
        char data;
        boolean isLeaf;
        Node left, right, eq;
    }

    Node root = null;

    private void insert(String data) {
        Node node = insert(this.root, data, 0);
        this.root = node;
    }

    private Node insert(Node node, String data, int pos) {
        if (pos == data.length()) {
            return node;
        }

        if (node == null) {
            node = new Node();
            node.data = data.charAt(pos);
            node.eq = insert(node.eq, data, pos + 1);
            if (pos == (data.length() - 1)) {
                node.isLeaf = true;
            }
        } else {
            if (node.data == data.charAt(pos)) {
                node.eq = insert(node.eq, data, pos + 1);
                if (pos == (data.length() - 1)) {
                    node.isLeaf = true;
                }
            } else if (node.data < data.charAt(pos)) {
                node.right = insert(node.right, data, pos);
            } else {
                node.left = insert(node.left, data, pos);
            }
        }
        return node;
    }

    private boolean search(String data) {
        return search(root, data, 0);
    }

    private boolean search(Node node, String data, int pos) {
        if(pos == data.length()){
            return true;
        }
        
        if(node == null){
            return false;
        }
        
        if(node.data == data.charAt(pos)){
            boolean result = search(node.eq, data, pos + 1);
            if(pos == data.length() - 1){
                return result && node.isLeaf;
            }
            return result;
        } else if(node.data < data.charAt(pos)){
            return search(node.right,data,pos);
        } else {
            return search(node.left,data,pos);
        }            
    }

    public static void main(String args[]) {
        TernaryTree tt = new TernaryTree();
        tt.insert("cute");
        tt.insert("as");
        tt.insert("at");
        tt.insert("cut");
        tt.insert("cup");
        tt.insert("time");
        tt.insert("tax");
        tt.insert("bat");
        System.out.println(tt.search("cute"));
        System.out.println(tt.search("cut"));
        System.out.println(tt.search("tax"));
        System.out.println(tt.search("as"));
        System.out.println(tt.search("abat"));
    }
}
