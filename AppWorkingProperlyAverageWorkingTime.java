package monthyHall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AppWorkingProperlyAverageWorkingTime {
	private static int counterWin = 0;
	private static int counterLoose = 0;
	private static int rightDoor;
	private static Scanner sc1;
	private static Scanner sc2;
	static List<Long> list1 = new ArrayList<Long>();
	static long addingAlllist = 0;

	public static void main(String[] args) {
		long start1 = System.currentTimeMillis();
		for (int l = 1; l <= 100; l++) {
			System.out.println("Test " + l);

			long start = System.currentTimeMillis();
			int i;
			for (i = 1; i <= 10000; i++) {

				sc1 = new Scanner(System.in);
				Random rand = new Random();
				rightDoor = rand.nextInt(3) + 1;
				// System.out.println("The right door " + rightDoor);
				// System.out.println("Which door would you like to pick?");
				int Chosendoor = rand.nextInt(3) + 1;
				chooseDoor(Chosendoor);
			}

			System.out.println("Win: " + counterWin + " Loose: " + counterLoose);
			float percentage = counterWin;
			i--;
			System.out.println("value of " + i);
			System.out.println(percentage / i * 100 + "% win rate");

			long end = System.currentTimeMillis() - start;
			System.out.println(end + " ms");
			list1.add(end);
			counterWin = 0;
			counterLoose = 0;
			System.out.println("");

		}
		for (int l = 0; l < list1.size(); l++) {
			addingAlllist += list1.get(l);
		}
		System.out.println("");
		System.out.println("Average of all " + list1.size() + " test " + addingAlllist / list1.size() + " ms");
		float end1 = System.currentTimeMillis() - start1;
		System.out.println((end1 / 1000) + " secs");
	}

	public static void chooseDoor(int i) {
		Random rand = new Random();
		Scanner sc2 = new Scanner(System.in);
		int Chosendoor = 1;

		int goat = rand.nextInt(3) + 1;

		if (i == rightDoor) {
			while (goat == i) {
				goat = rand.nextInt(3) + 1;
			}
		} else {
			while (goat != rightDoor || goat == i) {
				goat = rand.nextInt(3) + 1;
			}
		}
		// System.out.println("Would you stay in " + i + " or would you switch
		// to " + goat);
		Chosendoor = goat;
		if (Chosendoor == rightDoor) {
			// System.out.println("You win");
			counterWin++;
		} else {
			// System.out.println("you loose");
			counterLoose++;
		}

	}
}
