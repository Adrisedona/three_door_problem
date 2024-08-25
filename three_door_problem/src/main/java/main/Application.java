
package main;

public class Application {
	public static void main(String[] args) {
		ThreeDoors threeDoors;
		try {
			do {
				threeDoors = new ThreeDoors();
				threeDoors.chooseDoor();
				threeDoors.revealGoat();
				threeDoors.revealDoor();
			} while (threeDoors.playAgain());
		} catch (InterruptedException e) {
			System.out.println("Sleep error");
		}

	}
}
