package com.nathan;

public class PathPrinter {
    int rowCount;
    int columnCount;
    int[][] grid;
    int [] columnName = {1, 2, 3, 4, 5, 6, 7, 8};

    //Constructor for the class
    public PathPrinter(int grid[][]) {
        this.grid = grid;
        rowCount = grid.length;
        columnCount = grid[0].length;
    }

    //Method will print all possible paths
    public void printAll(int currentRow, int currentColumn, String path) {
        if (currentRow == rowCount - 1) {
            for (int i = currentColumn; i < columnCount; i++) {
                path += "->" + "(" + columnName[i]+ "," + (currentRow+1) + ")";
            }
            System.out.println(path);
            return;
        }
        if (currentColumn == columnCount - 1) {
            for (int i = currentRow; i <= rowCount - 1; i++) {
                path += "->" + "(" + columnName[currentColumn]+ "," + (i+1) + ")";
            }
            System.out.println(path);
            return;
        }
        if(path.isEmpty())
        {
            path = path + "(" + columnName[currentColumn]+ "," + (currentRow+1) + ")";
        }
        else{
            path = path + "->" + "(" + columnName[currentColumn]+ "," + (currentRow+1) + ")";
        }

        printAll(currentRow + 1, currentColumn, path);
        printAll(currentRow, currentColumn + 1, path);

    }
}
