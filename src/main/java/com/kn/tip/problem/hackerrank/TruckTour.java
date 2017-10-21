package com.kn.tip.problem.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/truck-tour/problem
 *
 * The problem is in Queue section, but you could achieve circular
 * using array and modulo. Furthermore, there is no complexity difference
 * in using array or queue. At worst case, the algorithm still have O(n^2)
 */
public class TruckTour {
  public static void main(final String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int N = scanner.nextInt();
    final int ELIMINATED = -1;
    final int[] leftover = new int[N];
    for (int i = 0; i < N; i++) {
      final int gas = scanner.nextInt();
      final int distance = scanner.nextInt();
      leftover[i] = gas - distance;
    }

    final int[] total = new int[N];
    for (int startPump = 0; startPump < N; startPump++) {
      for (int i = 0; i < N; i++) {
        total[startPump] += leftover[(startPump + i) % N];
        if (total[startPump] < 0) {
          total[startPump] = ELIMINATED;
          break;
        }
      }
      // fail fast
      if (total[startPump] != ELIMINATED) {
        System.out.println(startPump);
        return;
      }
    }
  }
}
