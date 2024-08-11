package contesttiming;
import java.io.*;

public class Main {
    public static int totalMins(int d, int h, int m) {
        return d * 24 * 60 + h * 60 + m;
    }

    public static void main(String[] args) {
        int d, h, m;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("ctiming.in")));
            PrintWriter pw = new PrintWriter(new FileOutputStream("ctiming.out"));

            String[] input = br.readLine().split(" ");
            d = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);
            m = Integer.parseInt(input[2]);

            if (totalMins(d, h, m) < totalMins(11, 11, 11)) {
                pw.println("-1");
            } else {
                pw.println(totalMins(d, h, m) - totalMins(11, 11, 11));
            }

            pw.flush();
            pw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

