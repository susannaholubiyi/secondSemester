package tictactoe;

import tictactoe.exceptions.FilledPositionException;

public class TicTacToe {
    public Player[] players = new Player[2];
    public TicTacToe(){
        for (int rows = 0; rows < board.length; rows++){
            for (int column = 0; column < board.length; column++){
                board[rows][column] = ValueOfCell.EMPTY;
            }
        }

        Player playerOne = new Player(1,ValueOfCell.X);
        Player playerTwo = new Player(2, ValueOfCell.O);
        players[0] = playerOne;
        players[1] = playerTwo;
    }
    public ValueOfCell[][] getGameBoard() {
        return board;
    }

    public int getNumberOfPlayers(){
        return players.length;
    }
    public Player[] getPlayers() {
        return players;
    }
    public void markBoard(int playerId, int position){
        validatePosition(position);
        int row = convertToRowFrom(position);
        int column = convertToColumnFrom(position);

        ValueOfCell cell = playerId == 1 ? ValueOfCell.X : ValueOfCell.O;
        if(board[row][column] == ValueOfCell.EMPTY){
            board[row][column] = cell;
        }else {
            throw new FilledPositionException("Position has already been played");
        }

    }
    private static int convertToRowFrom(int position) {
        return (position -1) /3;
    }

    private static int convertToColumnFrom(int position) {
        return (position - 1) % 3;
    }
    private static void validatePosition(int position) {
        if (position < 0 || position > 9){
            throw new ArrayIndexOutOfBoundsException("Position is invalid");
        }
    }
    private final ValueOfCell[][]  board = new ValueOfCell[3][3];


}
