package set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SetTest {
    private Set mySet;
    @BeforeEach
    public void setUp(){
        mySet = new Set();
    }
    @Test
    public void setIsEmptyTest() {
        assertTrue(mySet.isEmpty());
    }
    @Test
    public void addAnElement_setIsNotEmptyTest(){
        mySet.add("element1");
        assertFalse(mySet.isEmpty());
    }

    @Test
    public void getNumberOfElement(){
        mySet.add("element1");
        assertEquals(1, mySet.getNumberOfElements());
    }
    @Test
    public void addOneElement_checkIfSetContainsElementOneTest(){
        mySet.add("element1");
        assertTrue(mySet.contains("element1"));
    }
    @Test
    public void checkIfSetContainsAnElementThatHasNotBeenAdded_itReturnsFalseTest(){
        assertFalse(mySet.contains("element1"));
    }
    @Test
    public void addAnElement_removeTheElement_setIsEmptyTest(){
        mySet.add("element1");
        mySet.remove("element1");
        assertFalse(mySet.contains("element1"));
        assertTrue(mySet.isEmpty());
    }
    @Test
    public void addThreeElementsToASet_clearEverything_setIsEmptyTest(){
        mySet.add("element1");
        mySet.add("element2");
        mySet.add("element3");
        assertTrue(mySet.contains("element1"));
        assertTrue(mySet.contains("element2"));
        assertTrue(mySet.contains("element3"));
        mySet.clear();
        assertTrue(mySet.isEmpty());
    }
    @Test
    public void addThreeElementsToASet_toArrayMethodReturnsAnArrayOfTest(){
        mySet.add("element1");
        mySet.add("element2");
        mySet.add("element3");
        Object[] expected = {"element1", "element2", "element3"};
        assertArrayEquals(expected, mySet.toArray());
    }
}
