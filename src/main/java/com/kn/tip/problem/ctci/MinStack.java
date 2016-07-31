package com.kn.tip.problem.ctci;

import java.util.Stack;

public class MinStack {
  private Stack<Integer> stack = new Stack<>();
  private Stack<Integer> minStack = new Stack<>();

  public boolean empty() {
    return stack.empty();
  }


  public int peek() {
    return stack.peek();
  }

  public int min() {
    return minStack.peek();
  }

  public int pop() {
    minStack.pop();
    return stack.pop();
  }

  public int push(int element) {
    minStack.push(Math.min(min(), element));
    return stack.push(element);
  }
}
