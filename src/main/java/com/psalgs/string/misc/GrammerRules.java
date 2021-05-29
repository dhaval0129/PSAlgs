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
 * http://www.geeksforgeeks.org/check-given-sentence-given-set-simple-grammer-rules/
 *
 * Check a given sentence for a given set of simple Grammer rules
 *
 * Time Complexity O(n)
 */
public class GrammerRules {

    private static boolean checkSentence(String str) {
        int len = str.length();

        if (str.charAt(0) < 'A' || str.charAt(0) > 'Z') {
            return false;
        }

        if (str.charAt(len - 1) != '.') {
            return false;
        }

        int prev_state = 0;
        int curr_state = 0;
        int index = 1;

        while (index < len) {
            // Set states according to the input characters in the
            // string and the rule defined in the description.
            // If current character is [A-Z]. Set current state as 0.
            if (str.charAt(index) >= 'A' && str.charAt(index) <= 'Z') {
                curr_state = 0;
            } else if (str.charAt(index) == ' ') {
                curr_state = 1;
            } else if (str.charAt(index) >= 'a' && str.charAt(index) <= 'z') {
                curr_state = 2;
            } else if (str.charAt(index) == '.') {
                curr_state = 3;
            }

            // Validates all current state with previous state for the 
            // rules in the description of the problem.
            if (prev_state == curr_state && curr_state != 2) {
                return false;
            }

            if (prev_state == 2 && curr_state == 0) {
                return false;
            }

            // If we have reached last state and previous state is not 1, 
            // then check next character. If next character is '\0', then 
            // return true, else false
            if (curr_state == 3 && prev_state != 1) {
                return (index == len - 1);
            }

            index++;
            prev_state = curr_state;
        }
        return false;
    }

    public static void main(String args[]) {
        String str[] = {"I love cinema.", "The vertex is S.",
            "I am single.", "My name is KG.",
            "I lovE cinema.", "GeeksQuiz. is a quiz site.",
            "I love Geeksquiz and Geeksforgeeks.",
            "  You are my friend.", "I love cinema"};
        int size = str.length;

        for (int i = 0; i < size; i++) {
            String status = checkSentence(str[i]) ? "True" : "False";
            System.out.println(str[i] + " " + status);
        }

    }
}
