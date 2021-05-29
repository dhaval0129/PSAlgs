/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.rangequeries;

import java.util.Arrays;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/mos-algorithm-query-square-root-decomposition-set-1-introduction/
 *
 * https://sites.google.com/site/indy256/algo/mos_algorithm
 *
 * MO`s Algorithm (Query Square Root Decomposition)
 *
 * We are given an array and a set of query ranges, we are required to find sum
 * of every query range.
 *
 */
public class MOsAlgorithm {

    static class Query {

        int index;
        int a, b;

        public Query(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private static int add(int[] a, int[] cnt, int i) {
        return (++cnt[a[i]] == 1 ? 1 : 0);
    }

    private static int remove(int[] a, int[] cnt, int i) {
        return (--cnt[a[i]] == 0 ? -1 : 0);
    }

    private static int[] processQueries(int[] a, Query[] queries) {
        for (int i = 0; i < queries.length; i++) {
            queries[i].index = i;
        }

        int sqrtn = (int) Math.sqrt(a.length);
        Arrays.sort(queries, (q1, q2) -> {
            int cmp = Integer.compare(q1.a / sqrtn, q2.a / sqrtn);
            return cmp != 0 ? cmp : Integer.compare(q1.b, q2.b);
        });

        int[] cnt = new int[1000_002];
        int[] res = new int[queries.length];
        int L = 1;
        int R = 0;
        int cur = 0;

        for (Query query : queries) {
            while (L < query.a) {
                cur += remove(a, cnt, L++);
            }
            while (L > query.a) {
                cur += add(a, cnt, --L);
            }
            while (R < query.b) {
                cur += add(a, cnt, ++R);
            }
            while (R > query.b) {
                cur += remove(a, cnt, R--);
            }
            res[query.index] = cur;
        }

        return res;
    }

    public static void main(String args[]) {
        int[] a = {1, 1, 2, 1, 3, 4, 5, 2, 8};
        Query[] queries = {
            new Query(0, 4),
            new Query(1, 3),
            new Query(2, 4)
        };
        
        int[] res = processQueries(a, queries);
        System.out.println(Arrays.toString(res));
    }
}
