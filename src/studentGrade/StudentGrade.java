package studentGrade;

public class StudentGrade{

    private static int[][] grades;
   
    
    	public static void setGrade(int[][] grades){
    		StudentGrade.grades = grades;
    		
    	}
  
  
	public static int getTotal(int[] setOfGrades){
		int total = 0;
    	
    		for (int grade : setOfGrades) {
    			total += grade;
    		}
    		
    		return total;
	}
	
	
    	public static double getAverage(int[] setOfGrades){
    		int total = 0;
    	
    		for (int grade : setOfGrades) {
    			total += grade;
    		}
    	
    		return (double) total / setOfGrades.length;
    	}
    	
    	
    	public static int getLowestScore(int subject){
    		int lowestScore = 100;
    		for(int[] studentGrades : grades){
    			
    			
    				if (studentGrades[subject] < lowestScore) {
    					lowestScore = studentGrades[subject];
    			}
    		}
    	
    		return lowestScore;
    	}
    	
    	
    	public static int getHighestScore(int subject){
    		int highestScore = 0;
    		for(int[] studentGrades : grades){
    			
    				if (studentGrades[subject] > highestScore) {
    					highestScore = studentGrades[subject];
    			}
    		}
    		
    		return highestScore;	
    	}
    	
    	
    	public static int getHighestScoringStudent(int subject){
    		int highestScoringStudent = 0;
    		for(int student = 0; student < grades.length; student ++){
    		
    			if (grades[student][subject] == getHighestScore(subject))
    			highestScoringStudent = student + 1;
    		}
    		
    		return highestScoringStudent;
    			
    	}
    	
    	
    	public static int getLowestScoringStudent(int subject){
    		int lowestScoringStudent = 0;
    		for(int student = 0; student < grades.length; student ++){
    		
    			if (grades[student][subject] == getLowestScore(subject))
    			lowestScoringStudent = student + 1;
    		}
    		
    		return lowestScoringStudent;	
    	}
    	
    	
    	public static int getTotalScoresInSubject(int subject){
    		int totalScoresInSubject = 0;
    		for(int student = 0; student < grades.length; student ++){
    				totalScoresInSubject += grades[student][subject];
    		}
    			
    		return totalScoresInSubject;
    		
    	}
    	
    	
    	public static double getAverageScoreInSubject(int subject){
    		int totalScoresInSubject = 0;
    		for(int student = 0; student < grades.length; student ++){
    				totalScoresInSubject += grades[student][subject];
    		}
    	
    		return (double) totalScoresInSubject / grades.length;
    		
    	}
    	
    	
    	public static int getNumberOfPasses(int subject){
    		int numberOfPasses = 0;
    		for(int student = 0; student < grades.length; student ++){
    		
    			if(grades[student][subject] >= 50)
    				numberOfPasses ++;
    		}
    		
    		return numberOfPasses;
    		
    	}
    	
    	
    	public static int getNumberOfFails(int subject){
    		int numberOfFails = 0;
    		for(int student = 0; student < grades.length; student ++){
    		
    			if(grades[student][subject] < 50)
    				numberOfFails ++;
    		}
    		
    		return numberOfFails;
    		
    	}
    	
    	
    	public static void getHardestSubject(){
    		int hardestCourse = 0;
    		int noOfFailures = 0;
    		
    		for (int student = 0;  student < grades.length; student++) {
    		
    			for(int subject = 0; subject < grades[student].length; subject++ ){
    			
    				if( getNumberOfFails(subject) > hardestCourse) {
    					hardestCourse = subject + 1;
    					noOfFailures = getNumberOfFails(subject);
    				}
    				
    			}
    		}
    		
    		System.out.printf("The hardest subject is Subject %d with %d failures%n", hardestCourse, noOfFailures);
    	}
    	
    	
    	public static void getEasiestSubject(){
    		int easiestCourse = 0;
    		int noOfPasses = 0;
    		
    		for (int student = 0;  student < grades.length; student++) {
    		
    			for(int subject = 0; subject < grades[student].length; subject++  ){
    			
    				if( noOfPasses < getNumberOfPasses(subject) ) {
    					easiestCourse = subject + 1;
    					noOfPasses = getNumberOfPasses(subject);
    				}
    				
    			}
    		}
    		
    		System.out.printf("The easiest subject is Subject %d with %d passes%n", easiestCourse, noOfPasses);
    	}
    	
    	
    	
