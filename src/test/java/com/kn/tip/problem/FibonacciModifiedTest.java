package com.kn.tip.problem;

import org.junit.Test;

import com.kn.tip.problem.FibonacciModified;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class FibonacciModifiedTest {
  @Test
  public void test() {
    assertEquals(BigInteger.valueOf(5), FibonacciModified.compute(0, 1, 5));
  }
}
