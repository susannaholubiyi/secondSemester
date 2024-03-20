package diary.exception;

public class DiaryDoesNotExistException extends NullPointerException{
    public DiaryDoesNotExistException(String message){
        super(message);
    }
}
