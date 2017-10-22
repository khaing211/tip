package com.kn.tip.problem.interviewbit;

import java.math.BigInteger;
import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/path-sum/
 *
 * Use BigInteger to prevent integer overflow
 */
public class PathSum {
  public int hasPathSum(final TreeNode a, final int b) {
    final Stack<SumNode> stack = new Stack<>();
    stack.push(new SumNode(BigInteger.valueOf(a.val), a));
    final BigInteger target = BigInteger.valueOf(b);
    while (!stack.isEmpty()) {
      final SumNode prefixNode = stack.pop();
      if (prefixNode.node.left == null
          && prefixNode.node.right == null
          && target.equals(prefixNode.sum)) {
        return 1;
      }
      if (prefixNode.node.left != null) {
        stack.push(new SumNode(prefixNode.sum.add(BigInteger.valueOf(prefixNode.node.left.val)),
            prefixNode.node.left));
      }
      if (prefixNode.node.right != null) {
        stack.push(new SumNode(prefixNode.sum.add(BigInteger.valueOf(prefixNode.node.right.val)),
            prefixNode.node.right));
      }
    }

    return 0;
  }

  class SumNode {
    BigInteger sum;
    TreeNode node;

    public SumNode(final BigInteger number, final TreeNode node) {
      this.sum = number;
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
