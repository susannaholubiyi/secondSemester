package studentGrade;

import studentGrade.StudentGrade;

import java.util.Scanner;

public class StudentGradesClass{   
     public static void main(String... suzzy){
    	
    	Scanner input = new Scanner(System.in);
    	StudentGrade studentGrade = new StudentGrade();

	System.out.println("How many students do you have?");
	int numberOfStudents = input.nextInt();
	
	while (numberOfStudents <= 0){
		System.out.print("Number of students is invalid!");
		System.out.print("How many students do you have?");
		numberOfStudents = input.nextInt();	
	}
	
	System.out.println("How many subjects do they take?");
	int numberOfSubjects = input.nextInt();
	
	while (numberOfSubjects <= 0){
		System.out.print("Number of subjects is invalid!");
		System.out.print("How many subjects do they take?");
		numberOfSubjects = input.nextInt();	
	}
	
	System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>");
	System.out.println("Saved successfully!");

	int[][] newArray = new int[numberOfStudents][numberOfSubjects];
	int[] grades = new int[numberOfStudents];
	
	for(int row = 0; row < newArray.length; row++){
	
		for(int column = 0; column < newArray[row].length; column++){
			System.out.printf("%nEntering score for student %d ", (row + 1));
			System.out.printf("%nEnter score for subject %d: ", (column + 1));
			int studentScore = input.nextInt();
			newArray[row][column] = studentScore;
			
				while (studentScore < 0 || studentScore > 100){
					System.out.print("This score is invalid!");
					System.out.printf("%nEntering score for student %d ", (row + 1));
					System.out.printf("%nEnter score for subject %d: ", (column + 1));
					newArray[row][column] = studentScore;
				}
				
			System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("Saved successfully");
			
		}
	
	} 
	
	
	StudentGrade.setGrade(newArray);
	StudentGrade.getOutput();

	
    }
    
}
