package com.kn.tip.problem.hackerrank;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class JavaHashSet {
  public static void main(final String[] args) {
    final Scanner s = new Scanner(System.in);
    final int t = s.nextInt();
    final String [] pair_left = new String[t];
    final String [] pair_right = new String[t];

    for (int i = 0; i < t; i++) {
        pair_left[i] = s.next();
        pair_right[i] = s.next();
    }
    final Set<String> pairSet = new HashSet<>();
    for (int i = 0; i < t; i++) {
        // hack
        pairSet.add(pair_left[i] + "_" + pair_right[i]);
        System.out.println(pairSet.size());
    }

    // Using Comparator
    final Set<String[]> pairSet2 = new TreeSet<>(Comparator.comparing((final String[] a) -> a[0], String::compareTo)
        .thenComparing((final String[] a)  -> a[1], String::compareTo));
    for (int i = 0; i < t; i++) {
        // hack
        pairSet2.add(new String[] { pair_left[i] , pair_right[i]});
        System.out.println(pairSet.size());
    }
  }
}
