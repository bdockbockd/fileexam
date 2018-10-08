package main;

import java.util.Arrays;
import java.util.Scanner;

public class RacingManager {
	
	private static Double GOAL = 100.00;
	private static ICharacter[] characters = new ICharacter[3];
	private static boolean hasWinner = false;
	
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to CHOCOBO RACING.\nThe goal at distance 100 m.\n");
		System.out.println("Press 'any key' to START.");
		kb.nextLine();
		
		System.out.printf("Initialized Characters\n");
		initializeCharacter();
		int i = 1;
		while(!hasWinner) {
			printRound(i++);
			sortCharacter();
			decreaseObstructedDuration();
			randomObstructedCharacters();
			for(ICharacter c: characters) {
				c.run();
				printCharacterDistance(c.getClass().toString().substring(11, c.getClass().toString().length()) ,c.getDistance());
				if(checkWinner(c)) {
					printTheWinner(c.getClass().toString().substring(11, c.getClass().toString().length()));
					
				}
			}
		}
	}
	
	public Double getGoal() {
		return GOAL;
	}
	
	public static ICharacter[] getCharacters() {
		return characters;
	}

	public static boolean hasWinner() {
		return hasWinner;
	}
	
	public static void initializeCharacter() {
		characters[0] = new RunnerChocobo();
		characters[0].start();
		characters[1] = new JumperChocobo();
		characters[1].start();
		characters[2] = new Pikachu();
		characters[2].start();
	}
	
	public static void sortCharacter() {
		Arrays.sort(characters);
	}
	
	public static boolean checkWinner(ICharacter crt) {
		if(crt.getDistance() >= GOAL) {
			hasWinner = true;
			return true;
		}
		return false;
	}
	
	public static void randomObstructedCharacters() {
		int i = Provide.Library.randomChance();
		if(0 < i && i <= 20) {
			for(ICharacter c: characters) {
				if(c instanceof JumperChocobo) {
					printJumperChocoboObstructed();
					((JumperChocobo) c).obstructed();
				}
			}
		}
		else if(20 < i && i <= 40) {
			for(ICharacter c: characters) {
				if(c instanceof Pikachu) {
					printPikachuObstructed();
					((Pikachu) c).obstructed();
				}
			}
		}
		else if(40 < i && i <= 60) {
			for(ICharacter c: characters) {
				if(c instanceof Pikachu) {
					printPikachuObstructed();
					((Pikachu) c).obstructed();
				}
				if(c instanceof JumperChocobo) {
					printJumperChocoboObstructed();
					((JumperChocobo) c).obstructed();
				}
			}
		}
		
	}
	
	public static void decreaseObstructedDuration() {
		for(ICharacter c:characters) {
			if(c instanceof JumperChocobo) {
				int dur = ((JumperChocobo) c).getObstructedDuration();
				if(dur > 0) {
					((JumperChocobo) c).setObstructedDuration(--dur);
				}
				if(dur == 0) c.setSpeed(7.5);
			}
			else if(c instanceof Pikachu) {
				int dur = ((Pikachu) c).getObstructedDuration();
				if(dur > 0) {
					((Pikachu) c).setObstructedDuration(--dur);
				}
				if(dur == 0) c.setSpeed(4.0);
			}
		}
	}
	
	
	
	
	public static void printRound(int round) {
		System.out.printf("\nRound %d\n", round);
	}

	public static void printCharacterDistance(String characterName, double characterDistance) {
		System.out.printf("- %s distance : %.2f\n", characterName, characterDistance);
	}

	public static void printJumperChocoboPreparingToJump(double jumperChocoboDistance) {
		System.out.printf("- JumperChocobo distance : %.2f and preparing to jump\n", jumperChocoboDistance);
	}

	public static void printJumperChocoboObstructed() {
		System.out.printf("+ JumperChocobo has obstructed > speed down for 2 seconds\n");
	}

	public static void printPikachuObstructed() {
		System.out.printf("+ Pikachu has obstructed > stop running for 1 second\n");
	}

	public static void printTheWinner(String characterName) {
		System.out.printf("\n%s is the WINNER!", characterName);
	}

}
