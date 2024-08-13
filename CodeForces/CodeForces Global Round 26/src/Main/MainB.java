package Main;
import java.util.Scanner;

public class MainB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of test cases
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Iterate through each test case
        for (int i = 0; i < t; i++) {
            long x = scanner.nextLong(); // Input integer x
            scanner.nextLine(); // Consume newline
            System.out.println(canBeSumOfLargeIntegers(x));
        }

        scanner.close();
    }

    public static String canBeSumOfLargeIntegers(long x) {
        if (x < 10) {
            return "NO";
        }
        long lastDigit = x % 10;
        if (lastDigit >= 5) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
