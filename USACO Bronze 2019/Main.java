import java.io.*;
import java.util.*;

public class Main {
    private static long n;
    private static BufferedReader fin;
    private static BufferedWriter fout;
    private static class Segment {
        String which;
        int lower;
        int upper;
    }
    private static List<Segment> road = new ArrayList<>();
    private static int lower = 0;
    private static int upper = 1000000;

    private static void calc(int i) {
        if (road.get(i).which.equals("none")) {
            lower = Math.max(lower, road.get(i).lower);
            upper = Math.min(upper, road.get(i).upper);
        } else if (road.get(i).which.equals("on")) {
            lower -= road.get(i).upper;
            upper -= road.get(i).lower;
        } else {
            lower += road.get(i).lower;
            upper += road.get(i).upper;
        }
        lower = Math.max(lower, 0);
    }

    private static void calc2(int i) {
        if (road.get(i).which.equals("none")) {
            lower = Math.max(lower, road.get(i).lower);
            upper = Math.min(upper, road.get(i).upper);
        } else if (road.get(i).which.equals("on")) {
            lower += road.get(i).lower;
            upper += road.get(i).upper;
        } else {
            lower -= road.get(i).upper;
            upper -= road.get(i).lower;
        }
        lower = Math.max(0, lower);
    }

    public static void main(String[] args) {
        try {
            fin = new BufferedReader(new FileReader("traffic.in"));
            fout = new BufferedWriter(new FileWriter("traffic.out"));
            n = Long.parseLong(fin.readLine());
            for (int i = 0; i < n; i++) {
                String[] line = fin.readLine().split(" ");
                Segment temp = new Segment();
                temp.which = line[0];
                temp.lower = Integer.parseInt(line[1]);
                temp.upper = Integer.parseInt(line[2]);
                road.add(temp);
            }
            for (int i = (int) n - 1; i >= 0; i--) {
                calc(i);
            }
            fout.write(lower + " " + upper + "\n");
            lower = 0;
            upper = 1000000;
            for (int i = 0; i < road.size(); i++) {
                calc2(i);
            }
            fout.write(lower + " " + upper + "\n");
            fin.close();
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

