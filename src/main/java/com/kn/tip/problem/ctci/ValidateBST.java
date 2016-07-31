package com.kn.tip.problem.ctci;

import com.kn.tip.datastructure.TreeNode;
import com.kn.tip.datastructure.Tuple;

public class ValidateBST {
  public static void main(String[] args) {
    System.out.println(isBST(MinimalTree.createBST(new int[] {1, 2, 3, 4, 5})));

    System.out.println(isBST(MinimalTree.createBST(new int[] {1, 5, 3, 4, 5})));

    System.out.println(isBSTPreOrder(MinimalTree.createBST(new int[] {1, 2, 3, 4, 5}), null, null));

    System.out.println(isBSTPreOrder(MinimalTree.createBST(new int[] {1, 5, 3, 4, 5}), null, null));
  }

  public static boolean isBST(TreeNode<Integer> root) {
    if (root == null) {
      return false;
    }

    return checkBST(root).getC();
  }

  // This is post-order transversal
  // i.e. you rely on value from transversal in order to eval
  // can you rewrite this to pre-order transversal ?
  // root never null
  public static Tuple<Integer, Integer, Boolean> checkBST(TreeNode<Integer> root) {
    Tuple<Integer, Integer, Boolean> left = null;
    Tuple<Integer, Integer, Boolean> right = null;
    boolean validBST = true;

    if (root.hasLeft()) {
      left = checkBST(root.getLeft());

      validBST = validBST && left.getC() && left.getB() <= root.getValue();
    }

    if (root.hasRight()) {
      right = checkBST(root.getRight());

      validBST = validBST && right.getC() && right.getA() > root.getValue();
    }

    return new Tuple<>(left == null ? root.getValue() : left.getA(),
        right == null ? root.getValue() : right.getB(), validBST);
  }

  public static boolean isBSTPreOrder(TreeNode<Integer> root, Integer min, Integer max) {
    if (root == null) {
      return true;
    }

    if ((min != null && root.getValue() <= min) || (max != null && max < root.getValue())) {
      return false;
    }

    if (isBSTPreOrder(root.getLeft(), min, root.getValue())
        && isBSTPreOrder(root.getRight(), root.getValue(), max)) {
      return true;
    }

    return false;
  }
}
