package tictactoe.exceptions;

public class FilledPositionException extends RuntimeException{
    public FilledPositionException(String message){
        super(message);
    }
}
