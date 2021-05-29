/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author djoshi
 */
public class RansomNote {
    Map<String, Integer> magazineMap = new HashMap<>();
    Map<String, Integer> noteMap = new HashMap<>();
    
    public RansomNote(String magazine,String note) {
        StringTokenizer stMag = new StringTokenizer(magazine);
        StringTokenizer stNote = new StringTokenizer(note);
        
        while(stMag.hasMoreTokens()) {
            String s = stMag.nextToken();
            if(!magazineMap.containsKey(s)) {
                magazineMap.put(s, 1);
            } else {
                int x = magazineMap.get(s);
                magazineMap.put(s, ++x);
            } 
        }
        
        while(stNote.hasMoreTokens()) {
            String s = stNote.nextToken();
            if(!noteMap.containsKey(s)) {
                noteMap.put(s, 1);
            } else {
                int x = noteMap.get(s);
                noteMap.put(s, ++x);
            } 
        }
    }
    
    public boolean solve() {
        boolean answer = true;
        for(String s: noteMap.keySet()) {
            if(magazineMap.containsKey(s)) {
                if(magazineMap.get(s) >= 1) {
                    int avail = magazineMap.get(s);
                    int req = noteMap.get(s);
                    
                    if(avail >= req)
                        magazineMap.put(s,avail-req);
                    else
                        return false;
                } else {
                    magazineMap.remove(s);
                }
                
            } else {
                return false;
            }
        }
        return answer;
    }
    
    public static void main(String args[]) {
        String m = "zahk dp apdz clo e dk awfvf osb qr sa cqjq zgr nvxtb abjy axa ili wdyw soqku buwcl qcub sautu ii vkrzl bdob nona al zg ombzc c dbun f xkuo lsax hfki j dfft uce ugj ywz vucgg xq udrkt ypy tmxgc ty gar kty dc bznj pzzx clo apdz nvxtb clo sa clo zahk awfvf soqku udrkt udrkt e ypy xkuo tmxgc ombzc wdyw al axa lsax clo abjy osb apdz bdob pzzx zahk c bznj gar osb xkuo zahk zg uce zg clo e apdz gar xq dbun buwcl ili bznj clo osb dc dbun ywz";
        String n = "buwcl qr axa ypy zahk nvxtb dp hfki ii uce dc zg dbun ypy ty cqjq zg kty bznj zg zahk dp c al ugj ywz qcub ywz wdyw hfki gar e axa dp qr kty bznj clo ty vucgg qcub al vkrzl qcub j awfvf soqku lsax bdob nvxtb";
                
        RansomNote r = new RansomNote(m,n);
        boolean answer = r.solve();
        if(answer)
            System.out.println("Yes");
        else 
            System.out.println("No");
    }
    
}
