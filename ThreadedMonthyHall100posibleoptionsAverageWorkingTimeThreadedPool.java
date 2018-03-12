package experiment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadedMonthyHall100posibleoptionsAverageWorkingTimeThreadedPool implements Runnable {

	public static int counterWin = 0;
	public static int counterLoose = 0;
	public static int rightDoor;
	public static Scanner sc1;
	public static Scanner sc2;
	public static Thread t1;
	public static Thread t2;

	public static int i;
	public static int j;
	public static int overAllValue = 10000;
	public static int threadLoopValue = overAllValue / 2;
	public static long addingAlllist = 0;
	public static long start = 0;
	public static long end = 0;
	static List<Long> list1 = new ArrayList<Long>();

	public static void main(String[] args) {
		long start1 = System.currentTimeMillis();
		for (int c = 1; c <= 100; c++) {

			start = System.currentTimeMillis();
			System.out.println("Test: " + c);
			ExecutorService executor1 = Executors.newFixedThreadPool(20);

			executor1.submit(new ThreadedMonthyHall100posibleoptionsAverageWorkingTimeThreadedPool());
			executor1.shutdown();

			try {
				executor1.awaitTermination(1, TimeUnit.DAYS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Win: " + counterWin + " Loose: " + counterLoose);
			float percentage = counterWin;
			i--;
			j--;
			System.out.println(percentage / (i) * 100 + "% win rate");

			end = System.currentTimeMillis() - start;
			System.out.println(end + " ms");
			counterWin = 0;
			counterLoose = 0;
			list1.add(end);
			System.out.println();
		}
		
		for (int c = 0; c < list1.size(); c++) {
			addingAlllist += list1.get(c);
		}
		System.out.println("");
		System.out.println("Average of all " + list1.size() + " test " + addingAlllist / list1.size() + " ms");
		float end2 = System.currentTimeMillis() - start1;
		System.out.println((end2 / 1000) + " secs");
		
	}

	public static void chooseDoor(int i) {
		Random rand = new Random();
		int Chosendoor = 1;

		int goat = rand.nextInt(10) + 1;

		if (i == rightDoor) {
			while (goat == i) {
				goat = rand.nextInt(10) + 1;
			}
		} else {
			while (goat != rightDoor || goat == i) {
				goat = rand.nextInt(10) + 1;
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

	/*public static void chooseDoorT2(int i) {
		Random rand = new Random();
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

	}*/

	/*
	 * private static void ChoosingDoorPart(){ for (i = 1; i <= 1000; i++) { sc1
	 * = new Scanner(System.in); Random rand = new Random(); rightDoor =
	 * rand.nextInt(3) + 1; //System.out.println("The right door " + rightDoor);
	 * //System.out.println("Which door would you like to pick?"); int
	 * Chosendoor = rand.nextInt(3) + 1; chooseDoor(Chosendoor); } }
	 */
/*	private static void twoThreadsCombined() {
		t1 = new Thread(new Runnable() {

			public void run() {
				for (i = 1; i <= threadLoopValue; i++) {
					sc1 = new Scanner(System.in);
					Random rand = new Random();
					rightDoor = rand.nextInt(3) + 1;
					// System.out.println("The right door " + rightDoor);
					// System.out.println("Which door would you like to pick?");
					int Chosendoor = rand.nextInt(3) + 1;
					chooseDoor(Chosendoor);
				}

			}

		});
		t1.start();
		t2 = new Thread(new Runnable() {

			public void run() {
				for (j = 1; j <= threadLoopValue; j++) {
					sc1 = new Scanner(System.in);
					Random rand = new Random();
					rightDoor = rand.nextInt(3) + 1;
					// System.out.println("The right door " + rightDoor);
					// System.out.println("Which door would you like to pick?");
					int Chosendoor = rand.nextInt(3) + 1;
					chooseDoorT2(Chosendoor);
				}

			}

		});
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
	@Override
	public void run() {
		for (i = 1; i <= overAllValue; i++) {
			Random rand = new Random();
			rightDoor = rand.nextInt(10) + 1;
			 //System.out.println("The right door " + rightDoor);
			// System.out.println("Which door would you like to pick?");
			int Chosendoor = rand.nextInt(10) + 1;
			chooseDoor(Chosendoor);
		}
	}
}
