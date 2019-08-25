package com.kn.tip.problem.interviewpro;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class AddTwoNumbersAsALinkedListTest {
  @Test
  public void testAdd() {
    final AddTwoNumbersAsALinkedList adder = new AddTwoNumbersAsALinkedList();
    Assert.assertEquals(ImmutableList.of(7, 0, 8),
        adder.add(ImmutableList.of(2, 4, 3), ImmutableList.of(5, 6, 4)));

    Assert.assertEquals(ImmutableList.of(7, 0, 8),
        adder.add(ImmutableList.of(5, 6, 4), ImmutableList.of(2, 4, 3)));

    Assert.assertEquals(ImmutableList.of(0, 0, 0, 1),
        adder.add(ImmutableList.of(1), ImmutableList.of(9, 9, 9)));
  }
}
