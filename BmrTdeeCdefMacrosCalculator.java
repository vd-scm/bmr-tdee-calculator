//======================================================================================================================================================================
//File Name : BmrTdeeCdefMacrosCalculator.java
//Author : Vince David Muego
//Copyright : Your copyright notice
//Description : This program calculates your BMR, TDEE, Caloric Deficit, and your Macronutrients.
//Disclaimer: If this program works obviously it's written by the above author. If it doesn't, I don't know who wrote it. 
//Revision History:
//Date                      Version         Change ID               Author                     Comment
//12-04-24                   2.7               123               Vince David Muego       Initial creation
//======================================================================================================================================================================
import java.util.*;
import java.io.*;

public class BmrTdeeCdefMacrosCalculator {
	
	    public static void main(String[] args) throws IOException {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	        System.out.println("Welcome to the BMR and TDEE Calculator!\n");
	        System.out.print("Enter your gender (M/F): ");
	        String gender = reader.readLine().toUpperCase();

	        System.out.print("Enter your age: ");
	        int age = Integer.parseInt(reader.readLine());

	        System.out.print("Enter your weight (in lbs): ");
	        double weight = Double.parseDouble(reader.readLine());
	        weight *= 0.453592;
	        
	        System.out.print("Enter your height (in feet): ");
	        int feet = Integer.parseInt(reader.readLine());

	        System.out.print("Enter your height (in inches): ");
	        int inches = Integer.parseInt(reader.readLine());
	        
	        double height = ((feet * 12) + inches) * 2.54; // convert height to cm
	        
	        System.out.println("Select your activity level:");
	        System.out.println("1. Sedentary (little or no exercise)");
	        System.out.println("2. Lightly active (light exercise/sports 1-3 days a week)");
	        System.out.println("3. Moderately active (moderate exercise/sports 3-5 days a week)");
	        System.out.println("4. Very active (hard exercise/sports 6-7 days a week)");
	        System.out.println("5. Extra active (very hard exercise, physical job, or training twice a day)");
	        int activityChoice = Integer.parseInt(reader.readLine());

	        // Determine activity multiplier
	        double activityMultiplier = switch (activityChoice) {
	            case 1 -> 1.2;
	            case 2 -> 1.375;
	            case 3 -> 1.55;
	            case 4 -> 1.725;
	            case 5 -> 1.9;
	            default -> {
	                System.out.println("Invalid choice. Defaulting to Sedentary.");
	                yield 1.2;
	            }
	        };
	 
class Calculator {
	public static void main(String[] args) {
		Random generator1 = new Random(3);
		System.out.print("From generator 1: " );
		for (int i = 0; i < 10; ++i) {
			System.out.print(generator1.nextInt(1000) + " ");
		}
	}
	
}

	        // Calculate BMR
	        double bmr;
	        if (gender.equals("M")) {
	            bmr = 10 * weight + 6.25 * height - 5 * age + 5;
	        } else {
	            bmr = 10 * weight + 6.25 * height - 5 * age - 161;
	        }

	        // Calculate TDEE
	        double tdee = bmr * activityMultiplier;

	        // Display results
	        System.out.printf("Your BMR is: %.2f calories/day%n", bmr);
	        System.out.printf("Your TDEE (based on activity level) is: %.2f calories/day%n", tdee);

	        // Optional: Ask for caloric goal
	        System.out.print("Enter your desired caloric deficit or surplus (e.g., -500 for deficit): ");
	        double calorieGoal = Double.parseDouble(reader.readLine());
	        double goalCalories = (tdee - calorieGoal);

	        System.out.printf("Your goal caloric intake is: %.2f calories/day%n", goalCalories);
	        
	        if (goalCalories < bmr) {
	            System.out.println("\nWarning: Your goal caloric intake is below your BMR. This might be unsafe or unsustainable.");
	        }

	        // Macro breakdown (e.g., 40% carbs, 30% protein, 30% fat)
	        double carbs = goalCalories * 0.3 / 4;  // Carbs have 4 calories per gram
	        // double protein = goalCalories * 0.4 / 4; // Protein has 4 calories per gram
	        double protein = weight * 2.0;
	        double fat = goalCalories * 0.3 / 9;    // Fat has 9 calories per gram

	        System.out.printf("\nMacronutrient breakdown:%n");
	        System.out.printf("Carbs: %.2f g/day%n", carbs);
	        System.out.printf("Protein: %.2f g/day%n", protein);
	        System.out.printf("Fat: %.2f g/day%n", fat);
	    }
	}
