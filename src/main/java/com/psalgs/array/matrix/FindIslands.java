/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array.matrix;

/**
 *
 * @author djoshi
 *
 * http://www.geeksforgeeks.org/find-number-of-islands/
 *
 * Find the number of islands ( find no. of connected components )
 * 
 *  A group of connected 1s forms an island. For example, the below matrix contains 5 islands
 *
 * Time Complexity O(m * n) where m and n are no. of rows and columns
 *
 */
public class FindIslands {

    //No of rows and columns
    private static final int ROW = 5, COL = 5;

    private boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < ROW)
                && (col >= 0) && (col < COL)
                && (M[row][col] == 1 && !visited[row][col]);
    }

    private void DFS(int M[][], int row, int col, boolean visited[][]) {
        // These arrays are used to get row and column numbers of 8 neighbors of a given cell      
        // All possible combinations of -1, 0 and 1 for row and column neighbours, 
        // excluding (0,0) which is the current location. It is part of a for loop 
        // where k goes from 0 to 7, so the combinations will be 
        // (-1,-1), (-1,0), (-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1).
        int rowNbr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours to check if they can be connected 
        for (int k = 0; k < 8; ++k) {
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)) {
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
            }
        }
    }

    private int countIslands(int M[][]) {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        // by default cell value will be false
        boolean visited[][] = new boolean[ROW][COL];

        // Initialize count as 0 and travese through the all cells
        // of given matrix
        int count = 0;
        for (int i = 0; i < ROW; ++i) {
            for (int j = 0; j < COL; ++j) {
                if (M[i][j] == 1 && !visited[i][j]) {
                    // If a cell with value 1 is not visited yet 
                    // then new island found, visit all celss in this 
                    // island and increment island count
                    DFS(M, i, j, visited);
                    ++count;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws java.lang.Exception {
        int M[][] = {
            {1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}
        };

        FindIslands I = new FindIslands();
        System.out.println("Number of islands is: " + I.countIslands(M));
    }
}
