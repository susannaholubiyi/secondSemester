package diary.exception;

public class DiaryIsLockedException extends RuntimeException{
    public DiaryIsLockedException (String message){
        super(message);
    }
}
