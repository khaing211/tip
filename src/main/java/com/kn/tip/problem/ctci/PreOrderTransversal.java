package com.kn.tip.problem.ctci;

import java.util.function.Consumer;

import com.kn.tip.datastructure.TreeNode;

public interface PreOrderTransversal {
  public static <T> void transverse(TreeNode<T> root, Consumer<T> visit) {
    if (root == null) return;
    
    visit.accept(root.getValue());
    transverse(root.getLeft(), visit);
    transverse(root.getRight(), visit);
  }
  
}
