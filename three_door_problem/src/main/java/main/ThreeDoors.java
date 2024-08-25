package main;

import java.util.ArrayList;
import java.util.Arrays;

import util.Util;

public class ThreeDoors {

	private int prizeDoor;
	private int chosenDoor;
	private int goatDoor;
	private boolean changeDoors;

	public ThreeDoors() {
		prizeDoor = (int) (Math.random() * 3);
	}

	public void chooseDoor() {
		chosenDoor = pickDoor();
	}

	private int pickDoor() {
		char input;
		do {
			input = Util.pedirDatosCadena(1, 1, "Introduce the door you want (A, B or C)").toUpperCase().charAt(0);
			if (input < 'A' || input > 'C') {
				System.out.println("Such door doesn't exist, try again");
			}
		} while (input < 'A' || input > 'C');
		return input - 65;
	}

	public void revealGoat() {
		int i = 0;
		while (i < 3) {
			if (i != chosenDoor && i != prizeDoor) {
				goatDoor = i;
				System.out.printf("There's a goat in door %c%n", goatDoor + 65);
				i = 100;
			}
			i++;
		}
		changeDoors = Util.pickChar('y', 'n', "Do you want to change doors? (y/n)");
	}

	public void revealDoor() throws InterruptedException {
		if (changeDoors) {
			ArrayList<Integer> doors = new ArrayList<>(Arrays.asList(0, 1, 2));
			doors.remove((Integer) goatDoor);
			doors.remove((Integer) chosenDoor);
			chosenDoor = doors.get(0);
			System.out.printf("Now your door is %c%n", chosenDoor + 65);
		}
		System.out.println("And your door has...");
		Thread.sleep(200);
		System.out.println(chosenDoor == prizeDoor ? "Congratulations, you won the prize!" : "Sorry, your door also has a goat");
	}

	public boolean playAgain() {
		return Util.pickChar('y', 'n', "Do you want to play again? (y/n)");
	}
}
