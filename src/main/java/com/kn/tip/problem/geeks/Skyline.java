package com.kn.tip.problem.geeks;

import java.util.LinkedList;
import java.util.List;

import com.google.common.collect.Iterators;
import com.google.common.collect.PeekingIterator;

public class Skyline {
  
  /**
   * Assume buildings are sorted by left
   * Assume no two buildings start at the same left?
   * 
   * Find the skyline
   * 
   * A skyline is a collection of rectangular strips. A rectangular strip is 
   * represented as a pair (left, ht) where left is x coordinate of left side 
   * of strip and ht is height of strip.
   */
  public static List<Strip> findSkyLine(Building[] buildings, int low, int high) {
    if (low == high) {
      final List<Strip> strips = new LinkedList<>();
      strips.add(Strip.create(buildings[low].left, buildings[low].height));
      strips.add(Strip.create(buildings[low].right, 0));
      return strips;
    }
    
    final int mid = (low+high)/2;
    List<Strip> left = findSkyLine(buildings, low, mid);
    List<Strip> right = findSkyLine(buildings, mid+1, high);
    List<Strip> merge = merge(left, right);
    
    return merge;
  }
  
  // the 'merge' in MergeSort
  public static List<Strip> merge(List<Strip> left, List<Strip> right) {
    final List<Strip> strips = new LinkedList<>();

    final PeekingIterator<Strip> leftIter = Iterators.peekingIterator(left.iterator());
    final PeekingIterator<Strip> rightIter = Iterators.peekingIterator(right.iterator());
    
    int leftHeight = 0;
    int rightHeight = 0;
    int maxHeight = 0;
    Strip strip;
    
    while (leftIter.hasNext() && rightIter.hasNext()) {
      // in order of left
      if (leftIter.peek().left < rightIter.peek().left) {
        strip = leftIter.next();
        leftHeight = strip.height;
      } else {
        strip = rightIter.next();
        rightHeight = strip.height;
      }
      
      // compare the height
      if (maxHeight != Math.max(leftHeight, rightHeight)) {
        maxHeight = Math.max(leftHeight, rightHeight);
        strips.add(Strip.create(strip.left, maxHeight));
      }
    }
    
    while (leftIter.hasNext()) {
      strip = leftIter.next();
      if (strip.height != maxHeight) {
        maxHeight = strip.height; 
        strips.add(Strip.create(strip.left, maxHeight));
      }
    };

    while (rightIter.hasNext()) {
      strip = rightIter.next();
      if (strip.height != maxHeight) {
        maxHeight = strip.height; 
        strips.add(Strip.create(strip.left, maxHeight));
      }
    };
    
    return strips;
  }
  
  public static void main(String[] args) {
    System.out.println(findSkyLine(new Building[] {
        Building.create(1, 11, 5), 
        Building.create(2, 6, 7), 
        Building.create(3, 13, 9),
        Building.create(12, 7, 16),
        Building.create(14, 3, 25),
        Building.create(19, 18, 22),
        Building.create(23, 13, 29),
        Building.create(24, 4, 28)
    }, 0, 7));
  }
  
  
  public static class Strip {
    public int left;
    public int height;
    
    public static Strip create(int left, int height) {
      Strip strip = new Strip();
      strip.left = left;
      strip.height = height;
      return strip;
    }
    
    @Override
    public String toString() {
      return "(" + left + ", " + height + ")";
    }
  }
  
  public static class Building {
    public int left;
    public int right;
    public int height;
    
    public static Building create(int left, int height, int right) {
      Building building = new Building();
      building.left = left;
      building.right = right;
      building.height = height;
      return building;
    }
  }
}
