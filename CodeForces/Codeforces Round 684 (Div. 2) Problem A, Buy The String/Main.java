package buythestring;

import java.util.*;
import java.io.*;

public class Main {
    public static final int N = 300100, OO = 1000000007, T = 50, M = 1000000007, P = 6151, SQ = 280, lg = 20;
    public static final int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // fill the variables
        int c0 = sc.nextInt();
        int c1 = sc.nextInt();
        int t = sc.nextInt();
        String s = sc.next();
        int ans = 0;
        for (char u : s.toCharArray()) {
            if (u == '0') {
                ans += Math.min(c0, c1 + t);
            } else {
                ans += Math.min(c1, c0 + t);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}

