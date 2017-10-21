package com.kn.tip.problem.interviewbit;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/window-string/
 */
public class WindowString {
  public static String minWindow(final String S, final String T) {
    if (S == null || T == null || S.isEmpty() || T.isEmpty()) {
      return "";
    }

    final Map<Character, Integer> charCount = new HashMap<>();

    for (int i = 0; i < T.length(); i++) {
      charCount.compute(T.charAt(i), (k, v) -> v == null ? 1 : v + 1);
    }
    //System.err.println(charCount);

    final int n = S.length();
    int startIndex = 0;
    int endIndex = 0;
    String bestSoFar = "";

    while (endIndex < n) {
      final char ch = S.charAt(endIndex);
      if (charCount.containsKey(ch)) {
        charCount.compute(ch, (k, v) -> v - 1);
      }

      if (match(charCount)) {
        //System.err.println(charCount);
        // Move startIndex closer to endIndex as possible
        // by allowing luxury T character to be dropped
        while (startIndex < n) {
          final char returnCh = S.charAt(startIndex);
          startIndex++;
          if (charCount.containsKey(returnCh)) {
            if (charCount.get(returnCh) == 0) {
              startIndex--;
              break;
            } else {
              charCount.compute(returnCh, (k, v) -> v + 1);
            }
          }
        }

        //System.err.println(charCount);
        bestSoFar = bestSoFar(bestSoFar, S.substring(startIndex, endIndex + 1));
        //System.err.println(bestSoFar);

        // Move startIndex closer to endIndex as possible
        // by allowing one count for any char in charCount
        while (startIndex < n) {
          final char returnCh = S.charAt(startIndex);
          startIndex++;
          if (charCount.containsKey(returnCh) && charCount.compute(returnCh, (k, v) -> v + 1) > 0) {
            break;
          }
        }

        // Move startIndex closer to endIndex as possible
        // by allowing non-T character to be eliminated
        while (startIndex < n) {
          final char returnCh = S.charAt(startIndex);
          startIndex++;
          if (charCount.containsKey(returnCh)) {
            startIndex--;
            break;
          }
        }
      }
      //System.err.println(startIndex + " " + endIndex);
      endIndex++;
    }

    return bestSoFar;
  }

  private static boolean match(final Map<Character, Integer> charCount) {
    return !charCount.entrySet().stream().anyMatch(entry -> entry.getValue() > 0);
  }

  private static String bestSoFar(final String bestSoFar, final String currentBestSoFar) {
    //System.err.println("Candidate: " + currentBestSoFar);
    return bestSoFar.isEmpty() ? currentBestSoFar
        : bestSoFar.length() > currentBestSoFar.length() ? currentBestSoFar : bestSoFar;
  }

  public static void main(final String[] args) {
    System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    System.out.println(minWindow("ADOBECODEBA", "ABC"));
    System.out.println(minWindow("OOOOADOBECODEBANC", "ABC"));
  }
}
