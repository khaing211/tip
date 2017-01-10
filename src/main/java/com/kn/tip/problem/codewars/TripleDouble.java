package com.kn.tip.problem.codewars;

public class TripleDouble {
  public static int TripleDouble(final long num1, final long num2) {
    // this array can be auto-generated
    // hardcoding
    final String[][] array = new String[][] {
      {"00", "000"},
      {"11", "111"},
      {"22", "222"},
      {"33", "333"},
      {"44", "444"},
      {"55", "555"},
      {"66", "666"},
      {"77", "777"},
      {"88", "888"},
      {"99", "999"}
    };
    final String a1 = Long.toString(num1);
    final String a2 = Long.toString(num2);
    for (int i = 0; i < 10; i++) {
      if (a1.contains(array[i][1]) && a2.contains(array[i][0])) {
        return 1;
      }
    }
    return 0;
  }
}
