package com.jetbrains;

/**
 * Medium difficulty Hackerrank problem.
 * Description can be found at https://www.hackerrank.com/challenges/the-grid-search/problem.
 *
 *  @author williamdavies
 */
public class GridSearch {
    /**
     * Returns a boolean indicating if the pattern exists at the given index in String array G.
     * In other words if the top-left element of the pattern, <code>P[0].charAt(0)</code>, is at </code>G[starting_row].chartAt(starting_column)</code>
     * and all other elements of the pattern are at the appropriate indices in G.
     *
     * @param G             A String array, the grid to search
     * @param P             A String array, the pattern to search for
     * @param starting_row  The first row of the pattern if it exists at the given index
     * @param starting_col  The first column of the pattern if it exists at the given index
     * @param r             The number of rows in the pattern grid
     * @param c             The number of columns in the pattern grid
     * @return              <code>true</code> if the pattern exists at the given starting_row and starting_col;
     *                      <code>false</code> otherwise.
     */
    private static boolean patternExists(String[] G, String[] P, int starting_row, int starting_col, int r, int c){
        // iterate from row 0 of pattern to final row of pattern
        for (int row = starting_row; row < starting_row + r; row++){
            // iterate from col 0 of pattern to final col of pattern
            for (int col = starting_col; col < starting_col + c; col++){
                // subtract starting_row and starting_col when getting char at specific index of P. This
                // is because P[0].charAt(0) will be at G[starting_row].charAt(starting_col)
                if (G[row].charAt(col) != (P[row - starting_row].charAt(col - starting_col))){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns a string indicating if the pattern grid exists in grid G
     *
     * @param G     A String array, the grid to search
     * @param P     A String array, the pattern to search for
     * @param R     The number of rows in G
     * @param C     The number of columns in G
     * @param r     The number of rows in P
     * @param c     The number of columns in P
     * @return      YES if the pattern in exists in grid G;
     *              NO otherwise
     */
    static String gridSearch(String[] G, String[] P, int R, int C, int r, int c) {
        // search for pattern from row 0 to final row at which the pattern could exist, restricted by the number of rows of the pattern itself
        for (int row = 0; row <= R - r; row++){
            // search for pattern from col 0 to final col at which the pattern could exist, restricted by the number of cols of the pattern itself
            for (int col = 0; col <= C - c; col++){
                boolean exists = patternExists(G, P, row, col, r, c);
                if (exists){
                    return "YES";
                }
            }
        }
        return "NO";
    }

    public static void main(String[] args){
        String[] G = {"7283455864", "6731158619", "8988242643", "3830589324", "2229505813", "5633845374", "6473530293", "7053106601", "0834282956", "4607924137"};
        String[] P = {"9505", "3845", "3530"};
        int R = 10;
        int r = 3;
        int C = 10;
        int c = 4;
        String result = gridSearch(G, P, R, r, C, c);
        System.out.println(result);
    }
}
