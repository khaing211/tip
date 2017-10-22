package com.kn.tip.problem.interviewbit;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LevelOrderTreeTraversal {
  public ArrayList<Integer> levelOrderTraversal(final TreeNode a) {
    final ArrayList<Integer> result = new ArrayList<>();
    final Deque<TreeNode> stack = new LinkedList<>();
    stack.push(a);
    while (!stack.isEmpty()) {
      final TreeNode current = stack.pop();
      result.add(current.val);

      // depends on the ordering (left -> right or right -> left)
      if (current.left != null) {
        stack.push(current.left);
      }

      if (current.right != null) {
        stack.push(current.right);
      }
    }

    return result;
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
