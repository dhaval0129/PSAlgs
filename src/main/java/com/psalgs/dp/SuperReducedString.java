/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp;

import java.util.Stack;



/**
 *
 * @author djoshi
 */
public class SuperReducedString {
    
    public static void main(String[] args) {
        String s = "aa";
        Stack<String> stack = new Stack<String>();
        
        for(int i=0; i<s.length(); i++) {
            String ch = "" + s.charAt(i);
            
            if(stack.empty()|| stack.size() == 0) {
                stack.push(ch);
            } else {
                String last = stack.pop();
                String next = ""+s.charAt(i);
                
                if(!(next.equals(last))) {
                    stack.push(last);
                    stack.push(next);
                }
            }
        }
        
        if(stack.empty()){
            System.out.println("Empty String");
        } else {
            String temp="";
            for(int j=0; j<stack.size(); j++) {
                temp = temp + stack.get(j);
            }
            
            System.out.println(temp);
        }
    }
}
