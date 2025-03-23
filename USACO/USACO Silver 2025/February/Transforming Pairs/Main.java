import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long c = scanner.nextLong();
            long d = scanner.nextLong();

            if (a == c && b == d) {
                System.out.println(0);
                continue;
            }

            long sumInitial = a + b;
            long sumTarget = c + d;

            if (sumTarget < sumInitial) {
                System.out.println(-1);
                continue;
            } else if (sumTarget == sumInitial) {
                System.out.println(-1);
                continue;
            }

            long currentX = c;
            long currentY = d;
            long steps = 0;
            boolean possible = true;

            while (true) {
                if (currentX < a || currentY < b) {
                    possible = false;
                    break;
                }

                if (currentX == a && currentY == b) {
                    break;
                }

                if (currentX == a) {
                    if ((currentY - b) % a != 0) {
                        possible = false;
                        break;
                    } else {
                        steps += (currentY - b) / a;
                        break;
                    }
                }

                if (currentY == b) {
                    if ((currentX - a) % b != 0) {
                        possible = false;
                        break;
                    } else {
                        steps += (currentX - a) / b;
                        break;
                    }
                }

                if (currentX > currentY) {
                    long delta = currentX - a;
                    long k = delta / currentY;
                    if (k == 0) {
                        k = 1;
                    }
                    steps += k;
                    currentX -= k * currentY;
                } else {
                    long delta = currentY - b;
                    long k = delta / currentX;
                    if (k == 0) {
                        k = 1;
                    }
                    steps += k;
                    currentY -= k * currentX;
                }

                if (currentX < a || currentY < b) {
                    possible = false;
                    break;
                }
            }

            System.out.println(possible ? steps : -1);
        }
        scanner.close();
    }
}