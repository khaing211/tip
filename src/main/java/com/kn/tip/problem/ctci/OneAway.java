package com.kn.tip.problem.ctci;

public class OneAway {
  public static void main(String[] args) {
    System.out.println(isOneAway("pale", "ple"));
    System.out.println(isOneAway("pales", "pale"));
    System.out.println(isOneAway("pale", "bale"));
    System.out.println(isOneAway("pale", "bake"));
  }

  public static boolean isOneAway(String s1, String s2) {
    if (s1.length() == s2.length()) {
      // replace edit
      int mismatchCount = 0;
      for (int i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) != s2.charAt(i)) {
          mismatchCount++;
        }
      }

      return mismatchCount <= 1;

    } else if (Math.abs(s1.length() - s2.length()) == 1) {
      // delete or insert edit
      int i = 0;
      int j = 0;

      // check the prefix
      while (i < s1.length() && j < s2.length()) {
        if (s1.charAt(i) != s2.charAt(j)) {
          break;
        }
        i++;
        j++;
      }

      // match all prefix
      if (i == s1.length() - 1 || j == s2.length() - 1) {
        return true;
      }

      if (s1.length() > s2.length()) {
        i++;
      } else {
        j++;
      }

      // check the suffix
      while (i < s1.length() && j < s2.length()) {
        if (s1.charAt(i) != s2.charAt(j)) {
          return false;
        }
        i++;
        j++;
      }

      return true;

    } else {
      return false;
    }

  }
}
