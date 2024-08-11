package awkwarddigits;

import java.util.*;

public class Main {
    public static int power(int num, int base) {
        int n = 1;
        for (int i = 0; i < base; i++) {
            n *= num;
        }
        return n;
    }

    public static long binaryToTen(String s) {
        long n = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                n += power(2, s.length() - i - 1);
            }
        }
        return n;
    }

    public static long ternaryToTen(String s) {
        long n = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                n += (power(3, s.length() - i - 1) * (s.charAt(i) - '0'));
            }
        }
        return n;
    }

    public static void main(String[] args) {
        long ans = 0;
        Scanner scanner = new Scanner(System.in);
        String b = scanner.next();
        String t = scanner.next();
        List<Long> binary = new ArrayList<>();
        Set<Long> ternary = new HashSet<>();

        String tmpB = b;
        String tmpT = t;

        for (int i = 0; i < b.length(); i++) {
            tmpB = b.substring(0, i) + (char)((b.charAt(i) - '0' + 1) % 2 + '0') + b.substring(i + 1);
            binary.add(binaryToTen(tmpB));
            tmpB = b;
        }

        for (int i = 0; i < t.length(); i++) {
            tmpT = t.substring(0, i) + (char)((t.charAt(i) - '0' + 1) % 3 + '0') + t.substring(i + 1);
            ternary.add(ternaryToTen(tmpT));
            tmpT = t.substring(0, i) + (char)((t.charAt(i) - '0' + 2) % 3 + '0') + t.substring(i + 1);
            ternary.add(ternaryToTen(tmpT));
            tmpT = t;
        }

        for (long num : binary) {
            if (ternary.contains(num)) {
                ans = num;
                break;
            }
        }
        scanner.close();
        System.out.println(ans);
    }
}
