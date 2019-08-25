package com.kn.tip.problem.interviewpro;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

/**
 * Imagine you are building a compiler. Before running any code, the compiler must check that the
 * parentheses in the program are balanced. Every opening bracket must have a corresponding closing
 * bracket. We can approximate this using strings.
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid. An input string is valid if:
 * - Open brackets are closed by the same type
 * of brackets.
 * - Open brackets are closed in the correct order.
 * - Note that an empty string is also considered valid.
 *
 * Example: Input: "((()))" Output: True
 *
 * Input: "[()]{}" Output: True
 *
 * Input: "({[)]" Output: False
 *
 */
public class ValidatedBalancedParentheses {
  private static final Set<Character> OPEN_BRACKETS = ImmutableSet.of('(', '[', '{');
  private static final Set<Character> CLOSE_BRACKETS = ImmutableSet.of(')', ']', '}');
  private static final Map<Character, Character> CLOSE_BRACKETS_BY_OPEN_BRACKET = ImmutableMap.of('(', ')', '{', '}', '[', ']');

  public boolean validate(final String s) {
    final Stack<Character> expectedClosedBrackets = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      final char ch = s.charAt(i);
      if (OPEN_BRACKETS.contains(ch)) {
        expectedClosedBrackets.push(CLOSE_BRACKETS_BY_OPEN_BRACKET.get(ch));
      }
      if (CLOSE_BRACKETS.contains(ch)) {
        final char expectedCh = expectedClosedBrackets.pop();
        if (expectedCh != ch) {
          return false;
        }
      }
    }

    return expectedClosedBrackets.isEmpty();
  }
}
