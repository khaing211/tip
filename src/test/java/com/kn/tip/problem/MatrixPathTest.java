package com.kn.tip.problem;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kn.tip.problem.MatrixPath;

public class MatrixPathTest {

  @Test
  public void test() {
    assertEquals(215, MatrixPath.findPath(new int[][] {
      {15, 25, 30},
      { 45, 25, 60},
      { 70, 75, 10}
    }, 3, 3));
  }

}
