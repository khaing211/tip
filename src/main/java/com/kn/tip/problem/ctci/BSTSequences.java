package com.kn.tip.problem.ctci;

import java.util.LinkedList;

import com.kn.tip.datastructure.Tree;
import com.kn.tip.datastructure.TreeNode;

public class BSTSequences {
  public static void main(String[] args) {
    TreeNode<Integer> root = Tree.root(2).left(1).right(3).root();
    print(root);
  }
  
  // binary search tree is created by transversing from left to right
  // inserting each element.
  // Given BST with distinct element, print all possible arrays that could led
  // to this tree
  //
  // The only relationship is parent should always appear before child in the array
  // it does not matter if left or right order
  public static void print(TreeNode<Integer> root) {
    LinkedList<LinkedList<Integer>> sequences = listAllSequences(root);
    for (LinkedList<Integer> sequence : sequences) {
      System.out.println(sequence);
    }
  }
  
  public static LinkedList<LinkedList<Integer>> listAllSequences(TreeNode<Integer> root) {
    LinkedList<LinkedList<Integer>> results = new LinkedList<>();
    
    if (root == null) {
      return results;
    }
    
    LinkedList<LinkedList<Integer>> leftSequences = listAllSequences(root.getLeft());
    LinkedList<LinkedList<Integer>> rightSequences = listAllSequences(root.getRight());

    
    LinkedList<Integer> prefix = new LinkedList<>();
    prefix.add(root.getValue());

    if (leftSequences.size() == 0 && rightSequences.size() == 0) {
      results.add(prefix);
    } else if (leftSequences.size() == 0 || rightSequences.size() == 0) {
      results.addAll(leftSequences);
      results.addAll(rightSequences);
    } else {
      for (LinkedList<Integer> leftSequence : leftSequences) {
        for (LinkedList<Integer> rightSequence : rightSequences) {
          merge(results, leftSequence, rightSequence, prefix);
        }
      }
    }
    
    return results;
  }
  
  public static void merge(LinkedList<LinkedList<Integer>> results, 
      LinkedList<Integer> leftSequence, 
      LinkedList<Integer> rightSequence,
      LinkedList<Integer> prefix) {
    
    if (prefix.size() > 4)
      return;
    
    if (leftSequence.size() == 0 || rightSequence.size() == 0) {
      LinkedList<Integer> result = new LinkedList<>(prefix);
      result.addAll(leftSequence);
      result.addAll(rightSequence);
      results.add(result);
      return;
    }
    
    // create a permutation of left/right
    final Integer leftVal = leftSequence.pollFirst();
    prefix.addLast(leftVal);
    merge(results, leftSequence, rightSequence, prefix);
    prefix.removeLast();
    leftSequence.addFirst(leftVal);
    
    // try to pop right
    final Integer rightVal = rightSequence.pollFirst();
    prefix.addLast(rightVal);
    merge(results, leftSequence, rightSequence, prefix);
    prefix.removeLast();
    rightSequence.addFirst(rightVal);
  }
}
