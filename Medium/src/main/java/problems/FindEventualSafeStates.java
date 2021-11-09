package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/find-eventual-safe-states/
public class FindEventualSafeStates {
    public static void main(String[] args) {
//        int[][] nodes = {{}, {0, 2, 3, 4}, {3}, {4}, {}};
        int[][] nodes = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(eventualSafeNodes(nodes));
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        Set<Integer> safeNodes = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            eventualSafeNodes(i, graph, safeNodes, visited);
        }
        List<Integer> sorted = new ArrayList<>(safeNodes);
        Collections.sort(sorted);
        return sorted;
    }

    public static boolean eventualSafeNodes(int i, int[][] graph, Set<Integer> safeNodes, boolean[] visited) {
        if (graph[i].length == 0) {
            safeNodes.add(i);
            return true;
        }

        visited[i] = true;

        for (int j = 0; j < graph[i].length; j++) {
            if (!safeNodes.contains(graph[i][j]) && (visited[graph[i][j]] || !eventualSafeNodes(graph[i][j], graph, safeNodes, visited))) {
                return false;
            }
        }
        safeNodes.add(i);
        return true;
    }

}
