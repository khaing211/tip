package com.kn.tip.problem;

import org.junit.Test;

import com.kn.tip.problem.EvenFibonacci;

import static org.junit.Assert.assertEquals;

public class EvenFibonacciTest {
  @Test
  public void test() {
    assertEquals(10L, EvenFibonacci.sum(10L));
    assertEquals(44L, EvenFibonacci.sum(100L));
  }
}
