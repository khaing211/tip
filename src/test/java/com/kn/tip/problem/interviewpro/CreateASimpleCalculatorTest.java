package com.kn.tip.problem.interviewpro;

import org.junit.Assert;
import org.junit.Test;

public class CreateASimpleCalculatorTest {
  @Test
  public void testCompute() {
    final CreateASimpleCalculator solution = new CreateASimpleCalculator();
    Assert.assertEquals(-4, solution.compute("- ( 3 + ( 2 - 1 ) )"));
    Assert.assertEquals(4, solution.compute(" ( 3 + ( 2 - 1 ) )"));
    Assert.assertEquals(3, solution.compute(" ( 3 + ( 2 - 1 ) ) - ( 2 - 1)"));
  }
}
