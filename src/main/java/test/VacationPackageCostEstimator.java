package test;
import java.util.Scanner;
public class VacationPackageCostEstimator {
	
//CHECKSTYLE: OFF
    public static void main(String[] args) {
    	//CHECKSTYLE: ON
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Vacation Package Cost Estimator");

        // Input: Destination
        System.out.print("Enter the destination of the vacation (e.g., Paris, New York City): ");
        String destination = scanner.nextLine();

        // Input: Number of Travelers
        System.out.print("Enter the number of travelers: ");
        int numberOfTravelers = scanner.nextInt();

        // Input: Duration of the Vacation
        System.out.print("Enter the duration of the vacation in days: ");
        int duration = scanner.nextInt();

        // Close the scanner
        scanner.close();

        // Calculate base cost
        double baseCost = 1000;

        // Check for popular tourist spot and add additional cost
        if (destination.equalsIgnoreCase("Paris")) {
            baseCost += 500;
        } else if (destination.equalsIgnoreCase("New York City")) {
            baseCost += 600;
        }

        // Apply group discount
        double discount = 0;
        if (numberOfTravelers > 4 && numberOfTravelers <= 10) {
            discount = 0.1;
        } else if (numberOfTravelers > 10) {
            discount = 0.2;
        }

        // Apply penalty fee
        if (duration < 7) {
            baseCost += 200;
        }

        // Apply promotion policy
        if (duration > 30 || numberOfTravelers == 2) {
            baseCost -= 200;
        }

        // Check for the maximum number of travelers
        if (numberOfTravelers > 80) {
            System.out.println("The vacation package is not available for groups of more than 80 persons.");
            return;
        }

        // Calculate the total cost after applying discounts and penalties
        double totalCost = baseCost - (baseCost * discount);

        // Check for valid inputs and provide the output
        if (totalCost >= 0) {
            System.out.println("Total cost of the vacation package: $" + totalCost);
        } else {
            System.out.println("Invalid input. Unable to calculate the cost.");
        }
    }
}
