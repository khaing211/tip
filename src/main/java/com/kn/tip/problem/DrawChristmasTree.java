package com.kn.tip.problem;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * http://mishadoff.com/blog/code-golf-new-year-tree/
 */
public class DrawChristmasTree {
  public static void printSpace(int nSpace) {
    IntStream.rangeClosed(0, nSpace).forEach(i -> {
        System.out.print(' ');
    });
  }
  
  public static void printSpace(int nSpace, final double ratio, final Random random) {
    IntStream.rangeClosed(0, nSpace).forEach(i -> {
      if (random.nextDouble() < ratio) { 
        System.out.print('o');
      } else {
        System.out.print(' ');
      }
    });
  }
  
  public static void printBaseTree(int nSpace) {
    IntStream.rangeClosed(0, nSpace).forEach(i -> System.out.print('_'));
  }
  
  public static int branchWidth(int level) {
    return level + 2;
  }
  
  public static int halfTreeWidth(int treeWidth) {
    return treeWidth / 2;
  }
  
  /**
   * @return tree width
   */
  public static int drawTree(int maxLevel, int curleveL, double ratio, int baseLevelIndent, 
      final Random random) {
    
    if (curleveL == 0) {
      // draw star in the middle
      printSpace(baseLevelIndent + 1);
      System.out.print('*');
      System.out.println();
      return (baseLevelIndent+1)*2+1;
    }
    
    final int treeWidth = drawTree(maxLevel, curleveL - 1, ratio, baseLevelIndent + curleveL, random);
    drawBranch(maxLevel, curleveL, ratio, baseLevelIndent, treeWidth, random);
    
    return treeWidth;
  }
  
  public static void drawBranch(final int maxLevel, 
      final int curLevel, final double ratio, 
      final int baseLevelIndent, final int treeWidth,
      final Random random) {
    
    final int branchWidth = branchWidth(curLevel);
    final int halfTreeWidth = halfTreeWidth(treeWidth);
    
    for (int i = branchWidth; i > 1; i--) {
      // offset because branch width is compute with + 2 level
      final int leftIndent = baseLevelIndent + i - 2;
      
      printSpace(leftIndent);
      System.out.print('/');
      
      printSpace((halfTreeWidth - leftIndent - 1)*2, ratio, random);
      System.out.print('\\');
      
      System.out.println();
    }
    
    printSpace(baseLevelIndent - 1);
    System.out.print('/');
    System.out.print('_');
    
    final int branchSpace = (halfTreeWidth - baseLevelIndent - 1)*2;
    if (curLevel != maxLevel) {
      printSpace(branchSpace, ratio, random);
    } else {
      printBaseTree(branchSpace);
    }
    
    System.out.print('_');
    System.out.print('\\');
    System.out.println();
  }
  
  public static void drawTree(int level, double ratio) {
    final Random random = new Random();
    final int treeWidth = drawTree(level, level, ratio, 0, random);
    // draw root
    final int halfTreeWidth = halfTreeWidth(treeWidth);
    for (int i = 0; i < 2; i++) {
      printSpace(halfTreeWidth);
      System.out.println("| |");
    }

  }
  
  public static void main(String[] args) {
    drawTree(4, 0.5d);
  }
}
