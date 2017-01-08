package com.kn.tip.problem.codewars;

public class BreakingChocolate {
  public static int breakChocolate(final int n, final int m) {
    // The problem is about breaking chocolate i.e. cells of dimension (n x m) into 1x1
    // Return minimum number of breaking
    //
    // Attempt 1:
    // Assumption question minimum implies there are ways that results not minimum
    // The simplest ways is to pick a side of chocolate and break into stripe (1xa) and break a times each stripe into cell of 1x1
    // Supposes you pick side n => total break: n-1 + n*(m-1) = n*m-1
    // Supposes you pick side m => total break: m-1 + m*(n-1) = n*m-1
    // Same number of break! regardless
    //
    // Proof by Induction:
    // Assume: break(x,y) = x*y-1
    // Case 1: break(1,1) = 0
    // Case 2: break(1,2) = 1
    // break(x,y) = 1 + break(k, y) + break(h, y) where k+h = x (1 cut between two pieces)
    // break(x,y) = 1 + (k*y)-1 + h*y - 1 = (k+h)*y-1 = x*y-1

    return n == 0 || m == 0 ? 0: n*m-1;
  }
}
