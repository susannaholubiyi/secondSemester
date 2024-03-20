package tictactoe;

public class Player {
    private final int id;
    private final ValueOfCell cellType;

    public Player(int id, ValueOfCell cellType) {
        this.id = id;
        this.cellType = cellType;
    }

    public int getId() {
        return id;
    }
    public ValueOfCell getCellType(){
        return cellType;
    }

    public void play(TicTacToe ticTacToe, int position) {
        ticTacToe.markBoard(this.id, position);


    }



}
