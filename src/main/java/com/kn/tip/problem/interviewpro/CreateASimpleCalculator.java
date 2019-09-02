package com.kn.tip.problem.interviewpro;

import java.util.Stack;
import java.util.function.BiFunction;

/**
 * Given a mathematical expression with just single digits, plus signs, negative signs, and
 * brackets, evaluate the expression. Assume the expression is properly formed.
 *
 * Input: - ( 3 + ( 2 - 1 ) )
 * Output: -4
 */
public class CreateASimpleCalculator {
  public int compute(final String expression) {
    final Stack<LhsOp> stack = new Stack<>();

    int lhs = 0;
    BiFunction<Integer, Integer, Integer> op = null;

    for (int i = 0; i < expression.length(); i++) {
      final char ch = expression.charAt(i);
      switch (ch) {
        case '+':
          op = (k, j) -> k + j ;
          break;
        case '-':
          op = (k, j) -> k - j;
          break;
        case ' ':
          break;
        case '(':
          LhsOp store = new LhsOp();
          store.op = op;
          store.lhs = lhs;
          stack.push(store);
          lhs = 0;
          op = null;
          break;
        case ')':
          store = stack.pop();
          if (store.op != null) {
            lhs = store.op.apply(store.lhs, lhs);
          }
          break;
        default:
          final int tmp = ch - '0';
          if (op == null) {
            lhs = tmp;
          } else {
            lhs = op.apply(lhs, tmp);
            op = null;
          }
      }
    }
    return lhs;
  }

  private static class LhsOp {
    BiFunction<Integer, Integer, Integer> op;
    int lhs;
  }
}
