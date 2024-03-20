package diary;

import diary.exception.DiaryIsLockedException;
import diary.exception.IncorrectPasswordException;

import java.util.ArrayList;

public class Diary {

    public Diary(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    public boolean isLocked() {
        return isLocked;
    }
    public void unlockDiary(String password) {
        if (!this.password.equals(password)){
            throw new IncorrectPasswordException("Password is incorrect, enter a correct pin");
        }        isLocked = false;
    }

    public void lockDiary() {
        isLocked = !isLocked;
    }
    public void createEntry(String title, String body) {
        validateIsLocked();
        Entry newEntry = new Entry(numberOfEntries, title, body);
            entries.add(newEntry);
            numberOfEntries++;

    }

    public int getNumberOfEntries() {
        validateIsLocked();
        return entries.size();
    }

    public void deleteEntry(int id) {
        validateIsLocked();
        Entry foundEntry = findEntry(id);

        entries.remove(foundEntry);
    }

    public Entry findEntry(int id) {
        validateIsLocked();
        for(Entry entry : entries) {
            if (entry.getId() == id)
                return entry;

        }
        throw new diary.exception.InvalidIdExeception("Id is invalid, enter a valid Id");
    }
    public void updateEntry(int id, String title, String body) {
        validateIsLocked();
        Entry foundEntry = findEntry(id);
        foundEntry.updateTitle(title);
        foundEntry.updateBody(body);
    }
    @Override
    public String toString(){
        return this.userName;
    }
    private boolean isLocked = true;
    private final String userName;
    private final String password;
    private int numberOfEntries = 1;
    private final ArrayList<Entry> entries = new ArrayList<>();
    private void validateIsLocked() {
        if(isLocked){
            throw new DiaryIsLockedException("Unlock diary");
        }
    }


}
