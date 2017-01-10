package com.kn.tip.problem.codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WhichAreIn {
  public static String[] inArray(final String[] array1, final String[] array2) {
    return Arrays.stream(array1)
      .sorted()
      .filter(s -> isSubstringOfStrings(s, array2))
      .collect(Collectors.toList())
      .toArray(new String[]{});
  }

  private static boolean isSubstringOfStrings(final String target, final String[] haystack) {
    return Arrays.stream(haystack)
      .filter(s -> s.indexOf(target) >= 0)
      .findAny()
      .isPresent();
  }
}
