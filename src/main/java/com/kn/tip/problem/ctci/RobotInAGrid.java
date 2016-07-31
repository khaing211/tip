package com.kn.tip.problem.ctci;

/**
 * Imagine a robot sitting on the upper left corner of grid with r row, c col
 * The robot can only move, right or down, but certain cells are "off-limits"
 * i.e. robot cannot step on them.
 * 
 * Find a path for robot from top left (0,0) to bottom right (r,c)
 */
public class RobotInAGrid {
  
  public static void main(String[] args) {
    System.out.println(isReachable(new boolean[][] {
      {false, true, true},
      {false, false, false},
      {true, true, false}
    }));
  }
  
  
  // true = off-limited
  public static final char OFF_LIMIT = 'O';
  public static final char START = 'X';
  public static final char UP = 'U';
  public static final char LEFT = 'L';
  
  public static boolean isReachable(boolean[][] grid) {
    int r = grid.length;
    int c = grid[0].length;
    char[][] trace = new char[r][c];
    trace[0][0] = 'X';
    
    ////////////
    for (int i = 1; i < r; i++) {
      if (!grid[i][0] && trace[i-1][0] != OFF_LIMIT) {
        trace[i][0] = UP;
      } else {
        trace[i][0] = OFF_LIMIT;
      }
    }
    
    ////////////
    for (int i = 1; i < c; i++) {
      if (!grid[0][i] && trace[0][i-1] != OFF_LIMIT) {
        trace[0][i] = LEFT;
      } else {
        trace[0][i] = OFF_LIMIT;
      }
    }
    
    for (int i = 1; i < r; i++) {
      for (int j = 1; j < c; j++) {
        if (grid[i][j]) {
          trace[i][j] = OFF_LIMIT;
        } else if (trace[i-1][j] != OFF_LIMIT) {
          trace[i][j] = UP;
        } else if (trace[i][j-1] != OFF_LIMIT) {
          trace[i][j] = LEFT;
        } else {
          trace[i][j] = OFF_LIMIT;
        }
      }
    }
    
    tracePath(trace);
    
    return trace[r-1][c-1] != OFF_LIMIT;
  }
  
  public static void tracePath(char[][] trace) {
    int r = trace.length - 1;
    int c = trace[0].length - 1;
    
    while ((r > 0 || c > 0) && trace[r][c] != OFF_LIMIT) {
      System.out.println(r + " " + c);
      if (trace[r][c] == UP) {
        r--;
      } else if (trace[r][c] == LEFT) {
        c--;
      }
    }
    
    System.out.println(r + " " + c);
  }
}
