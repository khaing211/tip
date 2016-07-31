package com.kn.tip.problem.codefight;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://codefights.com/challenge/fnTESz2SNJ5xvZuYn/main
public class SquareRoots {
  int squareRoots(int l, int k) {
    int[] a = new int[l];
    int i, s = 0;
    for (i = 0; i < l; i++)
      a[i] = i + 1;
    for (; k > 0; k--) {
      a[l - 1] = (int) Math.floor(Math.sqrt(a[l - 1]));
      Arrays.sort(a);
    }
    for (i = 0; i < l; i++)
      s += a[i];
    return s;
  }

  int squareRoots2(int l, int k) {
    PriorityQueue<Integer> q = new PriorityQueue<>(l, Comparator.reverseOrder());
    while (l > 0)
      q.add(l--);
    for (; k > 0; k--) {
      q.add((int) Math.floor(Math.sqrt(q.poll())));
    }

    int s = 0;
    while (!q.isEmpty())
      s += q.poll();
    return s;
  }
}
