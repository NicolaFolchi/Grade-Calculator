package a1;
import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
				
		int num_of_students = 0;
		String first_name = "";
		String last_name = "";
		double assignment_grade = 0.00;
		double participation_grade = 0.00;
		double midterm_grade = 0.00;
		double final_exam = 0.00;
		String letter_grade = "";
		
		//getting input of number of students. 
		
		num_of_students = keyboard.nextInt();
		
		for (int i = 0; i < num_of_students; i++) {
					
			first_name = keyboard.next();
			
			last_name = keyboard.next();
			
			assignment_grade = keyboard.nextDouble();
			
			participation_grade = keyboard.nextDouble();
			
			midterm_grade = keyboard.nextDouble();
			
			final_exam = keyboard.nextDouble();
				
			double weighted_average = (assignment_grade * 0.4) + (participation_grade * 0.15)
					+ (midterm_grade * 0.2) + (final_exam * 0.25);
			
			//This if statements calculate the weighted average 
			//of the student and then assign a letter grade
			
			if (weighted_average >= 94.00 ) {
				letter_grade = "A";
			}
			else if (weighted_average >= 90.00  && weighted_average < 94.00) {
				letter_grade = "A-";
			}
			else if (weighted_average >= 86.00  && weighted_average < 90.00) {
				letter_grade = "B+";
			}
			else if (weighted_average >= 83.00  && weighted_average < 86.00) {
				letter_grade = "B";
			}
			else if (weighted_average >= 80.00  && weighted_average < 83.00) {
				letter_grade = "B-";
			}
			else if (weighted_average >= 76.00  && weighted_average < 80.00) {
				letter_grade = "C+";
			}
			else if (weighted_average >= 73.00  && weighted_average < 76.00) {
				letter_grade = "C";
			}
			else if (weighted_average >= 70.00  && weighted_average < 73.00) {
				letter_grade = "C-";
			}
			else if (weighted_average >= 65.00  && weighted_average < 70.00) {
				letter_grade = "D+";
			}
			else if (weighted_average >= 60.00  && weighted_average < 65.00) {
				letter_grade = "D";
			}
			else if (weighted_average < 60.00) {
				letter_grade = "F";
			}
			
			//displaying the output
			System.out.println("\n" + first_name.substring(0,1) + ". " + last_name + " " + letter_grade);
			
		}

	}
}
