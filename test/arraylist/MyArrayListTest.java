package arraylist;

import ArrayList.MyArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {
    @Test
    public void confirmArrayListIsEmpty(){
        MyArrayList arrayList = new MyArrayList();
        assertTrue (arrayList.isEmpty());
    }

    @Test
    public void addToArrayList_arrayListIsNotEmptyTest(){
        MyArrayList arrayList = new MyArrayList();
        arrayList.add("susu");
        assertFalse(arrayList.isEmpty());
        String expected = "susu";
        assertEquals(expected, arrayList.get(0));
    }

    @Test
    public void addAnElementToSpecificPosition_ElementIsAddedTest(){
        MyArrayList arrayList = new MyArrayList();
        arrayList.add(1,"seyi");
        String expected = "seyi";
        assertEquals(expected, arrayList.get(1));
    }

    @Test
    public void addNewElementToExistingElement_elementIsAdded_previousElementMovesToNextIndexTest(){
        MyArrayList arrayList = new MyArrayList();
        arrayList.add("Seyi");
        arrayList.add(0,"Joy");
        assertFalse(arrayList.isEmpty());
        String expected1 = "Joy";
        assertEquals(expected1, arrayList.get(0));
        String expected2 = "Seyi";
        assertEquals(expected2, arrayList.get(1));
    }

    @Test
    public void addOneElement_removeFromArrayList_arrayListIsEmptyTest(){
        MyArrayList arrayList = new MyArrayList();
        arrayList.add("susu");
        assertFalse(arrayList.isEmpty());
        arrayList.remove(0);
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void addElementsToFillArrayList_arrayListResizes(){
        MyArrayList arrayList = new MyArrayList();
        arrayList.add("Susu");
        arrayList.add("Seyi");
        arrayList.add("Sharon");
        arrayList.add("Shalom");
        arrayList.add("Joy");
        arrayList.add("Joy");
        assertEquals(6, arrayList.size());
    }



}
