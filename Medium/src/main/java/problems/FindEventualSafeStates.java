package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static problems.FindEventualSafeStates.State.SAFE;
import static problems.FindEventualSafeStates.State.UNSAFE;

// https://leetcode.com/problems/find-eventual-safe-states/

//TODO see color solution
public class FindEventualSafeStates {
    public static void main(String[] args) {
//        int[][] nodes = {{}, {0, 2, 3, 4}, {3}, {4}, {}};
        int[][] nodes = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(eventualSafeNodes2(nodes));
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

    enum State {
        SAFE,
        UNSAFE
    }

    public static List<Integer> eventualSafeNodes2(int[][] graph) {

        State[] states = new State[graph.length];
        List<Integer> safeNodes = new ArrayList<>();

        for (int node = 0; node < graph.length; node++) {
            if (isSafe(graph, node, states)) {
                safeNodes.add(node);
            }
        }
        return safeNodes;
    }

    private static boolean isSafe(int[][] graph, int node, State[] states) {
        if (states[node] != null) {
            return states[node] == SAFE;
        }

        states[node] = UNSAFE;

        for (int child : graph[node]) {
            if (!isSafe(graph, child, states)) {
                return false;
            }
        }
        states[node] = SAFE;
        return true;
    }

}
