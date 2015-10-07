package com.xelllee.code.tellapart.boardgame;

/**
 * Created by xiao on 10/5/15.
 */
public class GameEngine {



    public static void main(String[] args) {

        System.out.println("Welcome to Tic-Tac-Toe.");
        System.out.println("");


        TicTacToe game = new TicTacToe();
        String move_str;
        int move1 = 0;
        int move2 = 0;
        int player_type = 0;
        TicTacToe.WinConfig w = TicTacToe.WinConfig.NONE;

        System.out.println("Please make your move selection by entering a number 1-9 corresponding to the movement key on the right.\n");
        System.out.println(game.toString());


        while (game.isWinningConfig() == TicTacToe.WinConfig.NONE) {
            do {
                move1 = game.getplayer1().getMove();
            } while (!game.setMove(move1, game.getplayer1().getPlayerType()));


            if ((w = game.isWinningConfig()) == TicTacToe.WinConfig.WIN) {
                System.out.println("");
                System.out.println(game.toString());
                System.out.println("You have beaten my poor AI!");
                break;
            } else if (w == TicTacToe.WinConfig.DRAW) {
                System.out.println("");
                System.out.println(game.toString());
                System.out.println("Well played. It is a draw!");
                break;
            }

            move2 = game.getplayer2().getMove();
            System.out.println("");
            System.out.println("You have put an X in the " + TicTacToe.getPosDescription(move1) + ". I will put a O in the " + TicTacToe.getPosDescription(move2) + ".");
            game.setMove(move2, game.getplayer2().getPlayerType());

            if (game.isWinningConfig() == TicTacToe.WinConfig.WIN) {
                System.out.println("");
                System.out.println(game.toString());
                System.out.println("I won. Thanks for playing.");
                break;
            }
            System.out.println(game.toString());
        }


    }
}
