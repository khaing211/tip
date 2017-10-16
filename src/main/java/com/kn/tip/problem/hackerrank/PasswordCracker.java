package com.kn.tip.problem.hackerrank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/password-cracker
 *
 * Dynamic Programming with backtrace.
 * A bit tedious to code it up and it get it right with the index
 */
public class PasswordCracker {
  static String crackPasswords(final Set<String> passwords, final String loginAttempt) {
    final int[] backIndex = new int[loginAttempt.length() + 1];
    final int maxIndex = loginAttempt.length();

    Arrays.fill(backIndex, -1);
    final LinkedList<Integer> queue = new LinkedList<>();
    queue.addLast(0);
    while (!queue.isEmpty()) {
      final int index = queue.pollFirst();
      for (final String password : passwords) {
        final int nextIndex = index + password.length();
        if (nextIndex <= maxIndex
            && backIndex[nextIndex] == -1
            && loginAttempt.startsWith(password, index)) {
          backIndex[nextIndex] = index;
          if (nextIndex == maxIndex) {
            break;
          } else {
            queue.addLast(nextIndex);
          }
        }
      }
    }
    // System.out.println(Arrays.toString(backIndex));

    if (backIndex[maxIndex] == -1) {
      return "WRONG PASSWORD";
    }

    final LinkedList<String> crackedPasswords = new LinkedList<>();
    int lastIndex = maxIndex;
    int index = backIndex[lastIndex];
    while (index != -1) {
      crackedPasswords.addFirst(loginAttempt.substring(index, lastIndex));
      lastIndex = index;
      index = backIndex[lastIndex];
    }
    return crackedPasswords.stream().collect(Collectors.joining(" "));
  }

  public static void main(final String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int T = Integer.valueOf(scanner.nextLine());
    for (int t = 0; t < T; t++) {
      final int n = Integer.valueOf(scanner.nextLine());
      final Set<String> passwords = new HashSet<>(Arrays.asList(scanner.nextLine().split(" ", n)));
      final String loginAttempt = scanner.nextLine();
      System.out.println(crackPasswords(passwords, loginAttempt));
    }
  }
}
