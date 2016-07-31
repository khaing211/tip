package com.kn.tip.problem.codefight;

public class BookPartition {
  int BookPartition(int m, int p, int c) {
    int[] a = new int[3];
    a[m % 3]++;
    a[p % 3]++;
    a[c % 3]++;
    // (a[0] == 0 || (a[0] == 1 && a[2] == 2)? 1:0)
    // at least 1 or special case, add 1
    // if you can get 2, add 1 more in addition to at least 1 case above
    return m / 3 + c / 3 + p / 3 + (a[0] == 0 || (a[0] == 1 && a[2] == 2) ? 1 : 0)
        + (a[2] == 3 ? 1 : 0);
  }
}
