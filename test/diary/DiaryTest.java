package diary;

import diary.exception.DiaryIsLockedException;
import diary.exception.IncorrectPasswordException;
import diary.exception.InvalidIdExeception;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {
    @Test
    public void diaryIsLockedTest(){
        Diary diary = new Diary("Seyi", "1111");
        assertTrue(diary.isLocked());
    }
    @Test
    public void diaryIsLocked_unlockDiary_diaryIsUnlockedTest(){
        Diary diary = new Diary("Seun", "0000");
        assertTrue(diary.isLocked());
        diary.unlockDiary("0000");
        assertFalse(diary.isLocked());
    }
    @Test
    public void diaryIsLocked_unlockDiaryWithIncorrectPassword_InvalidPasswordExceptionIsThrownTest(){
        Diary diary = new Diary("Seun", "0000");
        assertTrue(diary.isLocked());
        assertThrows(IncorrectPasswordException.class, () ->diary.unlockDiary("1111"));
    }
    @Test
    public void  diaryIsLocked_unlockDiary_lockDiary_diaryIsLockedTest(){
        Diary diary = new Diary("Seun", "0000");
        assertTrue(diary.isLocked());
        diary.unlockDiary("0000");
        diary.lockDiary();
        assertTrue(diary.isLocked());
    }
    @Test
    public void createEntry_entryIsCreatedTest(){
        Diary diary = new Diary("Joy", "password");
        assertTrue(diary.isLocked());
        diary.unlockDiary("password");
        diary.createEntry("Title","body");
        assertEquals(1,diary.getNumberOfEntries());
    }
    @Test
    public void createEntry_entryIsCreated_deleteEntry_entryIsDeletedTest(){
        Diary diary = new Diary("Joy", "password");
        assertTrue(diary.isLocked());
        diary.unlockDiary("password");
        diary.createEntry("Title","body");
        assertEquals(1,diary.getNumberOfEntries());
        diary.deleteEntry(1);
        assertEquals(0,diary.getNumberOfEntries());
    }
    @Test
    public void deleteEntryWithAnInvalidId_invalidIdExceptionIsThrownTest(){
        Diary diary = new Diary("Joy", "password");
        assertTrue(diary.isLocked());
        diary.unlockDiary("password");
        diary.createEntry("Title","body");
        assertEquals(1,diary.getNumberOfEntries());
        assertThrows(InvalidIdExeception.class, () ->diary.deleteEntry(0));
    }
    @Test
    public void createEntryFourEntries_deleteTwo_listOfEntryIsTwoTest(){
        Diary diary = new Diary("Joy", "password");
        assertTrue(diary.isLocked());
        diary.unlockDiary("password");
        diary.createEntry("Title","body");
        diary.createEntry("Title","body");
        diary.createEntry("Title","body");
        diary.createEntry("Title","body");
        diary.deleteEntry(1);
        diary.deleteEntry(2);
        assertEquals(2,diary.getNumberOfEntries());
    }
    @Test
    public void CreateEntry_updateEntry_entryIsUpdatedTest(){
        Diary diary = new Diary("SuzieBarbieque", "password");
        diary.unlockDiary("password");
        diary.createEntry("Title","body");
        assertEquals("Title",diary.findEntry(1).getTitle());
        assertEquals("body",diary.findEntry(1).getBody());
        diary.updateEntry(1, "newTitle", "newBody");
        assertEquals("newTitle",diary.findEntry(1).getTitle());
        assertEquals("newBody",diary.findEntry(1).getBody());
    }
    @Test
    public void CreateEntry_updateEntryWithWrongId_invalidIdExceptionIsThrownTest() {
        Diary diary = new Diary("SuzieBarbieque", "password");
        diary.unlockDiary("password");
        diary.createEntry("Title", "body");
        assertEquals("Title", diary.findEntry(1).getTitle());
        assertEquals("body", diary.findEntry(1).getBody());
        assertThrows(InvalidIdExeception.class, ()->diary.updateEntry(2,"newTitle","newBody"));
    }
    @Test
    public void createEntryWithoutUnlockingDiary_diaryIsLockedExceptionIsThrownTest(){
        Diary diary = new Diary("SuzieBarbieque", "password");
        assertTrue(diary.isLocked());
        assertThrows(DiaryIsLockedException.class, ()->diary.createEntry("birthday wish list", "money"));
    }
    @Test
    public void findEntryWithoutUnlockingDiary_diaryIsLockedExceptionIsThrownTest() {
        Diary diary = new Diary("SuzieBarbieque", "password");
        diary.unlockDiary("password");
        diary.createEntry("Title", "body");
        diary.lockDiary();
        assertTrue(diary.isLocked());
        assertThrows(DiaryIsLockedException.class, () -> diary.findEntry(1));
    }
    @Test
    public void createEntry_lockDiary_updateEntryWithoutUnlockingDiary_diaryIsLockedExceptionIsThrownTest() {
        Diary diary = new Diary("SuzieBarbieque", "password");
        diary.unlockDiary("password");
        diary.createEntry("Title", "body");
        diary.lockDiary();
        assertTrue(diary.isLocked());
        assertThrows(DiaryIsLockedException.class, () -> diary.updateEntry(1,"newTitle","newBody"));
    }
    @Test
    public void deleteEntryWithoutUnlockingDiary_diaryIsLockedExceptionIsThrownTest() {
        Diary diary = new Diary("SuzieBarbieque", "password");
        diary.unlockDiary("password");
        diary.createEntry("Title", "body");
        diary.lockDiary();
        assertTrue(diary.isLocked());
        assertThrows(DiaryIsLockedException.class, () -> diary.deleteEntry(1));
    }


}
