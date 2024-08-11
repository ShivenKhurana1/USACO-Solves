import java.util.*;

public class Main {	
	public static void main(String[] args) throws Exception {
		int MAXTIME = 1000;
		Scanner stdin = new Scanner(System.in);	
		
		int[] event = new int[MAXTIME+1];
		int n = stdin.nextInt();
		
		// Store info about each event.
		for (int i=0; i<n; i++) {
			int start = stdin.nextInt();
			int end = stdin.nextInt();
			int amt = stdin.nextInt();
			event[start] += amt;
			event[end] -= amt;
		}
		
		// Now, go in order, processing events, keeping track of max.
		int res = 0, cur = 0;
		for (int i=0; i<=MAXTIME; i++) {
			cur += event[i];
			res = Math.max(res,  cur);
		}

		// Print out the result.
		
		System.out.println(res);	
		stdin.close();
	}
}