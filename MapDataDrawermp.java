package mountainp;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Collections;

public class MapDataDrawermp {

    private int[][] grid;

    public MapDataDrawermp(String filename, int rows, int cols) throws IOException {
        grid = new int[rows][cols];
        scanIn(filename, grid);
        // initialize grid 
        //read the data from the file into the grid
    }

    public void scanIn(String filename, int[][] grid) throws FileNotFoundException, IOException {
        try (Scanner read = new Scanner(new File(filename))) {
            int i = 0, j = 0;
            while (i != grid.length) {
                grid[i][j++] = Integer.parseInt(read.next());
                if (j == grid[0].length) {
                    i++;
                    j = 0;
                }
            }
        }
        /**
         * @return the min value in the entire grid
         */
    }

    public int findMinValue() {
        int min = grid[0][0];
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] < min) {
                    min = grid[x][y];
                }
            }
        }
        return min;

    }

    public int findMaxValue() {
        int max = grid[0][0];
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] > max) {
                    max = grid[x][y];
                }
            }
        }
        return max;

    }

    public int indexOfMinInColum(int colum) {

        int mincolum = grid[0][colum];
        for (int a = 0; a < grid.length; a++) {
            if (grid[a][colum] < mincolum) {
                mincolum = grid[a][colum];
            }

        }
        return mincolum;

        /**
         * @param col the column of the grid to check
         * @return the index of the row with the lowest value in the given col
         * for the grid
         */
    }

    /**
     * Draws the grid using the given Graphics object. Colors should be gray
     * scale values 0-255, scaled based on min/max values in grid
     */
    public void drawMap(Graphics g) {

        for (int x = 0; x < 480; x++) {
            for (int y = 0; y < 844; y++) {
                int c = (grid[x][y] - findMinValue()) * 255 / ((findMaxValue() - findMinValue()));
                g.setColor(new Color(c, c, c));
                g.fillRect(y, x, 1, 1);
            }
        }

    }

    /**
     * Find a path from West-to-East starting at given row. Choose a forward
     * step out of 3 possible forward locations, using greedy method described
     * in assignment.
     *
     * @return the total change in elevation traveled from West-to-East
     */
    public int drawLowestElevPath(Graphics g, int row) {
        int start = grid[row][0];
        int st;
        int nd;
        int rd;
        int min;
        
        for(int i = 0;i<=grid[0].length-1;i++){
            int current = grid[row][i];
            st = grid[row-1][i+1];
            nd = grid [row][i+1];
            rd = grid [row+1][i+1];
            //Find the far from the current value.
            int fartop = Math.abs(current - st);
            int farmid = Math.abs(current - nd);
            int farlow = Math.abs(current - rd);
        }
       
        
        
        
        
        return -1;
    }

    /**
     * @return the index of the starting row for the lowest-elevation-change
     * path in the entire grid.
     */
    public int indexOfLowestElevPath(Graphics g) {
        return -1;
    }

}
