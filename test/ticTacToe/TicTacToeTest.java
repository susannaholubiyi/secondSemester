package ticTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tictactoe.Player;
import tictactoe.TicTacToe;
import tictactoe.ValueOfCell;
import tictactoe.exceptions.FilledPositionException;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
    private TicTacToe ticTacToe;
    @BeforeEach
    public void setUpTicTacToe (){
        ticTacToe = new TicTacToe();
    }
    @Test
    public void boardElementsAreEmptyTest(){
        ValueOfCell[][] expected = {{ValueOfCell.EMPTY, ValueOfCell.EMPTY, ValueOfCell.EMPTY},
                                    {ValueOfCell.EMPTY, ValueOfCell.EMPTY, ValueOfCell.EMPTY},
                                    {ValueOfCell.EMPTY,ValueOfCell.EMPTY, ValueOfCell.EMPTY}};
        assertArrayEquals(expected, ticTacToe.getGameBoard());
    }
    @Test
    public void testThatThereAreTwoPlayers(){
        int numberOfPlayers = ticTacToe.getNumberOfPlayers();
        assertEquals(2, numberOfPlayers);
    }
    @Test
    public void playerOneMakesAMove_XIsPlayedTest(){
        Player playerOne = ticTacToe.getPlayers()[0];
        playerOne.play(ticTacToe,1);
        assertEquals(ValueOfCell.X, ticTacToe.getGameBoard()[0][0]);
    }
    @Test
    public void playerTwoMakesAMove_YIsPlayedTest(){
        Player playerTwo = ticTacToe.getPlayers()[1];
        playerTwo.play(ticTacToe,1);

        assertEquals(ValueOfCell.O, ticTacToe.getGameBoard()[0][0]);

    }
    @Test
    public void playerOnePlaysInPositionOne_playerTwoPlaysInPositionOne_filledPositionExceptionIsThrownTest(){
        Player playerOne = ticTacToe.getPlayers()[0];
        playerOne.play(ticTacToe,1);
        Player playerTwo = ticTacToe.getPlayers()[1];
        assertThrows(FilledPositionException.class, ()->playerTwo.play(ticTacToe,1));
    }
    @Test
    public void playerTriesToPlayPositionBelowOne_InvalidPositionExceptionIsThrownTest(){
        Player playerOne = ticTacToe.getPlayers()[0];
        assertThrows(ArrayIndexOutOfBoundsException.class, ()->playerOne.play(ticTacToe,0));
    }
    @Test
    public void playerTriesToPlayPositionAboveNine_InvalidPositionExceptionIsThrownTest(){
        Player playerOne = ticTacToe.getPlayers()[0];
        assertThrows(ArrayIndexOutOfBoundsException.class, ()->playerOne.play(ticTacToe,10));
    }
    @Test
    public void playerIdIsLessThanOne_exceptionisThrownTest(){

    }


}
