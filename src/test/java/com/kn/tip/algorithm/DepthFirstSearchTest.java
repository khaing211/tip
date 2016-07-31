package com.kn.tip.algorithm;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.kn.tip.algorithm.DepthFirstSearch;
import com.kn.tip.datastructure.graph.GridGraph;

public class DepthFirstSearchTest {
  @Test
  public void test2Nodes() {
    GridGraph graph = new GridGraph(2);
    graph.connect(1, 0);
    assertTrue(DepthFirstSearch.isConnected(graph, 0, 1));
    assertTrue(DepthFirstSearch.isConnected(graph, 1, 0));
  }

  @Test
  public void test3Nodes() {
    GridGraph graph = new GridGraph(3);
    graph.connect(1, 0);
    graph.connect(1, 2);

    assertTrue(DepthFirstSearch.isConnected(graph, 2, 0));
    assertTrue(DepthFirstSearch.isConnected(graph, 0, 2));
  }

  @Test
  public void testDisconnect() {
    GridGraph graph = new GridGraph(3);
    graph.connect(1, 0);

    assertFalse(DepthFirstSearch.isConnected(graph, 2, 0));
    assertFalse(DepthFirstSearch.isConnected(graph, 0, 2));
  }
}
