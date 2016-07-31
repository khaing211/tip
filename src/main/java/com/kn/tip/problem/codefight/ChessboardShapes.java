package com.kn.tip.problem.codefight;

import java.util.Stack;

public class ChessboardShapes {
  public static void main(String[] args) {
    ChessboardShapes problem = new ChessboardShapes();
    System.out.println(problem.ChessboardShapes(new String[] {"g2", "h1"}));
    System.out.println(problem.ChessboardShapes(new String[] {"g2"}));
    System.out.println(problem.ChessboardShapes(new String[] {"g2", "f1"}));
  }

  public int ChessboardShapes(String[] squares) {
    if (squares.length == 0)
      return 1;
    boolean[][] visited = new boolean[8][8];
    boolean[][] board = new boolean[8][8];
    fillBlackSquares(board);
    paintWhiteSquaresToBlack(board, squares);
    int maxArea = 1;
    for (int i = 0; i < squares.length; i++) {
      final String square = squares[i];
      final int[] node = new int[] {toRowIndex(square), toColIndex(square)};
      maxArea = Math.max(maxArea, floodFillArea(board, visited, node));
    }
    return maxArea;
  }

  int floodFillArea(boolean[][] board, boolean[][] visited, int[] start) {
    final int[][] NEIGHBORS = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    int area = 0;
    Stack<int[]> traverse = new Stack<int[]>();
    traverse.push(start);
    
    while (!traverse.isEmpty()) {
      int[] node = traverse.pop();
      
      if (outOfBound(node))
        continue;
      
      // not visited and is black 
      if (!visited[node[0]][node[1]] && board[node[0]][node[1]]) {
        visited[node[0]][node[1]] = true;
        area++;
        for (int i = 0; i < NEIGHBORS.length; i++) {
          traverse.push(new int[] {node[0] + NEIGHBORS[i][0], node[1] + NEIGHBORS[i][1]});
        }
      }
    }
    
    return area;
  }

  boolean outOfBound(int[] node) {
    return node[0] < 0 || node[0] >= 8 || node[1] < 0 || node[1] >= 8;
  }

  int toRowIndex(String square) {
    return square.charAt(0) - 'a';
  }

  int toColIndex(String square) {
    return square.charAt(1) - '1';
  }

  void fillBlackSquares(boolean[][] board) {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        board[i][j] = (i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1);
      }
    }
  }

  void paintWhiteSquaresToBlack(boolean[][] board, String[] squares) {
    for (int i = 0; i < squares.length; i++) {
      String square = squares[i];
      board[toRowIndex(square)][toColIndex(square)] = true;
    }
  }
}