    	public static void getOverallHighestScore(){
    		int overallHighestScore = 0 ;
    		int studentWithHighestScore = 0;
    		int subjectWithHighestScore = 0;
    		
    		for (int student = 0; student < grades.length; student++){
    		
    			for(int subject = 0; subject < grades[student].length; subject++){
    			
    				if (grades[student][subject] > overallHighestScore) {
    					overallHighestScore = grades[student][subject];
    					studentWithHighestScore = getHighestScoringStudent(subject);
    					subjectWithHighestScore = subject;
    				}
    			
    			}
    		
    		}
    		
    		System.out.printf("The overall highest score is scored by student %d  in subject %d scoring %d %n", 
    		(studentWithHighestScore ), (subjectWithHighestScore + 1), overallHighestScore);
    		 		
    	}
    	
    	
    	public static void getOverallLowestScore(){
    		int overallLowestScore = grades[0][0];
    		int studentWithLowestScore = 0;
    		int subjectWithLowestScore = 0;
    		
    		for (int student = 0; student < grades.length; student++){
    		
    			for(int subject = 0; subject < grades[student].length; subject++){
    			
    				if (grades[student][subject] < overallLowestScore ) {
    					overallLowestScore = grades[student][subject];
    					studentWithLowestScore = getLowestScoringStudent(subject);
    					subjectWithLowestScore = subject;
    				}
    						
    			}
    			
    		}
    			
    		System.out.printf("The overall lowest score is scored by student %d  in subject %d scoring %d %n", 
    			(studentWithLowestScore ), (subjectWithLowestScore + 1), overallLowestScore);

    	}
    	
    	
    	public static void getBestGraduatingStudent(){
    		int highestTotal = 0;
    		int studentWithHighestTotal = 0;
    		
    		for(int student = 0; student < grades.length; student++){
    		
    			if (getTotal(grades[student]) > highestTotal){
    			highestTotal = getTotal(grades[student]);
    			studentWithHighestTotal = student + 1;
    			}
    		}
    		
    		System.out.printf("Best graduating student is: Student %d scoring %d%n", studentWithHighestTotal, highestTotal);
    	}
    	
    	
    	public static void getWorstGraduatingStudent(){
    		int lowestTotal = (getTotal(grades[0]));
    		int studentWithLowestTotal = 0;
    		
    		for(int student = 0; student < grades.length; student++){
    		
    			if ((getTotal(grades[student])) < lowestTotal){
    			lowestTotal = getTotal(grades[student]);
    			studentWithLowestTotal = student ;
    			}
    		
    		}

    		System.out.printf("Worst graduating student is: Student %d scoring %d%n", (studentWithLowestTotal + 1), lowestTotal);
    	}
    	
    	
    	public static void getClassTotal(){
    		int totalOfTotals = 0;
    		
    		for(int student = 0; student < grades.length; student++){
    			totalOfTotals += getTotal(grades[student]);
    			
    		}
    		
    		System.out.printf("Class total score is: %d%n", totalOfTotals);
    		
    	}
    	
    	
    	public static void getClassAverage(){
    	
    		double finalAverage = 0.00;
    		int totalOfTotals = 0; 
    		
    		for(int student = 0; student < grades.length; student++){
    			totalOfTotals += getTotal(grades[student]);

    		}
    		finalAverage = (double) totalOfTotals / grades.length;
    		
    		System.out.printf("Class average score is: %.2f%n", finalAverage);
    	}
    	
    	
    	public static int getPosition(int[] setOfGrades){
		int total = 0;	
    		
    		for (int grade : setOfGrades) {
    			total += grade;
    			
    		}
    		
    		int position = 1;
    		
    		for(int student = 0; student < grades.length; student++ ){
    			if (total < getTotal(grades[student]) ){
    				position++;
    			
    			}
    		
    		}
    		
    		return position;
    	}
    	
    	public static void getOutput(){
    	
    		System.out.println("=========================================================================");
    		System.out.print("STUDENT\t\t");
    		for(int subjectNo = 0; subjectNo < grades[0].length; subjectNo++ ){
    			System.out.printf("SUB%d\t", (subjectNo + 1));
    		}
    		System.out.print("TOT\tAVE\t\tPOS\n");  
    		System.out.println("=========================================================================");
    		for(int studentNo = 0; studentNo < grades.length; studentNo++){
    			System.out.printf("Student%d\t", (studentNo + 1));
    			
    			for(int scores = 0; scores < grades[studentNo].length; scores++) {
    				System.out.printf("  %d\t", grades[studentNo][scores]);    
    			}
    			System.out.printf("%d\t%.2f\t\t%d", getTotal(grades[studentNo]), getAverage(grades[studentNo]), 			   getPosition(grades[studentNo]));
    			System.out.println();		
    		}
    		System.out.println("=========================================================================\n\n");
    		System.out.println("=========================================================================\n\n"); 
    		System.out.println("SUBJECT SUMMARY");
    		int subject = 0;
		for(int subjectNo = 0; subjectNo < grades[0].length; subjectNo++ ){
			
    			System.out.printf("Subject %d\t%n", (subjectNo + 1));
    			System.out.printf("Highest scoring student is: student %d scoring %d%n", 
    			getHighestScoringStudent(subject), getHighestScore(subject));
    			System.out.printf("Lowest scoring student is: student %d scoring %d%n", 
    			getLowestScoringStudent(subject), getLowestScore(subject));
    			System.out.printf("Total score is: %d%n", getTotalScoresInSubject(subject));
    			System.out.printf("Average score is: %.2f%n", getAverageScoreInSubject(subject));
    			System.out.printf("Number of passes: %d%n", getNumberOfPasses(subject)); 
    			System.out.printf("Number of fails: %d%n", getNumberOfFails(subject));
    			subject ++;
    			System.out.println();
    			System.out.println();
    			System.out.println();
    			
    			
    			
    		}
		getHardestSubject();
		getEasiestSubject();
		getOverallHighestScore();
		getOverallLowestScore();
    		System.out.println("=========================================================================\n\n");
    		System.out.println("CLASS SUMMARY");
    		System.out.println("=========================================================================");
    		getBestGraduatingStudent();
    		System.out.println("=========================================================================\n\n");

    		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    		getWorstGraduatingStudent();
    		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n");
    		System.out.println("=========================================================================");    		
    		getClassTotal();
    		getClassAverage();
    		System.out.println("=========================================================================");

    		
    		
    		  		
    	}
}
