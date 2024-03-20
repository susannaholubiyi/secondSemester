package diary;

import diary.exception.DiaryDoesNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiariesTest {
    private Diaries diaries;
    @BeforeEach
    public void setDiaries(){
        diaries = new Diaries();
    }
    @Test
    public void addOneDiaryToDiaries_diaryIsAdded(){
        diaries.add("seyi", "1234");
        assertEquals(1, diaries.size());
    }
    @Test
    public void addTwoDiaryToDiaries_twoDiaryIsAdded(){
        diaries.add("seyi", "1234");
        diaries.add("seun", "1111");
        assertEquals(2, diaries.size());
    }
    @Test
    public void addOneDiary_findDiary_diaryIsFoundTest(){
        diaries.add("seyi", "1234");
        diaries.findDiary("seyi");
        assertEquals(1, diaries.size());
    }
    @Test
    public void findDiaryWithoutAddingDiary_exceptionIsThrown(){
        assertThrows(DiaryDoesNotExistException.class, ()->diaries.findDiary("seyi"));
    }
    @Test
    public void addOneDiaryToDiaries_deleteDiary_listOfDiariesIsZeroTest(){
        diaries.add("seyi", "1234");
        diaries.deleteDiary("seyi", "1234");
        assertEquals(0, diaries.size());
    }
    @Test
    public void addOneDiaryToDiaries_deleteDiaryWithAnotherName_ExceptionIsThrownTest(){
        diaries.add("seyi", "1234");
        diaries.deleteDiary("seyi", "1234");
        assertEquals(0, diaries.size());
    }
    @Test
    public void addTwoDiaries_deleteTheFirst_find_theSecond_secondDiaryIsFoundTest(){
        diaries.add("seyi", "1234");
        diaries.add("seun", "1111");
        diaries.deleteDiary("seyi", "1234");
        Diary diary = diaries.findDiary("seun");
        assertEquals(diary,diaries.findDiary("seun"));
    }
}
