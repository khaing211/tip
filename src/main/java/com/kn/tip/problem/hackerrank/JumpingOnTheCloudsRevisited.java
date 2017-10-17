package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

public class JumpingOnTheCloudsRevisited {
  public static void main(final String[] args) {
    final Scanner in = new Scanner(System.in);
    final int n = in.nextInt();
    final int k = in.nextInt();
    final boolean c[] = new boolean[n];
    for (int c_i = 0; c_i < n; c_i++) {
      c[c_i] = in.nextInt() == 1;
    }
    int E = 100;
    int i = 0;
    do {
      i = (i + k) % n;
      E -= c[i] ? 3 : 1;
    } while (i != 0);
    System.out.println(E);
  }
}
