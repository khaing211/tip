package com.kn.tip.problem.ctci;

/**
 * A simple parking lot
 */
public class ParkingLot {
  private static int NUM_SPOTS = 10;
  
  private final Spot[] spots = new Spot[NUM_SPOTS];
  private int numOfOccupiedSpots;
  
  public boolean isFull() {
    return numOfOccupiedSpots == NUM_SPOTS;
  }
  
  public void occupied(int number) {
    if (spots[number] == null || !spots[number].occupied) {
      if (spots[number] == null) {
        spots[number] = new Spot();
        spots[number].number = number;
      }
      spots[number].occupied = true;
      numOfOccupiedSpots++;
    } else {
      throw new IllegalArgumentException("Spot " + number + " is occupied");
    } 
  }
  
  
  public static class Spot {
    public int number;
    public boolean occupied;
  }
}
