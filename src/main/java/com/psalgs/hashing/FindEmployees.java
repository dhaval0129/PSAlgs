/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/find-number-of-employees-under-every-manager/
 *
 * Find number of Employees Under every Employee
 *
 */
public class FindEmployees {

    // A hashmap to store result. It stores count of employees
    // under every employee, the count may by 0 also
    static Map<String, Integer> result = new HashMap<>();

    public static void main(String args[]) {
        Map<String, String> dataSet = new HashMap<>();
        dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "F");
        dataSet.put("D", "E");
        dataSet.put("E", "F");
        dataSet.put("F", "F");

        populateResult(dataSet);
        System.out.println("result = " + result);
    }

    private static void populateResult(Map<String, String> dataSet) {

        // create manager employee map with string as key and list as employee
        Map<String, List<String>> mngrEmpMap = new HashMap<>();

        // To fill mngeEmpMap, iterate through the given map
        for (Map.Entry<String, String> entry : dataSet.entrySet()) {
            String emp = entry.getKey();
            String mngr = entry.getValue();

            if (!emp.equals(mngr)) {

                // Get the previous list of direct reports under
                // current 'mgr' and add the current 'emp' to the list
                List<String> directReportList = mngrEmpMap.get(mngr);

                // If 'emp' is the first employee under 'mgr'
                if (directReportList == null) {
                    directReportList = new ArrayList<>();
                }

                directReportList.add(emp);
                
                // Replace old value for 'mgr' with new
                // directReportList
                mngrEmpMap.put(mngr, directReportList);
            }
        }

        // Now use manager-Emp map built above to populate result 
        // with use of populateResultUtil()
        // note- we are iterating over original emp-manager map and
        // will use mngr-emp map in helper to get the count
        for (String mngr : dataSet.keySet()) {
            populateResultUtil(mngr, mngrEmpMap);
        }
    }

    private static int populateResultUtil(String mngr, Map<String, List<String>> mngrEmpMap) {
        int count = 0;

        // means employee is not a manager of any other employee
        if (!mngrEmpMap.containsKey(mngr)) {
            result.put(mngr, 0);
            return 0;
        } else if (result.containsKey(mngr)) {
            count = result.get(mngr);
        } else {
            List<String> directReportEmpList = mngrEmpMap.get(mngr);
            count = directReportEmpList.size();
//            for (String directReportEmp : directReportEmpList) {
//                count += populateResultUtil(directReportEmp, mngrEmpMap);
//            }
            result.put(mngr, count);
        }

        return count;
    }
}
