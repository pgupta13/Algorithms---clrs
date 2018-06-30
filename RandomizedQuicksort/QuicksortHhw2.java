

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*This file covers solutions for both problem, question 1 and question 2, the user is asked for how he wants to select the pivot before main algorithms begins*/
public class QuicksortHhw2 {
	static int COUNTER;
	static int totalCounterVal;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter size of input array ");
		int x = in.nextInt();
		System.out.println("How do u want to choose pivot? Choose"
				+ "\n 1 : for randomly chosen pivot, or \n 2 : for 'median of three' randomly chosen indices method (Note: This is for bonus question)");
		int y = in.nextInt();

		int[] a = new int[x];
		Random rand = new Random();

		
		// for Running time statistics averaged over 30 runs
		for (int n = 1; n <= 30; n++) {
			COUNTER = 0;
			//randomly generated input array
			for (int i = 0; i < x; i++) {

				a[i] = rand.nextInt(x) + 1;
			}
		//Note: this loop is for worst case performance. to see this comment the above for loop and uncomment the below for loop
		//gives stack overflow exception when too large inputs are passed
			/*for (int i = 0; i < x; i++) {

				a[i] = 3;
			}*/
		
			if (x <= 1000) {
				System.out.print("\n\nFor run no. " + n + "\n> Input: ");
				for (int i = 0; i < x; i++) {
					System.out.print(a[i] + " ");
				}
			}
			QuicksortHhw2 obj = new QuicksortHhw2();

			obj.quicksort1(a, 0, a.length - 1, y);

			totalCounterVal = totalCounterVal + COUNTER;

			if (x <= 1000) {
				System.out.print("\n> Output: ");

				for (int i = 0; i < x; i++) {
					System.out.print(a[i] + " ");
				}
				System.out.println("\n Counter value:" + COUNTER);
			}
		}
		System.out.println(
				"\n\nAverage Counter value for 30 runs is : " + (totalCounterVal / 30) + " for Input size n=" + x);

	}

	void quicksort1(int[] a, int p, int r, int y) {
		if (p < r) {
			COUNTER++;
			int q = 0;
			if (y == 1) {
				q = partitionRandom1(a, p, r);
			} else {
				q = partitionRandom2(a, p, r);
			}
			COUNTER++;
			quicksort1(a, p, q - 1, y);
			quicksort1(a, q + 1, r, y);
			COUNTER = COUNTER + 2;
		}

	}

	int partitionRandom2(int[] a, int p, int r) {
		// bonus question solution : median of three method implementation

		Random rand = new Random();
		COUNTER = COUNTER + 4;
		int pivotindex = 0;
		int[] x = new int[3];
		for (int i = 0; i < 3; i++) {
			COUNTER = COUNTER + 5;
			x[i] = p + rand.nextInt(r - p + 1);
		}
		Arrays.sort(x);
		COUNTER = COUNTER + 1;
		if (x[0] > x[1]) {
			COUNTER = COUNTER + 1;
			if (x[1] > x[2]) {
				COUNTER++;
				pivotindex = x[1];
			} else if (x[0] > x[2]) {
				COUNTER = COUNTER + 2;
				pivotindex = x[2];
			} else {
				COUNTER = COUNTER + 2;
				pivotindex = x[0];
			}
		} else {
			COUNTER++;
			if (x[0] > x[2]) {
				COUNTER++;
				pivotindex = x[0];
			} else if (x[1] > x[2]) {
				pivotindex = x[2];
				COUNTER = COUNTER + 2;
			} else {
				pivotindex = x[1];
				COUNTER = COUNTER + 2;
			}
		}

		swap(a, pivotindex, r);
		COUNTER++;
		return partition(a, p, r);

	}

	public int partition(int[] a, int p, int r) {

		int pivot = a[r];
		int q = p;
		COUNTER = COUNTER + 4;

		for (int i = p; i < r; i++) {
			COUNTER++;
			if (a[i] > pivot) {
				swap(a, i, q);
				COUNTER++;
				q++;
			}
		}
		swap(a, q, r);
		COUNTER++;
		return q;
	}

	public int partitionRandom1(int[] a, int p, int r) {
		Random rand = new Random();
		COUNTER = COUNTER + 4;
		int pivotindex = p + rand.nextInt(r - p + 1);
		swap(a, pivotindex, r);
		COUNTER++;
		return partition(a, p, r);
	}

	void swap(int[] a, int i, int j) {

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		COUNTER = COUNTER + 3;
		// TODO Auto-generated method stub

	}
}
