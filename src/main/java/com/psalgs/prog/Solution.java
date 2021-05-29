/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.prog;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author djoshi
 *
 * 1] Try to find one candidate who has all skills
 * 2] Try to find two candidates who has all the skills 
 * 3] Try to find three candidates who has all the skills
 *
 * Continue so on till candidate with all skills are found
 *
 *
 */
class Solution {

    static class Person {

        String name;
        Set<String> skills;

        Person(String name, String... skills) {
            this.name = name;
            this.skills = new HashSet<String>(Arrays.asList(skills));
        }
    }

    static Collection<Person> hireTeam(Set<String> targetSkills, List<Person> candidates) {
        //TODO: implement
        Set<Person> teams = new HashSet<Person>();
        int cLen = candidates.size();
        int sLen = targetSkills.size();

        // create team skill matrix
        boolean teamSkill[][] = new boolean[cLen][sLen];

        for (int i = 0; i < cLen; i++) {
            Set<String> skill = candidates.get(i).skills;
            int j = 0;
            for (String s : targetSkills) {
                if (skill.contains(s)) {
                    teamSkill[i][j] = true;
                }
                j++;
            }
        }

        // Try to find candidates with all skills
        for (int i = 0; i < cLen; i++) {
            boolean allSkills = true;
            for (int j = 0; j < sLen; j++) {
                if (!teamSkill[i][j]) {
                    allSkills = false;
                }
            }
            if (allSkills == true) {
                teams.add(candidates.get(i));
            }
        }

        // Try to find two candidates with all skills;
        for (int i = 0; i < cLen; i++) {

            for (int j = 0; j < cLen; j++) {
                boolean allSkills = true;
                if (i == j) {
                    allSkills = false;
                } else {
                    for (int k = 0; k < sLen; k++) {
                        if (!(teamSkill[i][k] | teamSkill[j][k])) {
                            allSkills = false;
                        }
                    }
                }

                if (allSkills == true) {
                    teams.add(candidates.get(j));
                    teams.add(candidates.get(i));
                    break;
                }
            }

        }

        return teams;
    }

    public static void main(String[] args) {
        Collection<Person> team = hireTeam(
                // Required skills:
                new HashSet<String>(Arrays.asList(
                        "A", "B", "C", "D", "E", "F"
                )),
                // Candidates:
                Arrays.asList(
                        new Person("1", "A", "B", "C", "D"),
                        new Person("2", "A", "B", "E"),
                        new Person("3", "C", "D", "F"),
                        new Person("4", "E"),
                        new Person("5", "F")
                )
        );

        for (Person p : team) {
            System.out.println(p.name);
        }
    }

}
