package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

public class MorganAndString {
  public static void main(final String[] args) {
    @SuppressWarnings("resource")
    final Scanner scanner = new Scanner(System.in);
    final int n = Integer.valueOf(scanner.nextLine());
    for (int i = 0; i < n; i++) {
      // Append any ch that is > 'Z' to fix comparison issue at end of string for tie breaker
      final String a = scanner.nextLine() + "z";
      final String b = scanner.nextLine() + "z";
      // Optimization, allocate total space ahead of times
      final StringBuilder builder = new StringBuilder(a.length() + b.length());
      int j = 0;
      int k = 0;
      while (j < a.length() && k < b.length()) {
        char ach = a.charAt(j);
        char bch = b.charAt(k);
        if (ach < bch) {
          builder.append(ach);
          j++;
        } else if (ach > bch) {
          builder.append(bch);
          k++;
        } else {
          int tk = k, tj = j;
          boolean foundTieBreaker = false;
          // look ahead for tie breaker
          while (tj < a.length() && tk < b.length()) {
            ach = a.charAt(tj);
            bch = b.charAt(tk);
            if (ach != bch) {
              foundTieBreaker = true;
              break;
            }
            tj++;
            tk++;
          }
          // System.err.println("Found Tie breaker: " + foundTieBreaker + ", tie breaker: " + ach +
          // "," + bch);
          if (foundTieBreaker) {
            // Optimization, the same tie breaker (indices) can be using for multiple times
            // until indices are reached,
            // Due to the worst case scenarios (if not used) are
            // 1. a, b are of the same identical letter string. tiebreaker finder will execute every other letter which yield O(min(n, m)^2).
            // 2. a, b are of the same repeated pattern of 2 letters. Ex: "ABABAB", "ABABAB".

            final boolean tiebreaker = ach < bch;
            // System.err.println("Tie breaker " + tiebreaker);
            while (j < tj && k < tk) {
              ach = a.charAt(j);
              bch = b.charAt(k);
              if (ach < bch) {
                builder.append(ach);
                j++;
              } else if (ach > bch) {
                builder.append(bch);
                k++;
              } else {
                if (tiebreaker) {
                  builder.append(ach);
                  j++;
                } else {
                  builder.append(bch);
                  k++;
                }
              }
            }
          } else {
            // Does not matter which string you pick
            // because two substring are exactly the same
            // but only pick one ch to progress
            builder.append(a.charAt(j));
            j++;
          }
        }
      }

      builder.append(a.substring(j));
      builder.append(b.substring(k));

      System.out.println(builder.toString().replace("z", ""));
    }
  }
}
