package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		int startAmount;
		double winChance;
		int winLimit;
		int totalSimulations = 1;
		int playsPerDay = 0;
		int originalAmount;
		int numsSimulations;
		int numsRuins = 0;
		Scanner in = new Scanner(System.in);

		System.out.println("Enter start amount: ");
		startAmount = in.nextInt();
		originalAmount = startAmount;

		System.out.println("Enter win chance: ");
		winChance = in.nextDouble();

		System.out.println("Enter win limit: ");
		winLimit = in.nextInt();

		System.out.println("How many days will you gamble?: ");
		totalSimulations = in.nextInt();
		numsSimulations = totalSimulations;

		while (totalSimulations != 0) {
			playsPerDay = 0;
			startAmount = originalAmount;
			while (startAmount > 0 && startAmount < winLimit) {

				if (Math.random() < winChance) {
					startAmount = startAmount + 1;

				} else {
					startAmount = startAmount - 1;

				}
				playsPerDay = playsPerDay + 1;
			}
			if (startAmount == 0) {
				System.out.println("Day " + totalSimulations);
				System.out.println("Plays " + playsPerDay);
				System.out.println("Ruin");
				numsRuins = numsRuins + 1;
			} else {
				System.out.println("Day " + totalSimulations);
				System.out.println("Plays " + playsPerDay);
				System.out.println("Success");
			}
			totalSimulations = totalSimulations - 1;
		}
		
		double expectedRuin = 0;
		
		if (winChance == 0.5) {
			expectedRuin = 1 - (startAmount / winLimit);
		} else {
			double alpha = (1 - winChance) / winChance;
			expectedRuin = (Math.pow(alpha, originalAmount) - Math.pow(alpha, winLimit))
					/ (1 - Math.pow(alpha, winLimit));
		}

		double ruinRate = numsRuins / (double) numsSimulations;
		System.out.println("Ruin rate from Simulation:" + ruinRate);
		System.out.println("Expected Ruin Rate:" + expectedRuin);
	}
}
