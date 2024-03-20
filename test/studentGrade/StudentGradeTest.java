package studentGrade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class StudentGradeTest{




    	@BeforeEach
    	public void setGrade(){

		int[][] grades = {{67, 21, 49},
			  	  {98, 62, 56}, 
			  	  {93, 34, 27}, 
			  	  {78, 83, 66}};
    		
		StudentGrade.setGrade(grades);
    	}
    	
    	
    	@Test
    	public void testGetTotal(){
    	
    		int[] student1 = {67, 21, 49};
    		int expected = 137;
    		int actual = StudentGrade.getTotal(student1);
    	
    		assertEquals(expected, actual);
    	
    	}
    	
    	
    	@Test
    	public void testGetAverage(){
    	
    		int[] student2 = {98, 62, 56};
    		double expected = 72.00;
    		double actual = StudentGrade.getAverage(student2);
    	
    		assertEquals(expected, actual);
    	
    	}
    	
    	
    	@Test
    	public void testGetLowestScore(){
    	
    		int expected = 21;
    		int actual = StudentGrade.getLowestScore(1);
    	
    		assertEquals(expected, actual);

    	}
    	
    	
    	@Test
    	public void testGetHighestScore(){
    	
    		int expected = 66;
    		int actual = StudentGrade.getHighestScore(2);
    	
    		assertEquals(expected, actual);
    	}
    	
    	
    	@Test
    	public void testGetHighestScoringStudent(){
    	
    		int expected = (4);
    		int actual = StudentGrade.getHighestScoringStudent(2);
    	
    		assertEquals(expected, actual);
    	
    	}
    	
    	
    	@Test
    	public void testGetLowestScoringStudent(){
    	
    		int expected = (1);
    		int actual = StudentGrade.getLowestScoringStudent(1);
    	
    		assertEquals(expected, actual);
    	}
    	
    	
    	@Test
    	public void testGetTotalScoresInSubject(){
    	
    		int expected = 336;
    		int actual = StudentGrade.getTotalScoresInSubject(0);
    	
    		assertEquals(expected, actual);
    	}
    	
    	
    	@Test
    	public void testgetAverageScoreInSubject(){
    	
    		double expected = 49.50;
    		double actual = StudentGrade.getAverageScoreInSubject(2);
    	
    		assertEquals(expected, actual);
    	}
    	
    	
    	@Test
    	public void testgetNumberOfPasses(){
    	
    		int expected = 2;
    		int actual = StudentGrade.getNumberOfPasses(1);
    	
    		assertEquals(expected, actual);
    	}
    	
    	
    	@Test
    	public void testGetNumberOfFails(){
    	
    		int expected = 0;
    		int actual = StudentGrade.getNumberOfFails(0);
    	
    		assertEquals(expected, actual);
    	}
    }
