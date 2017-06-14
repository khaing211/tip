package com.kn.tip.problem.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * You are given two arrays A and B each containing  integers.
 * You need to choose exactly one number from A and exactly one number from B
 * such that the index of the two chosen numbers is not same and the sum of the 2 chosen values is minimum.
 *
 * Your objective is to find and print this minimum value.
 */
public class TwinArray {
  /**
   * Bruteforce would work, but Test #3 keeps timing out, Test #2 was on the verse of timing out, but it is still correct
   *
   * 1. The initial template was using Scanner. Replacing this with more faster IO method. This make Test #2 faster
   * 2. The initial template was buffered both A and B. You don't need buffered B.
   * 3. You do need to buffered B partially for duplicates (in B) and its original index, because
   * you get the value 1st time, you already run through A except at A[j] where j is the index of original value.
   * When you get duplicate, you only check against that unchecked index. And this solve Test #3 Timeout problem
   */
  public static void main(final String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    final int[] ar1 = new int[n];
    for (int ar1_i = 0; ar1_i < n; ar1_i++) {
      ar1[ar1_i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    // value to index
    final Map<Integer, Integer> ar2 = new HashMap<>();
    int result = Integer.MAX_VALUE;
    for (int j = 0; j < n; j++) {
      final int cur = Integer.parseInt(st.nextToken());
      if (!ar2.containsKey(cur)) {
        ar2.put(cur, j);
        for (int i = 0; i < ar1.length; i++) {
          if (j != i) {
            result = Math.min(ar1[i] + cur, result);
          }
        }
      } else {
        result = Math.min(ar1[ar2.get(cur)] + cur, result);
      }
    }

    System.out.println(result);
  }
}
