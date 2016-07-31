package com.kn.tip.problem;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kn.tip.problem.CountingTriangle;

public class CountingTriangleTest {

  @Test
  public void test() {
    assertEquals(6, CountingTriangle.count(new int[] {10, 21, 22, 100, 101, 200, 300}));
  }

}
