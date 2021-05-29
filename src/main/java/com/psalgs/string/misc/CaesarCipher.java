/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.string.misc;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/caesar-cipher/
 *
 * Caesar Cipher - one of the earliest and simplest method of encryption
 * technique
 *
 */
public class CaesarCipher {

    private static String encrypt(String text, int s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int x = c + s;
            c = (char) x;
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String args[]) {
//        String text = "ATTACKATONCE";
        String text ="attackatonce";
        int s = 4;
        System.out.println("Text  : " + text);
        System.out.println("Shift : " + s);
        System.out.println("Cipher: " + encrypt(text, s));
    }
}
