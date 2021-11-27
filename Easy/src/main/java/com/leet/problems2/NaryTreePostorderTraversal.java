package com.leet.problems2;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class NaryTreePostorderTraversal {
    public static void main(String[] args) {
        NaryTreePostorderTraversal main = new NaryTreePostorderTraversal();
        Node node3 = new Node(3, Arrays.asList(new Node(5), new Node(6)));
        Node root = new Node(1, Arrays.asList(node3, new Node(2), new Node(4)));
        // [5, 6, 3, 2, 4, 1]
        System.out.println(main.postorderIter(root));
    }

    public List<Integer> postorderIter(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Set<Node> visited = new HashSet<>();
        Stack<Node> nodes = new Stack<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            Node current = nodes.peek();

            if (visited.contains(current) || current.children == null || current.children.isEmpty()) {
                res.add(nodes.pop().val);
                continue;
            }

            visited.add(current);
            Collections.reverse(current.children);
            nodes.addAll(current.children);
        }

        return res;
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            postorder(root, res);
        }
        return res;
    }

    private void postorder(Node root, List<Integer> res) {
        if (root.children == null || root.children.isEmpty()) {
            res.add(root.val);
            return;
        }

        for (Node child : root.children) {
            postorder(child, res);
        }
        res.add(root.val);
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
