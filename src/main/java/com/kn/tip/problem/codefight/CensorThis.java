package com.kn.tip.problem.codefight;

public class CensorThis {
  String CensorThis(String t, String[] w) {
    for (String a : w)
      t = t.replaceAll("(?i)\\b" + a + "\\b", a.replaceAll(".", "*"));
    return t;
  }
}
