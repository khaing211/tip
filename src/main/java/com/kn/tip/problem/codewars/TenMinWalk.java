package com.kn.tip.problem.codewars;

public class TenMinWalk {
  public static boolean isValid(final char[] walk) {
    if (walk.length != 10) {
      return false;
    }

    final int[] pos = {0, 0};
    for (int i = 0; i < walk.length; i++) {
      switch(walk[i]) {
        case 'n': pos[0]++; break;
        case 's': pos[0]--; break;
        case 'e': pos[1]++; break;
        case 'w': pos[1]--; break;
      }
    }
    return pos[0] == 0 && pos[1] == 0;
  }
}
