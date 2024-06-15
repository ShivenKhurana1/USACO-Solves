package squarepasture;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio();
		int x1 = io.nextInt(), y1 = io.nextInt(); //coordinates seeking
		int x2 = io.nextInt(), y2 = io.nextInt();
		int x3 = io.nextInt(), y3 = io.nextInt();
		int x4 = io.nextInt(), y4 = io.nextInt();
		int l = Math.min(x1, x3); //left
		int r = Math.max(x2, x4); //right
		int b = Math.min(y1, y3); //bottom
		int t = Math.max(y2, y4); //top
		int side = Math.max(r - l, t - b);
		io.println(side * side);
		io.close();
	}

	//kattio input/output
	static class Kattio extends PrintWriter {
		private BufferedReader r;
		private StringTokenizer st;
		// standard input
		public Kattio() { this(System.in, System.out); }
		public Kattio(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}
		// USACO-style file input
		public Kattio(String problemName) throws IOException {
			super(problemName + ".out");
			r = new BufferedReader(new FileReader(problemName + ".in"));
		}
		// returns null if no more input
		public String next() {
			try {
				while (st == null || !st.hasMoreTokens())
					st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception e) { }
			return null;
		}
		public int nextInt() { return Integer.parseInt(next()); }
		public double nextDouble() { return Double.parseDouble(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}
}