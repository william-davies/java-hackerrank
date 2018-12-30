package com.jetbrains;

import static java.lang.Math.abs;

/**
 * @author williamdavies
 * This is a medium difficulty Hackerrank problem.
 * A description of the problem can be found at https://www.hackerrank.com/challenges/magic-square-forming/problem
 */

public class FormingMagicSquare {
    /**
     *  3D array of all possible 3 by 3 magic squares.
     */
    private static final int[][][] MAGIC_SQUARES = {
            {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
            {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
            {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
            {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
            {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
            {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
            {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
            {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
    };

    /**
     * Returns the cost of converting a 2D array s into one of the possible 3 by 3 magic squares.
     * @param s             the 2D array to be converted into a magic square
     * @param magicSquare   the 2D array magic square that s will be converted into
     * @return cost         the cost of converting s to magicSquare
     */
    private static int getCost(int[][] s, int[][] magicSquare){
        int cost = 0;
        for (int row=0; row < 3; row++){
            for (int col=0; col < 3; col ++){
                cost += abs(s[row][col]-magicSquare[row][col]);
            }
        }
        return cost;
    }

    /**
     * Returns the minimal cost for which s can be converted into a magic square.
     *
     * @param s         the 2D array to be converted into a magic square
     * @return minCost  the minimum cost for which s can be converted into a magic square
     */
    static int formingMagicSquare(int[][] s) {
        int minCost = 72;
        for (int[][] magicSquare: MAGIC_SQUARES) {
            int cost = getCost(s, magicSquare);
            if (cost < minCost) {
                minCost = cost;
            }
        }
        System.out.println(minCost);
        return minCost;
    }

    public static void main(String[] args) {
        int[][] s = {
                {4, 9, 2},
                {3, 5, 7},
                {8, 1, 5},
        };

        formingMagicSquare(s);
    }
}
