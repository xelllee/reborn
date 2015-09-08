package com.xelllee.code.leetcode;

public class ValidSudoku {

    //
//    Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
//
//    The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
//
//
//    http://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png
//    A partially filled sudoku which is valid.
//
//            Note:
//    A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
//
    public static void main(String[] args) {


        String[] strings = {
                ".87654321",
                "2........",
                "3........",
                "4........",
                "5........",
                "6........",
                "7........",
                "8........",
                "9........"};
        char[][] board = new char[9][];

        for (int i = 0; i < strings.length; i++) {
            board[i] = strings[i].toCharArray();
        }
        System.out.println(makeItRight(board));
    }


    public static boolean makeItRight(char[][] board) {


        if (board == null) return false;

        boolean[][][] hits = new boolean[3][9][9];

        //encode the index
        // horizontal : 0 ,vertical :1, square:2

        for (int y = 0; y < board.length; y++) {

            for (int x = 0; x < board[y].length; x++) {

                int num = Character.getNumericValue(board[y][x]) - 1;

                if (num >= 0) {
                    //horizontal
                    if (!hits[0][y][num]) {
                        hits[0][y][num] = true;
                    } else {
                        return false;
                    }

                    //vertical
                    if (!hits[1][x][num]) {
                        hits[1][x][num] = true;
                    } else {
                        return false;
                    }

                    //sqaure
                    int index = (y / 3) * 3 + (x / 3);
                    if (!hits[2][index][num]) {
                        hits[2][index][num] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
