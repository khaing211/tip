package com.kn.tip.problem.interviewbit;

import java.math.BigInteger;
import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRootToLeafNumber {
  public int sumNumbers(final TreeNode a) {
    final Stack<PrefixNode> stack = new Stack<>();
    stack.push(new PrefixNode(BigInteger.valueOf(a.val), a));
    BigInteger sum = BigInteger.ZERO;
    while (!stack.isEmpty()) {
      final PrefixNode prefixNode = stack.pop();
      if (prefixNode.node.left == null && prefixNode.node.right == null) {
        sum = sum.add(prefixNode.number);
      }
      if (prefixNode.node.left != null) {
        stack.push(new PrefixNode(addLsb(prefixNode.number, prefixNode.node.left.val),
            prefixNode.node.left));
      }
      if (prefixNode.node.right != null) {
        stack.push(new PrefixNode(addLsb(prefixNode.number, prefixNode.node.right.val),
            prefixNode.node.right));
      }
    }

    return sum.mod(BigInteger.valueOf(1003)).intValue();
  }

  static BigInteger addLsb(final BigInteger val, final int digit) {
    return val.multiply(BigInteger.TEN).add(BigInteger.valueOf(digit));
  }

  class PrefixNode {
    BigInteger number;
    TreeNode node;

    public PrefixNode(final BigInteger number, final TreeNode node) {
      this.number = number;
      this.node = node;
    }
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(final int x) {
      val = x;
    }
  }
}
