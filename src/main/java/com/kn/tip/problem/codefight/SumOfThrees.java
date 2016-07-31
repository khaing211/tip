package com.kn.tip.problem.codefight;

public class SumOfThrees {
  // the initial solution is using TreeSet as a buffer
  // upon realizing the order is already largest decend
  // contain() operation can be trade with endsWith
  // since the only time you could have duplicate is
  // when it splits in half.
  String sumOfThrees(String k) {
    long n = new Long(k), i, e;
    k = "";
    while (n > 0) {
      for (i = -1, e = 1; e <= n; i++, e *= 3);
      // technically it is "^"+i
      // but I can get away with "" to impicit conversion toString
      if (k.endsWith("" + i))
        return "Impossible";
      n -= e / 3;
      k += "+3^" + i;
    }

    return k.substring(1);
  }
}
