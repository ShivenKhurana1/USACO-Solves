package buythestring;

import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
		int t = in.nextInt(); //fill in number of test cases
 
		while (t-- > 0) {
			int n = in.nextInt(), c0 = in.nextInt(), c1 = in.nextInt(), h = in.nextInt(), i, c = 0; //fill in the inputs for each test case
			String s = in.next();
 
			for (i = 0; i < n; i++)
				if (s.charAt(i) == '0') {
					c += Math.min(c0, c1 + h);
				} else {
					c += Math.min(c1, c0 + h);
				}
			System.out.println(c);
		}
		in.close();
	}
}