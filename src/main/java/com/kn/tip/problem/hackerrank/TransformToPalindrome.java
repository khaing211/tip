package com.kn.tip.problem.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Alphabet of Orion is n letters denote from 1 to n
 * Transform is invertible and transitive i.e. i -> j also mean j -> i. i -> j -> z = i -> z
 * Supplied 1 to k transform
 * Supplied sequence of m length of alphbet.
 * Feel free to apply number of transformations
 * Then, find longest subsequence palidrome.
 */
public class TransformToPalindrome {
  /**
   * Solution:
   * 1. union-find to find all connected-component to transform to a root number
   * 2. use dynamic programming to find longest subsequence palindrome
   *    http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
   */
  public static void main(final String[] args) throws IOException {
    StringTokenizer st;
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int k = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());

    // find-union
    final int[] parent = new int[n + 1];
    final int[] rank = new int[n + 1];
    for (int i = 0; i < n + 1; i++) {
      parent[i] = i;
    }
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      final int x = Integer.parseInt(st.nextToken());
      final int y = Integer.parseInt(st.nextToken());
      union(x, y, parent, rank);
    }

    // System.err.println(Arrays.toString(parent));
    st = new StringTokenizer(br.readLine());
    final int[] a = new int[m];
    for (int i = 0; i < m; i++) {
      final int t = Integer.parseInt(st.nextToken());
      a[i] = findRoot(t, parent);
    }
    // System.err.println(Arrays.toString(a));

    // Run DP on longest subsequence palidrome
    final int[][] L = new int[m][m];
    // Strings of length 1 are palindrome of lentgh 1
    for (int i = 0; i < m; i++) {
      L[i][i] = 1;
    }

    // cl is length of substring
    // Note that the lower diagonal values of table are useless and not filled in the process
    for (int cl = 2; cl <= m; cl++) {
      for (int i = 0; i < m - cl + 1; i++) {
        final int j = i + cl - 1;
        if (a[i] == a[j] && cl == 2) {
          L[i][j] = 2;
        } else if (a[i] == a[j]) {
          L[i][j] = L[i + 1][j - 1] + 2;
        } else {
          L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
        }
      }
    }

    System.out.println(L[0][m - 1]);
  }

  private static int findRoot(int x, final int[] parent) {
    while (parent[x] != x) {
      x = parent[x];
    }
    return x;
  }

  private static void union(final int x, final int y, final int[] parent, final int[] rank) {
    final int rootX = findRoot(x, parent);
    final int rootY = findRoot(y, parent);

    if (rootX != rootY) {
      if (rank[rootX] > rank[rootY]) {
        parent[rootY] = rootX;
      } else if (rank[rootY] > rank[rootX]) {
        parent[rootX] = rootY;
      } else {
        rank[rootX]++;
        parent[rootY] = rootX;
      }
    }
  }
}
