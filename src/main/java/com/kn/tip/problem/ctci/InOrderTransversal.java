package com.kn.tip.problem.ctci;

import java.util.function.Consumer;

import com.kn.tip.datastructure.TreeNode;

public interface InOrderTransversal {
  public static <T> void transverse(TreeNode<T> root, Consumer<T> visit) {
    if (root == null)
      return;

    transverse(root.getLeft(), visit);
    visit.accept(root.getValue());
    transverse(root.getRight(), visit);
  }
}
