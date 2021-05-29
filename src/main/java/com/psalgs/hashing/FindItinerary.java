/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/find-itinerary-from-a-given-list-of-tickets/
 *
 * Find Itinerary from a given list of tickets
 *
 */
public class FindItinerary {

    private static void printResult(Map<String, String> dataSet) {
        // To store reverse of given map
        Map<String, String> reverseMap = new HashMap<>();

        // To fill reverse map, iterate through the given map
        // here we reverse the value to key and key to value for reverseMap
        for (Map.Entry<String, String> entry : dataSet.entrySet()) {
            reverseMap.put(entry.getValue(), entry.getKey());
        }

        // Find the starting point of itinerary
        String start = null;
        for (Map.Entry<String, String> entry : dataSet.entrySet()) {
            if (!reverseMap.containsKey(entry.getKey())) {
                start = entry.getKey();
                break;
            }
        }

        // If we could not find a starting point, then something wrong with input
        if(start == null) {
            System.out.println("Invalid Input");
            return;
        }
        
        // Once we have starting point, we simply need to go to next, next of next using hash map
        String to = dataSet.get(start);
        while(to != null) {
            System.out.print(start + "->" + to + ",");
            start = to;
            to = dataSet.get(to);
        }
        System.out.println();
        
    }

    public static void main(String args[]) {
        Map<String, String> dataSet = new HashMap<>();
        dataSet.put("Chennai", "Banglore");
        dataSet.put("Bombay", "Delhi");
        dataSet.put("Goa", "Chennai");
        dataSet.put("Delhi", "Goa");

        printResult(dataSet);
    }
}
