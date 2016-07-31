package com.kn.tip.problem.leetcode;

public class ExcelSheetColumnNumber {
  public static int titleToNumber(String s) {
    int aVal = Character.getNumericValue('A');
    int n = 0;
    for (int i = 0; i < s.length(); i++) {
      final char ch = s.charAt(i);
      final int val = Character.getNumericValue(ch) - aVal;
      n = (n * 26) + val + 1;
    }

    return n;
  }

  public static void main(String[] args) {
    System.out.println(titleToNumber("A"));
    System.out.println(titleToNumber("AA"));
    System.out.println(titleToNumber("BC"));
    System.out.println(titleToNumber("ALL"));
  }
}
