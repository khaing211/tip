package com.kn.tip.problem.interviewpro;

import org.junit.Assert;
import org.junit.Test;

public class ValidatedBalancedParenthesesTest {
  @Test
  public void testValidate() {
    final ValidatedBalancedParentheses validator = new ValidatedBalancedParentheses();
    Assert.assertTrue(validator.validate("((()))"));
    Assert.assertTrue(validator.validate("[()]{}"));
    Assert.assertFalse(validator.validate("({[)]"));
  }

}
