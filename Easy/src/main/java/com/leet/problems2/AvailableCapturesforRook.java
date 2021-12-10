package com.leet.problems2;

import java.util.Arrays;

public class AvailableCapturesforRook {

    public int numRookCaptures(char[][] board) {
        return getCaptures(getRook(board), board);
    }

    private int getCaptures(int[] rook, char[][] board) {
        int[] directions = {1, 0, -1, 0};
        int sum = 0;
        for (int i = 0; i < directions.length; i++) {
            sum += pawInDirection(directions[i], directions[(i + 1) % directions.length], new int[]{rook[0], rook[1]}, board);
        }
        return sum;
    }

    private int pawInDirection(int rowDir, int colDir, int[] rook, char[][] board) {
        while (withinBoundaries(rook)) {
            if (board[rook[0]][rook[1]] == 'p') {
                return 1;
            }
            if (board[rook[0]][rook[1]] == 'B') {
                return 0;
            }
            rook[0] += rowDir;
            rook[1] += colDir;
        }
        return 0;
    }

    private boolean withinBoundaries(int[] rook) {
        return rook[0] >= 0 && rook[1] >= 0 && rook[0] < 8 && rook[1] < 8;
    }

    private int[] getRook(char[][] board) {
        for (int row = 0; row < board.length;row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'R') {
                    return new int[]{row, col};
                }
            }
        }
        throw new IllegalStateException("No Rook found");
    }
}
