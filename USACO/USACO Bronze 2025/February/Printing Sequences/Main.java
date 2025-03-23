import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[] s = new int[N];
            for (int i = 0; i < N; i++) {
                s[i] = scanner.nextInt();
            }

            int[][] dp = new int[N + 1][N + 1];

            // Initialize with a large value
            for (int i = 0; i <= N; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
                dp[i][i] = 0; // Empty sequence needs 0 PRINTs
            }

            for (int len = 1; len <= N; len++) {
                for (int i = 0; i + len <= N; i++) {
                    int j = i + len;

                    // Option 1: Use a PRINT for the first element
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i + 1][j]);

                    // Option 2: Split into two parts [i, k) and [k, j)
                    for (int k = i + 1; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    }

                    // Option 3: Check if the entire segment can be formed by REP
                    for (int m = 1; m <= len; m++) {
                        if (len % m != 0) {
                            continue;
                        }
                        int o = len / m;
                        boolean valid = true;
                        for (int rep = 1; rep < o; rep++) {
                            for (int p = 0; p < m; p++) {
                                int pos = i + rep * m + p;
                                if (pos >= j || s[pos] != s[i + p]) {
                                    valid = false;
                                    break;
                                }
                            }
                            if (!valid) {
                                break;
                            }
                        }
                        if (valid) {
                            dp[i][j] = Math.min(dp[i][j], dp[i][i + m]);
                        }
                    }
                }
            }

            System.out.println(dp[0][N] <= K ? "YES" : "NO");
        }
        scanner.close();
    }
}