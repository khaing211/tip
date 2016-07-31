package com.kn.tip.problem.ctci;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.kn.tip.datastructure.TreeNode;

public class ListOfDepth {
  // depth start 0
  public static <T> List<TreeNode<T>> getDepth(TreeNode<T> root, int depth) {

    List<TreeNode<T>> currentTree = new LinkedList<TreeNode<T>>();
    currentTree.add(root);

    for (int i = 1; i <= depth; i++) {
      // we might not have to create new tree if we keep track of iterator
      List<TreeNode<T>> nextTree = new LinkedList<TreeNode<T>>();
      Iterator<TreeNode<T>> iterator = currentTree.iterator();
      while (iterator.hasNext()) {
        TreeNode<T> node = iterator.next();
        if (node.hasLeft()) {
          nextTree.add(node.getLeft());
        }

        if (node.hasRight()) {
          nextTree.add(node.getRight());
        }
      }

      currentTree = nextTree;
    }

    return currentTree;
  }

  public static void main(String[] args) {
    TreeNode<Integer> root = MinimalTree.createBST(new int[] {1, 2, 3, 4, 5});
    List<TreeNode<Integer>> depthTree = getDepth(root, 1);
    depthTree.forEach(node -> System.out.print(node.getValue() + " "));
  }
}
