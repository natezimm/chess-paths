package com.nathan;

import java.util.Scanner;

public class Main {
    public static int numberOfPaths(int rowDistance, int columnDistance) {
        if (rowDistance == 0 || columnDistance == 0)
            return 1;
        else {
            return numberOfPaths(rowDistance - 1, columnDistance) + numberOfPaths(rowDistance, columnDistance - 1);
        }
    }
    public static void main(String[] args) {
        // Create chess board
        int rows = 8;
        int columns = 8;
        int[][] chessBoard = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                chessBoard[i][j] = 0;
            }
        }

        //Initialize scanner to get King location from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter location of King");
        System.out.println("Enter row number(1-8): ");
        int kingRow = scanner.nextInt() - 1;
        System.out.println("Enter column number(1-8): ");
        int kingCol = scanner.nextInt() - 1;

        //Sum of letters of king is 41 (a=1,b=2,c=3,etc.)
        //Place holder value for location of King
        chessBoard[kingRow][kingCol] = 41;
        final int pieceRow = 7;
        final int pieceCol = 7;
        //Sum of letters of piece is 38
        //Place holder value for location of piece
        chessBoard[pieceRow][pieceCol] = 38;

        //Calculate row and column distances for Manhattan Distance
        int rowDistance = Math.abs(kingRow - pieceRow);
        int columnDistance = Math.abs(kingCol - pieceCol);
        int manhattanDistance = rowDistance + columnDistance;
        System.out.println("Shortest path between King and piece is " + manhattanDistance + " squares.");

        //Call method to calculate numbers of paths
        int numberOfPaths = numberOfPaths(rowDistance, columnDistance);
        System.out.println("The number of paths from King to piece are: " + numberOfPaths);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(chessBoard[i][j] + "   ");
            }
            System.out.println();
        }

        //Initialize object to print paths
        PathPrinter printer = new PathPrinter(chessBoard);
        printer.printAll(kingRow,kingCol,"");

    }
}
