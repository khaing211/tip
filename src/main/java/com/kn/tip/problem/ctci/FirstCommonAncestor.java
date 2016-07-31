package com.kn.tip.problem.ctci;

import com.kn.tip.datastructure.Tree;
import com.kn.tip.datastructure.TreeNode;

public class FirstCommonAncestor {
  public static void main(String[] args) {
    // linked list like
    TreeNode<Integer> root = Tree.root(6)
        .left(5)
        .transverseLeft()
        .left(4)
        .transverseLeft()
        .left(3)
        .transverseLeft()
        .left(2)
        .transverseParent()
        .transverseParent()
        .transverseParent()
        .right(7)
        .transverseRight()
        .right(8)
        .transverseRight()
        .right(9)
        .root();
    
    // output root
    System.out.println(cover(leftMost(root), rightMost(root).getParent()));
    
    System.out.println(cover(root, leftMost(root), rightMost(root).getParent()));
  }
  
  public static <T> TreeNode<T> leftMost(TreeNode<T> node) {
    while (node.hasLeft()) {
      node = node.getLeft();
    }
    return node;
  }
  
  public static <T> TreeNode<T> rightMost(TreeNode<T> node) {
    while (node.hasRight()) {
      node = node.getRight();
    }
    return node;
  }
  
  // if you have link to parent
  public static <T> TreeNode<T> cover(TreeNode<T> a, TreeNode<T> b) {
    int heightA = height(a);
    int heightB = height(b);

    TreeNode<T> lower = heightA > heightB ? b : a;
    TreeNode<T> higher = heightA > heightB ? a : b;
    
    higher = goUp(higher, Math.abs(heightA - heightB));

    while (lower != higher) {
      lower = lower.getParent();
      higher = higher.getParent();
    }
    
    return lower;
  }
  
  public static <T> TreeNode<T> goUp(TreeNode<T> a, int delta) {
    while (delta > 0) {
      a = a.getParent();
      delta--;
    }
    return a;
  }
  
  public static <T> int height(TreeNode<T> a) {
    int height = 0;
    while (a.hasParent()) {
      height++;
      a = a.getParent();
    }
    
    return height;
  }
  
  // no parent link
  // native version
  // fib version
  public static <T> TreeNode<T> cover(TreeNode<T> root, TreeNode<T> a, TreeNode<T> b) {
    if (cover0(root, a) && cover0(root, b)) {
      TreeNode<T> node = cover(root.getLeft(), a, b);
      if (node != null) {
        return node;
      }
      
      node = cover(root.getRight(), a, b);
      if (node != null) {
        return node;
      }
      
      return root;
    }
    
    return null;
  }
  
  // check if tree started at root contain node a
  public static <T> boolean cover0(TreeNode<T> root, TreeNode<T> a) {
    return root != null && (root == a || cover0(root.getLeft(), a) || cover0(root.getRight(), a));
  }
}
