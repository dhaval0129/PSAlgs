/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.queue;

/**
 *
 * @author djoshi
 * 
 * http://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
 * 
 * Find the first circular tour that visits all petrol pumps
 * 
 */
public class PetrolPumpTour {

    // A petrol pump has petrol and distance to next petrol pump
    static class petrolPump {

        int petrol;
        int distance;

        // constructor
        public petrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    private static int printTour(petrolPump arr[], int n) {
        int start = 0;
        int end = 1;
        int curr_petrol = arr[start].petrol - arr[start].distance;

        // If current amount of petrol in truck becomes less than 0, then
        // remove the starting petrol pump from tour
        while (end != start || curr_petrol < 0) {

            // If current amount of petrol in truck becomes less than 0, then
            // remove the starting petrol pump from tour
            while (curr_petrol < 0 && start != end) {
                // Remove starting petrol pump. Change start
                curr_petrol -= arr[start].petrol - arr[start].distance;
                start = (start + 1) % n;

                // If 0 is being considered as start again, then there is no
                // possible solution
                if (start == 0) {
                    return -1;
                }
            }

            // Add a petrol pump to current tour
            curr_petrol += arr[end].petrol - arr[end].distance;
            end = (end + 1) % n;
        }

        return start;
    }

    public static void main(String[] args) {

        petrolPump[] arr = {new petrolPump(6, 4),
            new petrolPump(3, 6),
            new petrolPump(7, 3)};

        int start = printTour(arr, arr.length);
        System.out.println(start == -1 ? "No Solution" : "Start = " + start);

    }
}
