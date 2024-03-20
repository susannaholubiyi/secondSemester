package diary;

import diary.exception.DiaryDoesNotExistException;
import diary.exception.IncorrectPasswordException;

import java.util.ArrayList;

public class Diaries {
    public  ArrayList<Diary> diaries = new ArrayList<>();
    public void add(String userName, String password){
        Diary diary = new Diary(userName, password);
        diaries.add(diary);
    }
    public Diary findDiary(String userName){
        for(Diary diary : diaries){
            if(diary.getUserName().equals(userName)){
                return diary;
            }
        }
        throw new DiaryDoesNotExistException("Diary does not exist");
    }

    public void deleteDiary(String userName, String password){
        Diary foundDiary = findDiary(userName);
        validatePassword(password);
        diaries.remove(foundDiary);
    }
    private boolean validatePassword(String password){
        for(Diary diary : diaries){
            if(diary.getPassword().equals(password)){
                return true;
            }
        }
        throw new IncorrectPasswordException("Password is incorrect");

    }
    public int size(){
        return diaries.size();
    }
}