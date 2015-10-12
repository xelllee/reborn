package com.xelllee.code.tp.boardgame;

// Strategy pattern.
// The computer player's behavior/strategy can be replaced by inheriting from the interface below
// Also, the human player's behavior inherits from the same interface
// This also makes it easy to modify the game for 2 human players, 2 computer players etc.
// *extensibility and reusability.

/*
* http://www.ics.uci.edu/~emilyo/teaching/info122w2015/assignments/finalProject.html
*
* The Board Game Server should accommodate any board game that involves a grid layout and game elements on this layout,
*   including games such as Chess, Checkers, Tic-Tac-Toe, Gomoku, Connect Four, Nine Men's Morris, Chutes and Ladders, Stratego, Shogi, Pente, Battleship…
* The Board Game Server should make it as easy as possible to create implementations of new games
* The Board Game Server should provide a defined interface that all game plug-ins must follow
* The Board Game Server should be client-server, not Web-based
* The Board Game Server should provide one or more ways for people to find other players
* The Board Game Server should support personal player profiles (the specifics of which are up to you)
* The Board Game Server need only support 2-player games (but you can support more players if you want to)
* The Board Game Server should work by providing a player with a list of games they can play and allow them to choose which one to start
*
*
* Grading Criteria
* Stakeholder: the player (how is the experience of playing a game?)
* Stakeholder: future developers of the Board Game Server (how is the understandability and quality of the code and design?)
* Stakeholder: game developers (how is the extensibility of the Board Game Server in supporting new board games? how is the experience of plugging in a new game?)
* */

class SimpleMoveStrategy implements  MoveMethod {
    private  TicTacToe game;

    public SimpleMoveStrategy( TicTacToe t) {
        game = t;
    }

    public int move() {

        for (int i = 0; i <  TicTacToe.N; i++) {
            for (int j = 0; j <  TicTacToe.N; j++) {
                if (game.board[i][j] == 0)
                    return (i * 3 + j + 1);
            }
        }
        return 0;
    }
}


