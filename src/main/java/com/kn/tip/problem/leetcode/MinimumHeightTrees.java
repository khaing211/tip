package com.kn.tip.problem.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 * 
 * “a tree is an undirected graph in which any two vertices are connected by exactly one path. In
 * other words, any connected graph without simple cycles is a tree.”
 *
 * The height of a rooted tree is the number of edges on the longest downward path between the root
 * and a leaf.
 */
public class MinimumHeightTrees {

  public static void main(String[] args) {
    System.out.println(findMinHeightTrees(4, new int[][] {{1, 0}, {1, 2}, {1, 3}}));
    System.out.println(findMinHeightTrees(6, new int[][] {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}));

  }

  // Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
  // picking leaves till there is at most 2 left.
  public static List<Integer> findMinHeightTrees(int n, int[][] edges) {

    Set<Integer>[] graph = (Set<Integer>[]) new HashSet[n];

    for (int i = 0; i < n; i++) {
      graph[i] = new HashSet<>();
    }

    for (int i = 0; i < edges.length; i++) {
      int from = edges[i][0];
      int to = edges[i][1];
      graph[from].add(to);
      graph[to].add(from);
    }

    Set<Integer> answer = new HashSet<>();
    Set<Integer> leaves = new HashSet<>();

    // How many MHTs can a graph have at most?
    // at most 2
    while (answer.size() > 2) {
      for (int v : answer) {
        if (graph[v].size() == 1) {
          leaves.add(v);
        }
      }

      answer.removeAll(leaves);

      Set<Integer> newLeaves = new HashSet<>();

      for (int node : leaves) {
        int adjNode = graph[node].iterator().next();
        graph[adjNode].remove(node);
        if (graph[adjNode].size() == 1) {
          newLeaves.add(adjNode);
        }
      }

      // swap
      leaves = newLeaves;
    }

    return new ArrayList<>(answer);
  }
}
