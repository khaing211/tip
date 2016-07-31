package com.kn.tip.problem;

import org.junit.Test;

import com.kn.tip.problem.BricksGame;

public class BricksGameTest {
  @Test
  public void test() {
    BricksGame.sum(new long[] {2, 3});
    BricksGame.sum(new long[] {1, 2, 3});
    BricksGame.sum(new long[] {0, 1, 2, 3});
    BricksGame.sum(new long[] {999, 1, 1, 1, 0});
    BricksGame.sum(new long[] {0, 1, 1, 1, 999});
  }
}
