package problems;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class SerializeandDeserializeBST {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(48);
        root.left = new TreeNode(46);
        root.right = new TreeNode(50);
//        System.out.println(new SerializeandDeserializeBST().serialize(root));
        String serialized = new SerializeandDeserializeBST().serialize(root);
        TreeNode deserialized = new SerializeandDeserializeBST().deserialize(serialized);

    }

    public String serialize(TreeNode root) {
        StringBuilder encodedTree = new StringBuilder();
        serialize(root, encodedTree);
        return encodedTree.toString();
    }

    private void serialize(TreeNode root, StringBuilder encodedTree) {
        if (root == null) {
            return;
        }
        encodedTree.append(root.val).append(".");
        serialize(root.left, encodedTree);
        serialize(root.right, encodedTree);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        Queue<Integer> valuesQueue = Arrays.stream(data.split("\\.")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedList::new));

        return deserialize(valuesQueue, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    private TreeNode deserialize(Queue<Integer> valuesQueue, int minValue, int maxValue) {

        if (valuesQueue.isEmpty()) {
            return null;
        }

        int current = valuesQueue.peek();

        if (current < minValue || current > maxValue) {
            return null;
        }
        valuesQueue.poll();
        TreeNode node = new TreeNode(current);
        node.left = deserialize(valuesQueue, minValue, current);
        node.right = deserialize(valuesQueue, current, maxValue);
        return node;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

}
