package com.kn.tip.problem.codefight;

public class SumTheDifference {
  // xor is criss-cross case of -odd, +even and sign
  int SumtheDifference(String a) {
    int s = 0, r = 0, i = 0;
    while (i < a.length()) {
      char c = a.charAt(i++);
      int t = c - '0';
      if (c == '-')
        s = 1;
      else if (t > 0) {
        r += (s ^ t % 2) == 1 ? -t : t;
        s = 0;
      } else if (c != ' ')
        s = 0;
    }
    return r;
  }

  int SumtheDifferenceShorter(String a) {
    int s = 0, r = 0, i = 0;
    while (i < a.length()) {
      int t = a.charAt(i++) - '0';
      r += 0 > t ? 0 : (s ^ t % 2) == 1 ? -t : t;
      s = t == -3 ? 1 : t != -16 ? 0 : s;
    }
    return r;
  }

}
