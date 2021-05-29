/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.prog;

/**
 * https://www.geeksforgeeks.org/recursive-program-to-generate-power-set/
 * 
 * @author djoshi
 */
public class GenerateSubSet {

    private static void powerSet(String str, int index, String curr) {
        int n = str.length();

        // base cases;
        if (index == n) {
            System.out.println(curr);
            return;
        }

        powerSet(str, index + 1, curr + str.charAt(index));
        powerSet(str, index + 1, curr);
    }

    public static void main(String args[]) {
        String str = "abc";
        int index = 0;
        String curr = "";
        powerSet(str, index, curr);
    }

}

//
//  1]  abc, 1, a  x
//      abc, 1, "" x
//
//  2]  abc, 2, ab x
//      abc, 2, a  x
//
//  3]  abc, 3, abc x
//      abc, 3, ab  x
//
//      print abc
//      print ab
//
//  4]  abc, 3, ac  x
//      abc, 3, a   x
//
//      print ac
//      print a
//
//  5]  abc, 2, b  x
//      abc, 2, "" x
//
//  6]  abc, 3, bc x
//      abc, 3, b  x
//
//      print bc
//      print b
//
//  7]  abc, 3, c  x
//      abc, 3, "" x
//
//      print c
//      print ""
//

