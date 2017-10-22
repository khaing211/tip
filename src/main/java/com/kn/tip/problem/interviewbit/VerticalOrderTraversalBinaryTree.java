package com.kn.tip.problem.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.interviewbit.com/problems/vertical-order-traversal-of-binary-tree/
 *
 * Most tedious code:
 * 1. Using Bread-First-Search to ensure level-ordering traversal / correct order in the final list
 * 2. Doing left node to right to ensure the correct order in the final list
 * 3. Keep track of left offset and col index and wrapper for TreeNode to be ColumnAwaredTreeNode
 */
public class VerticalOrderTraversalBinaryTree {
  public ArrayList<ArrayList<Integer>> verticalOrderTraversal(final TreeNode A) {
    final ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    if (A == null) {
      return result;
    }

    final Deque<ColumnAwaredTreeNode> queue = new LinkedList<>();
    int leftMostCol = 0;
    result.add(new ArrayList<>(Arrays.asList(A.val)));
    queue.addLast(new ColumnAwaredTreeNode(leftMostCol, A));
    while (!queue.isEmpty()) {
      final ColumnAwaredTreeNode colNode = queue.pollFirst();
      if (colNode.node.left != null) {
        final int leftNodeVal = colNode.node.left.val;
        final int leftCol = colNode.col - 1;
        if (leftCol < leftMostCol) {
          // insert in the front when introduce a new left most column
          result.add(0, new ArrayList<>(Arrays.asList(leftNodeVal)));
          // keep the left most col offset here!!
          leftMostCol = leftCol;
        } else {
          result.get(getAdjustedCol(leftCol, leftMostCol)).add(leftNodeVal);
        }
        queue.addLast(new ColumnAwaredTreeNode(leftCol, colNode.node.left));
      }

      if (colNode.node.right != null) {
        final int rightNodeVal = colNode.node.right.val;
        final int rightCol = colNode.col + 1;
        if (rightCol - leftMostCol >= result.size()) {
          // insert in the back when introduce a new right most column
          result.add(new ArrayList<>(Arrays.asList(rightNodeVal)));
        } else {
          result.get(getAdjustedCol(rightCol, leftMostCol)).add(rightNodeVal);
        }
        queue.addLast(new ColumnAwaredTreeNode(rightCol, colNode.node.right));
      }
    }

    return result;
  }

  static public int getAdjustedCol(final int col, final int leftMostCol) {
    return col - leftMostCol;
  }

  class ColumnAwaredTreeNode {
    int col;
    TreeNode node;

    public ColumnAwaredTreeNode(final int col, final TreeNode node) {
      this.col = col;
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
