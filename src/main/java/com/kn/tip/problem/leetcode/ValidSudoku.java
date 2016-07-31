package com.kn.tip.problem.leetcode;

import java.util.Iterator;

public class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    final int[][] intBoard = getBoard(board);
    
    for (int i = 0; i < 9; i++) {
      if (!isValid(new RowIterator(intBoard, i))) {
        return false;
      }
      
      if (!isValid(new ColIterator(intBoard, i))) {
        return false;
      }
      
      if (!isValid(new BoxIterator(intBoard, i/3, i%3))) {
        return false;
      }
    }
    
    return true;
  }
  
  public boolean isValid(Iterator<Integer> iterator) {
    boolean[] vector = new boolean[10];
    while (iterator.hasNext()) {
      int next = iterator.next();
      if (next != 0 && vector[next]) {
        return false;
      }
      
      vector[next] = true;
    }
    return true;
  }
  
  public class RowIterator implements Iterator<Integer> {
    private final int[][] board;
    private final int r;

    private int i = 0;
    
    public RowIterator(int[][] board, int r) {
      this.board = board;
      this.r = r;
    }
    
    @Override
    public boolean hasNext() {
      return i < 9;
    }

    @Override
    public Integer next() {
      int next = board[r][i];
      i++;
      return next;
    }
    
    
  }
  
  public class ColIterator implements Iterator<Integer> {
    private final int[][] board;
    private final int c;

    private int i = 0;
    
    public ColIterator(int[][] board, int c) {
      this.board = board;
      this.c = c;
    }

    @Override
    public boolean hasNext() {
      return i < 9;
    }

    @Override
    public Integer next() {
      int next = board[i][c];
      i++;
      return next;
    }
  }
  
  public class BoxIterator implements Iterator<Integer> {

    private final int[][] board;
    private final int r;
    private final int c;
    
    private int i = 0;
    
    public BoxIterator(int[][] board, int r, int c) {
      this.board = board;
      this.r = r;
      this.c = c;
    }
    
    @Override
    public boolean hasNext() {
      return i < 9;
    }

    @Override
    public Integer next() {
      int next = board[r*3+i/3][c*3+i%3];
      i++;
      return next;
    }
    
  }
  
  public int[][] getBoard(char[][] board) {
    final int[][] intBoard = new int[9][9];
    
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          intBoard[i][j] = board[i][j] - '0';
        }
      }
    }
    
    return intBoard;
  }
}
