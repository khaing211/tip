package com.kn.tip.problem.interviewpro;

import org.junit.Assert;
import org.junit.Test;

public class FirstAndLastIndicesOfAnElementInASortedArrayTest {
  @Test
  public void testFindElement() {
    final FirstAndLastIndicesOfAnElementInASortedArray finder = new FirstAndLastIndicesOfAnElementInASortedArray();
    Assert.assertArrayEquals(new int[] {6,8},
        finder.findElement(new int[] {1,3,3,5,7,8,9,9,9,15}, 9));
    Assert.assertArrayEquals(new int[] {1,2},
        finder.findElement(new int[] {100, 150, 150, 153}, 150));
    Assert.assertArrayEquals(new int[] {-1, -1},
        finder.findElement(new int[] {1,2,3,4,5,6,10}, 9));
    Assert.assertArrayEquals(new int[] {0, 3},
        finder.findElement(new int[] {1,1,1,1}, 1));

  }
}
