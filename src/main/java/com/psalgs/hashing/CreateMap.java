/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.hashing;

import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author djoshi
 */
public class CreateMap {

    String key;

    private CreateMap(String key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        int hash = (int) key.charAt(0);
        System.out.println("hashCode for key: " + key + " = " + hash);  
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return key.equals(((CreateMap) obj).key);
    }

    public static void main(String args[]) {
        HashMap map = new HashMap();
        map.put(new CreateMap("vishal"), 20);
        map.put(new CreateMap("sachin"), 30);
        map.put(new CreateMap("vaibhav"), 40);

        System.out.println();
        System.out.println("Value for key sachin: " + map.get(new CreateMap("sachin")));
        System.out.println("Value for key vaibhav: " + map.get(new CreateMap("vaibhav")));
    }

}
