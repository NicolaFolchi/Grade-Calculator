package a1;
import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		myProgram(keyboard);
		
	}
	
	public static void myProgram(Scanner keyboard) {
		
		
		
		int num_of_students = 0;
		String letter_grade = "";
		int total_sum = 0;
		
		int num_of_assignments = keyboard.nextInt();
			
		for (int i = 0; i < num_of_assignments; i++) {
			int my_assignment;
			my_assignment = keyboard.nextInt();
			
			total_sum += my_assignment;
		}
		
		int max_participation_points = keyboard.nextInt();

			num_of_students = keyboard.nextInt();
		
		
		
		for (int i = 0; i < num_of_students; i++) {
					
			
			String firstName = keyboard.next();
			String lastName = keyboard.next();
			double participationPoints = keyboard.nextDouble();
			double assignmentsPoints = 0;
			
			for (int j = 0; j < num_of_assignments; j++) {
				double assignments = keyboard.nextDouble();
				assignmentsPoints += assignments;
			}
			
			
			double midtermPoints = keyboard.nextDouble();
			double finalPoints = keyboard.nextDouble();
			double final_participation_points_calc = 100 * (participationPoints / (max_participation_points * 0.8));
			
			if(final_participation_points_calc > 100) {
				final_participation_points_calc = 100;
			}
			
			double assignment_percentage = ((assignmentsPoints / total_sum) * 100);

			double weighted_average = (assignment_percentage * 0.4) + (final_participation_points_calc * 0.15)
					+ (midtermPoints * 0.2) + (finalPoints * 0.25);
			
			
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
			System.out.println(firstName.substring(0,1) + ". " + lastName + " " + letter_grade);
			
			weighted_average = 0;
			assignmentsPoints = 0;
			
		}
	}
}