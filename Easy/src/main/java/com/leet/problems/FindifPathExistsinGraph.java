package com.leet.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindifPathExistsinGraph {
    public static void main(String[] args) {
        System.out.println(validPath(10, new int[][]{{4, 3}, {1, 4}, {4, 8}, {1, 7}, {6, 4}, {4, 2}, {7, 4}, {4, 0},
                {0, 9}, {5, 4}}, 5, 9));
    }

    public static boolean validPath(int n, int[][] edges, int start, int end) {
        // handle n != edges.length
        // start finish not in keys
        //edges = null

        if (edges.length == 0) {
            return false;
        }
/**
 * 10
 * [[4,3],[1,4],[4,8],[1,7],[6,4],[4,2],[7,4],[4,0],[0,9],[5,4]]
 * 5
 * 9
 */

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return traverseAndFind(graph, start, end, new HashSet<>());

    }

    private static boolean traverseAndFind(Map<Integer, Set<Integer>> graph, int source, int target, HashSet<Integer> visited) {

        for (int child : graph.get(source)) {

            if (visited.contains(child)) {
                continue;
            }

            visited.add(child);

            if (child == target) {
                return true;
            }

            if (traverseAndFind(graph, child, target, visited)) {
                return true;
            }
        }
        return false;
    }
}
