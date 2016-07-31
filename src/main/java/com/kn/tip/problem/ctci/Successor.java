package com.kn.tip.problem.ctci;

import com.kn.tip.datastructure.TreeNode;

public class Successor {
  public static void main(String[] args) {
    TreeNode<Integer> root = MinimalTree.createBST(new int[] {1, 2, 3, 4, 5});
    TreeNode<Integer> current = leftMost(root);

    do {
      System.out.println(current.getValue());
    } while (null != (current = nextInOrder(current)));

    System.out.println("=====");
    current = leftMost(root);

    do {
      System.out.println(current.getValue());
    } while (null != (current = nextPostOrder(current)));

    System.out.println("=====");
    PostOrderTransversal.transverse(root, i -> System.out.println(i));

    System.out.println("=====");
    current = root;
    do {
      System.out.println(current.getValue());
    } while (null != (current = nextPreOrder(current)));

    System.out.println("=====");
    PreOrderTransversal.transverse(root, i -> System.out.println(i));
  }

  // tricky
  // in-order transversal
  public static <T> TreeNode<T> nextInOrder(TreeNode<T> current) {
    if (current == null)
      return null;

    if (current.hasRight()) {
      current = current.getRight();
      return leftMost(current);

    } else if (current.hasParent()) {

      while (current.hasParent() && current.getParent().getRight() == current) {
        current = current.getParent();
      }

      return current.getParent();
    } else {
      return null;
    }
  }

  public static <T> TreeNode<T> nextPostOrder(TreeNode<T> current) {
    if (current.hasParent()) {
      if (current.getParent().getRight() == current) {
        return current.getParent();
      } else if (current.getParent().hasRight()) {

        // have to go right if you can't go left
        // as much as possible
        current = current.getParent().getRight();
        while (!current.hasLeft() && current.hasRight()) {
          current = current.getRight();
        }

        // then go left if possible
        return leftMost(current);

      } else {
        return current.getParent();
      }
    }

    return null;
  }

  public static <T> TreeNode<T> nextPreOrder(TreeNode<T> current) {
    if (current.hasLeft()) {
      return current.getLeft();
    } else if (current.hasRight()) {
      return current.getRight();
    } else {
      // looks for the parent has a right children when you are left child
      // otherwise, keep going up
      while (current.hasParent()) {
        if (current.getParent().getLeft() == current) {
          if (current.getParent().hasRight()) {
            return current.getParent().getRight();
          }
        }
        current = current.getParent();
      }

      return null;
    }
  }

  public static <T> TreeNode<T> leftMost(TreeNode<T> current) {
    while (current.hasLeft()) {
      current = current.getLeft();
    }

    return current;
  }
}
