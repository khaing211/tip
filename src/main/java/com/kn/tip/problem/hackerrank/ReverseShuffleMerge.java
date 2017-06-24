package com.kn.tip.problem.hackerrank;

import java.util.Arrays;

/**
 * Difficult to code right
 *
 * https://www.hackerrank.com/challenges/reverse-shuffle-merge
 */
public class ReverseShuffleMerge {
  private static final int NUM_LETTER = 'z' - 'a' + 1;
  private static String findSmallestLexicalString(final String s) {
    final int[] pick = new int[NUM_LETTER];
    final int[] seen = new int[NUM_LETTER];
    countFrequency(s, pick, seen);

    final StringBuilder builder = new StringBuilder(s.length() / 2);

    char bestSeen = (char)('z' + 1);
    int bestIndex = s.length();
    char small = smallest(pick);
    for (int j = s.length() - 1; j >= 0; j--) {
      char ch = s.charAt(j);
      if (isFulfilled(ch, pick)) {
        continue;
      }
      System.err.println("j = " + j + ", small =" + small + ", pick = " + Arrays.toString(pick) + ", seen = " + Arrays.toString(seen));
      if (ch == small) {
        System.err.println("1. Pick " + ch + " at " + j);
        pick[index(ch)]--;
        builder.append(ch);
        small = smallest(pick);
        bestSeen = (char)('z' + 1);
      } else {
        if (isSkippable(ch, seen)) {
          // we skip the letter, because it is skippable.
          // We record best seen and reduce seen count for future skippable check
          seen[index(ch)]--;
          if (ch < bestSeen) {
            bestSeen = ch;
            bestIndex = j;
          }
        } else {
          if (ch < bestSeen) {
            System.err.println("2. Pick " + ch + " at " + j);
            // there is no better option, pick this one.
            pick[index(ch)]--;
            builder.append(ch);
            bestSeen = (char)('z' + 1);
          } else {
            // revert seen[] counter
            while (j < bestIndex) {
              j++;
              seen[index(s.charAt(j))]++;
            }
            // Pick the better option in place of force option
            System.err.println("3. Pick " + ch + " at " + j);
            ch = s.charAt(j);
            pick[index(ch)]--;
            builder.append(ch);
            bestSeen = (char)('z' + 1);
          }
        }
      }
    }

    return builder.toString();
  }

  private static boolean isFulfilled(final char ch, final int[] pick) {
    return pick[index(ch)] == 0;
  }

  private static boolean isSkippable(final char ch, final int[] seen) {
    return seen[index(ch)] != 0;
  }

  private static char smallest(final int[] pick) {
    for (int i = 0; i < NUM_LETTER; i++) {
      if (pick[i] != 0) {
        return (char)('a' + i);
      }
    }
    return (char)('z' + 1);
  }

  private static int index(final char ch) {
    return ch - 'a';
  }

  private static void countFrequency(final String s, final int[] pick, final int[] seen) {
    final int[] freq = new int[NUM_LETTER];
    for (int i = 0; i < s.length(); i++) {
      freq[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < NUM_LETTER; i++) {
      pick[i] = seen[i] = freq[i]/2;
    }
  }

  public static void main(final String[] args) {
    //final Scanner scanner = new Scanner(System.in);
    //final String s = scanner.nextLine();
    final String input = "djjcddjggbiigjhfghehhbgdigjicafgjcehhfgifadihiajgciagicdahcbajjbhifjiaajigdgdfhdiijjgaiejgegbbiigida";
    final String s = "aaaaabccigicgjihidfiejfijgidgbhhehgfhjgiibggjddjjd";
    System.out.println(findSmallestLexicalString(input));
    System.out.println(s);
  }
}
