package com.kn.tip.problem.ctci;

import com.kn.tip.datastructure.TreeNode;
import com.kn.tip.problem.TreeDiameter;

public class MinimalTree {
  // assume uniq int array
  // what happen if it is non-uniq, how can you guarantee min height
  public static TreeNode<Integer> createBST(int[] array) {
    return createBST(array, 0, array.length-1);
  }
  
  public static TreeNode<Integer> createBST(int[] array, int low, int high) {
    final int mid = (low + high) / 2;
    final TreeNode<Integer> root = new TreeNode<Integer>(array[mid]);
    if (low != mid) {
      root.setLeft(createBST(array, low, mid-1));
      root.getLeft().setParent(root);
    }
    
    if (high != mid) {
      root.setRight(createBST(array, mid+1, high));
      root.getRight().setParent(root);
    }
    
    return root;
  }
  
  public static void main(String[] args) {
    TreeNode<Integer> root1 = MinimalTree.createBST(new int[] {1,2,3,4});
    InOrderTransversal.transverse(root1, i -> System.out.print(i + " "));
    System.out.println();
    System.out.println(TreeDiameter.height(root1));
  }
}
