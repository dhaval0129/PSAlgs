/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs;

/**
 *
 * @author djoshi
 */
public class Hours {
    public static void main(String[] args) {
        String time = "12:45:54PM";
        int hours =  Integer.parseInt(time.substring(0,2));
        String PM = time.substring(time.length()-2,time.length());
        String newHours="";
        
        if(PM.equalsIgnoreCase("PM")) {
            if(!(hours == 12)) 
                hours += 12 ;
            newHours = hours + "";
        } else if(PM.equalsIgnoreCase("AM")) {
            if(hours == 12)
                hours = 0;
            newHours = "0" + hours;
        }
        String newTime = newHours + time.substring(2,time.length()-2);
        System.out.println(newTime);        
    }
}
