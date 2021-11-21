package problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/
public class CheckifThereisaValidPathinaGrid {
    public static void main(String[] args) {
        int[][] grid;
        grid = new int[][]{{2, 4, 3}, {6, 5, 2}};
        System.out.println(hasValidPath(grid));
        grid = new int[][]{{1, 2, 1}, {1, 2, 1}};
        System.out.println(hasValidPath(grid));
        grid = new int[][]{{1, 1, 2}};
        System.out.println(hasValidPath(grid));
        grid = new int[][]{{2}, {2}, {2}, {2}, {2}, {2}, {6}};
        System.out.println(hasValidPath(grid));
        grid = new int[][]{{2}, {2}, {2}, {2}, {2}, {2}, {6}};
        System.out.println(hasValidPath(grid));
        grid = new int[][]{{5, 2}, {6, 1}};
        System.out.println(hasValidPath(grid));
        grid = new int[][]{{4, 3}, {6, 5}};
        System.out.println(hasValidPath(grid));
        grid = new int[][]{{4, 1}, {6, 1}};
        System.out.println(hasValidPath(grid));
        grid = new int[][]{{4, 3 , 1}, {6, 5, 1}};
        System.out.println(hasValidPath(grid));
          grid = new int[][]{{2},{1}};
        System.out.println(hasValidPath(grid));


    }

    public static boolean hasValidPath(int[][] grid) {
        Map<Integer, List<Direction>> directionsPerId = getDirectionsMap();
        Queue<Next> queue = new LinkedList<>();

        if (grid.length == 1 && grid[0].length == 1) {
            return true;
        }
        directionsPerId.get(grid[0][0]).stream().forEach(direction -> queue.add(new Next(direction, 0, 0)));

        while (!queue.isEmpty()) {
            if (hasValidPath(queue, grid, directionsPerId)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasValidPath(Queue<Next> queue, int[][] grid, Map<Integer, List<Direction>> directionsPerId) {
        Next next = queue.poll();
        int row = next.row + next.direction.row;
        int col = next.col + next.direction.col;

        boolean isOutOfBounds = row < 0 || col < 0 || row >= grid.length || col >= grid[0].length;
        boolean isVisited = row == 0 && col == 0;

        if (isVisited || isOutOfBounds) {
            return false;
        }

        Direction opposite = Direction.valueOf(next.direction.opposite);

        if (!directionsPerId.get(grid[row][col]).contains(opposite)) {
            return false;
        }

        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return true;
        }

        queue.add(new Next(directionsPerId.get(grid[row][col]).stream().filter(direction -> direction != opposite).findAny().get(), row, col));
        return false;
    }

    private static Map<Integer, List<Direction>> getDirectionsMap() {
        Map<Integer, List<Direction>> directionsPerId = new HashMap<>();
        directionsPerId.put(1, List.of(Direction.LEFT, Direction.RIGHT));
        directionsPerId.put(2, List.of(Direction.UP, Direction.DOWN));
        directionsPerId.put(3, List.of(Direction.LEFT, Direction.DOWN));
        directionsPerId.put(4, List.of(Direction.RIGHT, Direction.DOWN));
        directionsPerId.put(5, List.of(Direction.UP, Direction.LEFT));
        directionsPerId.put(6, List.of(Direction.UP, Direction.RIGHT));
        return directionsPerId;
    }

    enum Direction {
        UP(-1,0,"DOWN"),
        DOWN(1,0,"UP"),
        LEFT(0,-1,"RIGHT"),
        RIGHT(0,1,"LEFT");


        private int row;
        private int col;
        private String opposite;

        Direction(int row, int col, String opposite) {
            this.row = row;
            this.col = col;
            this.opposite = opposite;
        }
    }

    private static class Next {
        Direction direction;
        int row;
        int col;

        public Next(Direction direction, int row, int col) {
            this.direction = direction;
            this.row = row;
            this.col = col;
        }
    }
}
