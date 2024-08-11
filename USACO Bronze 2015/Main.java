import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("speeding.in"))) {
            String[] firstLine = br.readLine().split(" ");
            int N = Integer.parseInt(firstLine[0]);
            int M = Integer.parseInt(firstLine[1]);

            List<int[]> roadSegs = new ArrayList<>();
            List<int[]> bessieJourney = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                roadSegs.add(new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1])});
            }

            for (int i = 0; i < M; i++) {
                String[] line = br.readLine().split(" ");
                bessieJourney.add(new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1])});
            }

            System.out.println("road_segs  = " + roadSegs);
            System.out.println("Bessie_journey = " + bessieJourney);

            int maxOverSpeed = 0;

            int i = 0, j = 0;
            int curRoad = roadSegs.get(i)[0];
            int driveRoad = bessieJourney.get(j)[0];

            while (i < N) {
                System.out.println(" i = " + i + " j = " + j);

                // calculate over_speed
                maxOverSpeed = Math.max(maxOverSpeed, (bessieJourney.get(j)[1] - roadSegs.get(i)[1]));

                if (curRoad == driveRoad) {
                    i++;
                    j++;
                    if (i < N) {
                        curRoad = roadSegs.get(i)[0];
                    }
                    if (j < M) {
                        driveRoad = bessieJourney.get(j)[0];
                    }
                } else if (curRoad > driveRoad) {
                    curRoad -= driveRoad;
                    j++;
                    if (j < M) {
                        driveRoad = bessieJourney.get(j)[0];
                    }
                } else { // curRoad < driveRoad
                    driveRoad -= curRoad;
                    i++;
                    if (i < N) {
                        curRoad = roadSegs.get(i)[0];
                    }
                }
            }

            System.out.println(maxOverSpeed);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter("speeding.out"))) {
                bw.write(String.valueOf(maxOverSpeed));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

