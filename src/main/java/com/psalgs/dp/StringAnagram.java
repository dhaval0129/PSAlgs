/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp;

/**
 *
 * @author djoshi
 */
public class StringAnagram {
    
    public static int numberNeeded(String first, String second) {
        int[] count = new int[26];
        int sum =0;
        
        char[] charArray = first.toCharArray();  
        
        for(int i=0; i<charArray.length; i++) {
            count[charArray[i] - 'a']++;
        }
        
        charArray = second.toCharArray();
        for(int j=0; j<charArray.length; j++) {
                count[charArray[j]-'a']--;
        }
        
        for(int k=0; k<count.length; k++) {
            sum+= Math.abs(count[k]);    
        }
        
        return sum;
    }
  
    public static void main(String[] args) {
        String a = "imkhnpqnhlvaxlmrsskbyyrhwfvgteubrelgubvdmrdmesfxkpykprunzpustowmvhupkqsyjxmnptkcilmzcinbzjwvxshubeln";
        String b = "wfnfdassvfugqjfuruwrdumdmvxpbjcxorettxmpcivurcolxmeagsdundjronoehtyaskpwumqmpgzmtdmbvsykxhblxspgnpgfzydukvizbhlwmaajuytrhxeepvmcltjmroibjsdkbqjnqjwmhsfopjvehhiuctgthrxqjaclqnyjwxxfpdueorkvaspdnywupvmy";
        System.out.println(numberNeeded(a, b));
    } 
}
