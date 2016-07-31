package com.kn.tip.problem.codefight;

public class DigitOne {
  int DigitOne(int n) {
    return n > 0 ? r(n) : 2;
  }

  int r(int i) {
    int f = 1111 - i, h = 111 - i;
    return f < 0 ? 4 + r(-f)
        : h < 0 ? f < i ? 4 + r(f) : 3 + r(-h)
            : i < 7 ? i : i < 11 ? 13 - i : h < i ? 3 + r(h) : 2 + r(i - 11);
  }
}
