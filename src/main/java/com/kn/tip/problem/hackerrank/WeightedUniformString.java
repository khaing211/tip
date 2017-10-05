package com.kn.tip.problem.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/weighted-uniform-string
 */
public class WeightedUniformString {
  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final String s = in.next();
    final int n = in.nextInt();
    final int offset = Character.getNumericValue('a') - 1;
    final Set<Integer> values = new HashSet<>();
    char lastCh = ' ';
    int value = 0;
    // contiguous substring
    for (int i = 0; i < s.length(); i++) {
        final char ch = s.charAt(i);
        final int chVal = Character.getNumericValue(ch) - offset;
        if (lastCh == ch) {
            value += chVal;
        } else {
            value = chVal;
        }
        lastCh = ch;
        values.add(value);
    }
    for(int a0 = 0; a0 < n; a0++){
        final int x = in.nextInt();
        System.out.println(values.contains(x) ? "Yes" : "No");
    }
}
}
