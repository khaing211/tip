package com.kn.tip.algorithm;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.kn.tip.algorithm.CycleDetection;

public class CycleDetectionTest {
  @Test
  public void test() {
    assertTrue(CycleDetection.hasCycle(new int[] {1, 2, 3, 0}));
    assertTrue(CycleDetection.hasCycle(new int[] {1, 2, 3, 4, 5, 2}));
    assertFalse(CycleDetection.hasCycle(new int[] {1, 2, 3, 4, 5, -1}));
  }
}
