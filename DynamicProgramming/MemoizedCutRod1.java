/**
 * 
 */


import java.util.Scanner;

/**
 * @author admin
 *
 */
public class MemoizedCutRod1 {

	/**
	 * @param args
	 */

	static double[] sol;

	public static void main(String[] args) {

		System.out.println("Enter the length required");

		Scanner n = new Scanner(System.in);

		int len = n.nextInt();
		System.out.println("Enter the prices for each length");
		double[] p = new double[len];
		for (int i = 0; i < len; i++) {
			System.out.println("Enter the prices for length= "+(i+1));
			p[i] = n.nextInt();
		}
		sol = new double[p.length + 1];
		MemoizedCutRod1 obj = new MemoizedCutRod1();
		System.out.println("Optimal Value: "+obj.memoized_cut_rod(p));

		int size = sol.length - 1;
		System.out.print("Actual solution: ");
		while (size > 0) {
			System.out.print(" "+sol[size]+" ");
			size = (int) (size - sol[size]);
		}
	
	}

	public double memoized_cut_rod(double[] p) {
		int n = p.length;

		for (int i = 0; i < sol.length; i++) {
			sol[i] = 0;
		}

		double[] r = new double[n + 1];
		for (int i = 0; i <= n; i++) {
			r[i] = -1;
		}

		return runner(p, n, r, sol);

	}

	double runner(double[] p, int n, double[] r, double[] sol) {

		if (r[n] >= 0)
			return r[n];

		if (n == 0) {
			r[0] = 0;
			return 0;
		}
		double q = -1;
		for (int i = 1; i <= n; i++) {
			
			if (q < p[i - 1] + runner(p, n - i, r, sol)) {
				q = p[i - 1] + runner(p, n - i, r, sol);
				sol[n] = i;
			}

		}

		r[n] = q;
		return q;
	}

	public double max(double q, double d) {
		// TODO Auto-generated metho stub
		if (q > d) {
			return q;
		} else
			return d;

	}

	

}
