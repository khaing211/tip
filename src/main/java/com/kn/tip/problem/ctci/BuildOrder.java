package com.kn.tip.problem.ctci;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BuildOrder {
  
  public static void main(String[] args) {
    System.out.println(Arrays.toString(buildOrder(new String[] { "P0", "P1", "P2"},
        new String[][] {
          {"P0", "P2"},
          {"P0", "P1"},
          {"P1", "P2"}
        }
    )));
    
    // cycle
    System.out.println(Arrays.toString(buildOrder(new String[] { "P0", "P2"},
        new String[][] {
          {"P0", "P2"},
          {"P2", "P0"},
        }
    )));
    
    // no dependencies
    System.out.println(Arrays.toString(buildOrder(new String[] { "P0", "P2"},
        new String[][] {
        }
    )));
    
    System.out.println(Arrays.toString(buildOrder(new String[] { "P0", "P2", "P1", "P3"},
        new String[][] {
          {"P3", "P1"}
        }
    )));
  }
  
  // first project is dependent on second project
  public static Project[] buildOrder(String[] projects, String[][] dependencies) {
    final Map<String, Project> projectMap = projectMap(projects);
    final Map<Project, Set<Project>> graph = buildGraph(projectMap, dependencies);
    final Project[] order = new Project[projects.length];
    
    int startIndex = 0;
    int nextIndex = 0;
    do {
      nextIndex = addNonDependentToOrder(order, startIndex, projectMap, graph);
      // for cyclic graph, we will reach a point where we can't decrease number of projects
      // per iteration
      if (nextIndex == startIndex) {
        return null;
      }
      startIndex = nextIndex;
    } while (startIndex < projects.length);
    
    return order;
  }
  
  public static int addNonDependentToOrder(Project[] order, int startIndex, 
      Map<String, Project> projectMap, Map<Project, Set<Project>> graph) {
    
    int endIndex = startIndex;
    for (Map.Entry<String, Project> entry : projectMap.entrySet()) {
      if (entry.getValue().getNumDependencies() == 0) {
        order[endIndex++] = entry.getValue();
        // NPE if not getOrDefault, because there is no dependencies for the first non-dependencies set
        for (Project toBeProcessedProject : graph.getOrDefault(entry.getValue(), Collections.emptySet())) {
          toBeProcessedProject.decreaseDependencies();
        }
      }
    }
    
    // we will get ConcurrentModificationException
    // if we try to remove in the loop
    for (int i = startIndex; i < endIndex; i++) {
      projectMap.remove(order[i]);
    }
    
    return endIndex;
  }
  
  public static Map<String, Project> projectMap(String[] projects) {
    final Map<String, Project> projectMap = new HashMap<>();

    for (String project : projects) {
      projectMap.put(project, new Project(project));
    }
    
    return projectMap;
  }
  
  public static Map<Project, Set<Project>> buildGraph(Map<String, Project> projectMap, String[][] dependencies) {
    final Map<Project, Set<Project>> graph = new HashMap<>();
    
    for (final String[] dependency : dependencies) {
      Project projectA = projectMap.get(dependency[0]);
      Project projectB = projectMap.get(dependency[1]);
      projectA.increaseDependencies();
      
      graph.compute(projectB, (k,v) -> {
        if (v == null) {
          v = new HashSet<Project>();
        }
        v.add(projectA);
        return v;
      });
    }
    
    return graph;
  }
  
  public static class Project {
    private final String name;
    private int numDepenendencies;
    
    public Project(String name) {
      this.name = name;
    }
    
    public int getNumDependencies() {
      return numDepenendencies;
    }
    
    public void increaseDependencies() {
      numDepenendencies++;
    }
    
    public void decreaseDependencies() {
      numDepenendencies--;
    }
    
    @Override
    public String toString() {
      return "Project [name=" + name + "]";
    }
  }
}
