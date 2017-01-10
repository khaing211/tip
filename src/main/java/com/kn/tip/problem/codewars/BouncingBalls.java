package com.kn.tip.problem.codewars;

public class BouncingBalls {
  public static int bouncingBall(final double h, final double bounce, final double window) {
    if (h <= window || bounce >= 1 || bounce < 0 || h < 0 || window  < 0) {
      return -1;
    }

    // one offset for 1st fall,
    // mother would see the ball twice for every bounce higher than the window
    // use logarithm to compute
    return 1 + 2*(int)Math.floor(Math.log(window/h)/Math.log(bounce));
}
}
