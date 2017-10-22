package com.kn.tip.problem.ctci;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.kn.tip.datastructure.Tree;
import com.kn.tip.datastructure.TreeNode;

public class CheckSubtree {
  public static void main(String[] args) {
    // linked list like
    TreeNode<Integer> root = Tree.root(6).left(5).transverseLeft().left(4).transverseLeft().left(3)
        .transverseLeft().left(2).transverseParent().transverseParent().transverseParent().right(7)
        .transverseRight().right(8).transverseRight().right(9).root();

    TreeNode<Integer> subtree = Tree.root(8).right(9).root();

    // error case
    TreeNode<Integer> subtree1 = Tree.root(6).left(2).right(9).root();

    System.out.println(checkWrongImplementation(root, subtree));
    System.out.println(checkWrongImplementation(root, root));
    System.out.println(checkWrongImplementation(root, subtree1));

    System.out.println("=== checkWithParentLink ===");
    System.out.println(checkWithParentLink(root, subtree));
    System.out.println(checkWithParentLink(root, root));
    System.out.println(checkWithParentLink(root, subtree1));

    System.out.println("=== checkWithTreeEncoding ===");
    System.out.println(checkWithTreeEncoding(root, subtree));
    System.out.println(checkWithTreeEncoding(root, root));
    System.out.println(checkWithTreeEncoding(root, subtree1));
  }

  // TODO:
  public static <T> boolean checkWithIterative(TreeNode<T> a, TreeNode<T> b) {

    Stack<T> stackA = new Stack<>();
    Stack<T> stackB = new Stack<>();

    return false;
  }

  // use Tree encoding to create list
  public static <T> boolean checkWithTreeEncoding(TreeNode<T> a, TreeNode<T> b) {
    List<T> listA = new ArrayList<T>();
    List<T> listB = new ArrayList<T>();

    PreOrderTraversal.transverse(a, i -> listA.add(i));
    PreOrderTraversal.transverse(b, i -> listB.add(i));

    return -1 != Collections.indexOfSubList(listA, listB);
  }

  // Use Successor solution
  public static <T> boolean checkWithParentLink(TreeNode<T> a, TreeNode<T> b) {
    TreeNode<T> leftSuccessor = leftMost(a);
    TreeNode<T> subTreeLeftMost = leftMost(b);

    do {
      TreeNode<T> checkLeftSuccessor = leftSuccessor;
      TreeNode<T> checkSubtreeLeftMost = subTreeLeftMost;

      do {
        if (!checkLeftSuccessor.getValue().equals(checkSubtreeLeftMost.getValue())) {
          break;
        }
        checkLeftSuccessor = Successor.nextPreOrder(checkLeftSuccessor);
        checkSubtreeLeftMost = Successor.nextPreOrder(checkSubtreeLeftMost);
      } while (checkSubtreeLeftMost != null && checkSubtreeLeftMost != null);

      if (checkSubtreeLeftMost == null && checkLeftSuccessor == null) {
        return true;
      }

    } while ((leftSuccessor = nextLeftSuccessor(leftSuccessor)) != null);

    return false;
  }

  public static <T> TreeNode<T> nextLeftSuccessor(TreeNode<T> current) {
    // sub iterator does not matter
    // as long as this function return node that does not have left child
    // the first current have to be initialized correctly i.e. the first current
    // depends on post-order, in-order, or pre-order
    while ((current = Successor.nextInOrder(current)) != null) {
      if (!current.hasLeft()) {
        return current;
      }
    }

    return null;
  }

  public static <T> TreeNode<T> leftMost(TreeNode<T> current) {
    while (current.hasLeft()) {
      current = current.getLeft();
    }

    return current;
  }

  // native solution.
  // can we do better
  // ?
  // check if b is a substree of a
  // check by value, not by reference
  public static <T> boolean checkWrongImplementation(TreeNode<T> a, TreeNode<T> b) {
    // base case for leaves node
    if (a == null && b != null)
      return false;
    if (a != null && b == null)
      return false;
    if (a == null && b == null)
      return true;

    if (a.getValue().equals(b.getValue())) {
      final boolean subtreeCheck = checkWrongImplementation(a.getLeft(), b.getLeft())
          && checkWrongImplementation(a.getRight(), b.getRight());
      if (subtreeCheck) {
        return true;
      }
    }

    return checkWrongImplementation(a.getLeft(), b) || checkWrongImplementation(a.getRight(), b);
  }
}
