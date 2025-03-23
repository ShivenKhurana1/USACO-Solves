import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int U = sc.nextInt();
        sc.nextLine();  // Consume newline after integers
        
        char[][] canvas = new char[N][];
        for (int i = 0; i < N; i++) {
            canvas[i] = sc.nextLine().toCharArray();
        }
        
        int size = N / 2;
        int[][] contributions = new int[size][size];
        int total = 0;
        
        // Initialize contributions for each group
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                int hashCount = 0;
                int dotCount = 0;
                
                // Top-left cell (r, c)
                if (canvas[r][c] == '#') hashCount++;
                else dotCount++;
                
                // Top-right cell (r, N-1 - c)
                int c2 = N - 1 - c;
                if (canvas[r][c2] == '#') hashCount++;
                else dotCount++;
                
                // Bottom-left cell (N-1 - r, c)
                int r3 = N - 1 - r;
                if (canvas[r3][c] == '#') hashCount++;
                else dotCount++;
                
                // Bottom-right cell (N-1 - r, N-1 - c)
                int r4 = N - 1 - r;
                int c4 = N - 1 - c;
                if (canvas[r4][c4] == '#') hashCount++;
                else dotCount++;
                
                int contribution = 4 - Math.max(hashCount, dotCount);
                contributions[r][c] = contribution;
                total += contribution;
            }
        }
        
        System.out.println(total);
        
        // Process each update
        for (int u = 0; u < U; u++) {
            int r = sc.nextInt() - 1;  // Convert to 0-based
            int c = sc.nextInt() - 1;
            //sc.nextLine();  // Consume the rest of the line, if any
        
            // Toggle the cell
            canvas[r][c] = (canvas[r][c] == '#') ? '.' : '#';
            
            // Determine the group's top-left cell
            int rPrime = Math.min(r, (N - 1) - r);
            int cPrime = Math.min(c, (N - 1) - c);
            
            // Ensure the group is within the top-left quadrant for contributions
            if (rPrime >= size || cPrime >= size) {
                // This should not happen as per problem constraints
                System.out.println(total);
                continue;
            }
            
            // Subtract the old contribution
            total -= contributions[rPrime][cPrime];
            
            // Recalculate the new contribution for the group
            int hashCount = 0;
            int dotCount = 0;
            
            // Top-left cell (rPrime, cPrime)
            if (canvas[rPrime][cPrime] == '#') hashCount++;
            else dotCount++;
            
            // Top-right cell (rPrime, N-1 - cPrime)
            int c2 = N - 1 - cPrime;
            if (canvas[rPrime][c2] == '#') hashCount++;
            else dotCount++;
            
            // Bottom-left cell (N-1 - rPrime, cPrime)
            int r3 = N - 1 - rPrime;
            if (canvas[r3][cPrime] == '#') hashCount++;
            else dotCount++;
            
            // Bottom-right cell (N-1 - rPrime, N-1 - cPrime)
            int r4 = N - 1 - rPrime;
            int c4 = N - 1 - cPrime;
            if (canvas[r4][c4] == '#') hashCount++;
            else dotCount++;
            
            int newContribution = 4 - Math.max(hashCount, dotCount);
            contributions[rPrime][cPrime] = newContribution;
            total += newContribution;
            
            System.out.println(total);
        }
        
        sc.close();
    }
}