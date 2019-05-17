package a1;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class A1Jedi {

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
		
		double[] participationPoints = new double[num_of_students];
		int[] midtermPoints = new int[num_of_students];
		double midtermAverage = 0;
		
		int[] finalPoints = new int[num_of_students];
		double finalAverage = 0;
		
		double[] final_participation_points_calc = new double[num_of_students];
		
		double[] assignmentsPoints = new double[num_of_students];
		
		int[] gradeCountArray = new int[11];
		
		
		for (int i = 0; i < num_of_students; i++) {
					
			
			String firstName = keyboard.next();
			String lastName = keyboard.next();
			participationPoints[i] = keyboard.nextDouble();

			
			for (int j = 0; j < num_of_assignments; j++) {
				double assignments = keyboard.nextDouble();
				assignmentsPoints[i] += assignments;
			}
			
			
			
			midtermPoints[i] = keyboard.nextInt();
			
			double midtermSum = 0;
			
			for (int j = 0; j < midtermPoints.length; j++) {
				midtermSum += midtermPoints[j];
			}
			
			midtermAverage = midtermSum / midtermPoints.length;
			

			
			finalPoints[i] = keyboard.nextInt();
			
			double finalSum = 0;
			
			for (int k = 0; k < finalPoints.length; k++) {
				finalSum += finalPoints[k];
			}
			
			finalAverage = finalSum / finalPoints.length;
			
	        

	        

			final_participation_points_calc[i] = 100 * (participationPoints[i] / (max_participation_points * 0.8));
			
			if(final_participation_points_calc[i] > 100) {
				final_participation_points_calc[i] = 100;
			}
		} 
		
		for (int i = 0; i < num_of_students; i++) {
			
			
			double sum = 0.0, standardDeviation = 0.0;
			
//SD calculation for raw midterm **********************************************************************************
	        for(double num : midtermPoints) {
	            sum += num;
	        }

	        double midtermMean = sum/10;

	        for(double num: midtermPoints) {
	            standardDeviation += Math.pow(num - midtermMean, 2);
	        }
	        double midtermSDCalc =  Math.sqrt(standardDeviation/10);
//*****************************************************************************************************************	        

	        
//SD Calculation for raw final*************************************************************************************
	        for(double num : finalPoints) {
	            sum += num;
	        }

	        double finalMean = sum/10;

	        for(double num: finalPoints) {
	            standardDeviation += Math.pow(num - finalMean, 2);
	        }
	        double finalSDCalc =  Math.sqrt(standardDeviation/10);
//*****************************************************************************************************************

			
			double midtermNormalized = (midtermPoints[i] - midtermAverage) / midtermSDCalc;
			double finalNormalized = (finalPoints[i] - finalAverage) / finalSDCalc;
			
		/*	for(int m = 0; m > 7; m++) {
				for(int n = 0; n > 2; n++) {
					double[][] normalArray = new double[m][n];
					
					normalArray[] 
				}
			}
*/
			
			double[][] normalArray = new double[8][2];		
			normalArray[0][0] = 2.0;
			normalArray[1][0] = 1.0;
			normalArray[2][0] = 0.0;
			normalArray[3][0] = -1.0;
			normalArray[4][0] = -1.5;
			normalArray[5][0] = -2.0;
			normalArray[6][0] = -3.0;
			normalArray[7][0] = -4.0;
			
			normalArray[0][1] = 100.00;
			normalArray[1][1] = 94.00;
			normalArray[2][1] = 85.00;
			normalArray[3][1] = 75.00;
			normalArray[4][1] = 65.00;
			normalArray[5][1] = 55.00;
			normalArray[6][1] = 30.00;
			normalArray[7][1] = 0.00;
			
			double low_normal = 0;
			double low_curved = 0;
			double high_normal = 0;
			double high_curved = 0;
						

			if (midtermNormalized >= normalArray[1][0] && midtermNormalized < normalArray[0][0]) {
				low_normal = normalArray[1][0];
				high_normal = normalArray[0][0];
				low_curved = normalArray[1][1];
				high_curved = normalArray[0][1];
			}
			else if (midtermNormalized >= normalArray[2][0] && midtermNormalized < normalArray[1][0]) {
				low_normal = normalArray[2][0];
				high_normal = normalArray[1][0];
				low_curved = normalArray[2][1];
				high_curved = normalArray[1][1];
			}
			else if (midtermNormalized >= normalArray[3][0] && midtermNormalized < normalArray[2][0]) {
				low_normal = normalArray[3][0];
				high_normal = normalArray[2][0];
				low_curved = normalArray[3][1];
				high_curved = normalArray[2][1];
			}
			else if (midtermNormalized >= normalArray[4][0] && midtermNormalized < normalArray[3][0]) {
				low_normal = normalArray[4][0];
				high_normal = normalArray[3][0];
				low_curved = normalArray[4][1];
				high_curved = normalArray[3][1];
			}			
			else if (midtermNormalized >= normalArray[5][0] && midtermNormalized < normalArray[4][0]) {
				low_normal = normalArray[5][0];
				high_normal = normalArray[4][0];
				low_curved = normalArray[5][1];
				high_curved = normalArray[4][1];
			}		
			else if (midtermNormalized >= normalArray[6][0] && midtermNormalized < normalArray[5][0]) {
				low_normal = normalArray[6][0];
				high_normal = normalArray[5][0];
				low_curved = normalArray[6][1];
				high_curved = normalArray[5][1];
			}			
			else if (midtermNormalized > normalArray[7][0] && midtermNormalized < normalArray[6][0]) {
				low_normal = normalArray[7][0];
				high_normal = normalArray[6][0];
				low_curved = normalArray[7][1];
				high_curved = normalArray[6][1];
			}			
					
			
			double midterm_curved_score = (((midtermNormalized - low_normal) /
	                 (high_normal - low_normal)) *
	               (high_curved - low_curved)) + low_curved;
			
			if (midtermNormalized >= normalArray[0][0]) {
				midterm_curved_score = 100;
			}
			else if (midtermNormalized  < normalArray[7][0]) {
				midterm_curved_score = 0;
			}
			
			
			if (finalNormalized >= normalArray[1][0] && finalNormalized < normalArray[0][0]) {
				low_normal = normalArray[1][0];
				high_normal = normalArray[0][0];
				low_curved = normalArray[1][1];
				high_curved = normalArray[0][1];
			}
			else if (finalNormalized >= normalArray[2][0] && finalNormalized < normalArray[1][0]) {
				low_normal = normalArray[2][0];
				high_normal = normalArray[1][0];
				low_curved = normalArray[2][1];
				high_curved = normalArray[1][1];
			}
			else if (finalNormalized >= normalArray[3][0] && finalNormalized < normalArray[2][0]) {
				low_normal = normalArray[3][0];
				high_normal = normalArray[2][0];
				low_curved = normalArray[3][1];
				high_curved = normalArray[2][1];
			}
			else if (finalNormalized >= normalArray[4][0] && finalNormalized < normalArray[3][0]) {
				low_normal = normalArray[4][0];
				high_normal = normalArray[3][0];
				low_curved = normalArray[4][1];
				high_curved = normalArray[3][1];
			}			
			else if (finalNormalized >= normalArray[5][0] && finalNormalized < normalArray[4][0]) {
				low_normal = normalArray[5][0];
				high_normal = normalArray[4][0];
				low_curved = normalArray[5][1];
				high_curved = normalArray[4][1];
			}		
			else if (finalNormalized >= normalArray[6][0] && finalNormalized < normalArray[5][0]) {
				low_normal = normalArray[6][0];
				high_normal = normalArray[5][0];
				low_curved = normalArray[6][1];
				high_curved = normalArray[5][1];
			}			
			else if (finalNormalized > normalArray[7][0] && finalNormalized < normalArray[6][0]) {
				low_normal = normalArray[7][0];
				high_normal = normalArray[6][0];
				low_curved = normalArray[7][1];
				high_curved = normalArray[6][1];
			}			
			
			
			
			double final_curved_score = (((finalNormalized - low_normal) /
	                 (high_normal - low_normal)) *
	               (high_curved - low_curved)) + low_curved;
			
			if (finalNormalized >= normalArray[0][0]) {
				final_curved_score = 100;
			}
			else if (finalNormalized  < normalArray[7][0]) {
				final_curved_score = 0;
			}
						
			double assignment_percentage = ((assignmentsPoints[i] / total_sum) * 100);
			double weighted_average = (assignment_percentage * 0.4) + (final_participation_points_calc[i] * 0.15)
					+ (midterm_curved_score * 0.2) + (final_curved_score * 0.25);
			
			

			
			//This if statements calculate the weighted average 
			//of the student and then assign a letter grade
			
			if (weighted_average >= 94.00 ) {
				gradeCountArray[0] += 1; 
			}
			else if (weighted_average >= 90.00  && weighted_average < 94.00) {
				gradeCountArray[1] += 1; 
			}
			else if (weighted_average >= 86.00  && weighted_average < 90.00) {
				gradeCountArray[2] += 1; 
			}
			else if (weighted_average >= 83.00  && weighted_average < 86.00) {
				gradeCountArray[3] += 1; 
			}
			else if (weighted_average >= 80.00  && weighted_average < 83.00) {
				gradeCountArray[4] += 1; 
			}
			else if (weighted_average >= 76.00  && weighted_average < 80.00) {
				gradeCountArray[5] += 1; 
			}
			else if (weighted_average >= 73.00  && weighted_average < 76.00) {
				gradeCountArray[6] += 1; 
			}
			else if (weighted_average >= 70.00  && weighted_average < 73.00) {
				gradeCountArray[7] += 1; 
			}
			else if (weighted_average >= 65.00  && weighted_average < 70.00) {
				gradeCountArray[8] += 1; 
			}
			else if (weighted_average >= 60.00  && weighted_average < 65.00) {
				gradeCountArray[9] += 1; 
			}
			else if (weighted_average < 60.00) {
				gradeCountArray[10] += 1; 
			}
		//	System.out.println(final_curved_score);
			
			//displaying the output
			//System.out.println(" " + letter_grade);
			
			
			
			weighted_average = 0;
			

		}
		
		System.out.print("A : " + gradeCountArray[0]);
		System.out.println("");
		
		System.out.print("A-: " + gradeCountArray[1]);
		System.out.println("");
		
		System.out.print("B+: " + gradeCountArray[2]);
		System.out.println("");
		
		System.out.print("B : " + gradeCountArray[3]);
		System.out.println("");
		
		System.out.print("B-: " + gradeCountArray[4]);
		System.out.println("");
		
		System.out.print("C+: " + gradeCountArray[5]);
		System.out.println("");
		
		System.out.print("C : " + gradeCountArray[6]);
		System.out.println("");
		
		System.out.print("C-: " + gradeCountArray[7]);
		System.out.println("");
		
		System.out.print("D+: " + gradeCountArray[8]);
		System.out.println("");
		
		System.out.print("D : " + gradeCountArray[9]);
		System.out.println("");
		
		System.out.print("F : " + gradeCountArray[10]);
		System.out.println("");
	}
}
