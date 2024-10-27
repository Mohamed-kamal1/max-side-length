import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void solve(String inputFile) {
        try {
            MaxSideLength mx = new MaxSideLength();
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = br.readLine()) != null) {
                int n = Integer.parseInt(line);
                MaxSideLength.Point[] P = new MaxSideLength.Point[n];
                for (int i = 0; i < n; i++) {
                    String[] pointLine = br.readLine().split(" ");
                    int x = Integer.parseInt(pointLine[0]);
                    int y = Integer.parseInt(pointLine[1]);
                    P[i] = new MaxSideLength.Point(x, y);
                }
                MaxSideLength.Point[] X = P.clone(), Y = P.clone();
                // sort the points by x and y coordinates
                Arrays.sort(X, Comparator.comparingDouble(p -> p.x));
                Arrays.sort(Y, Comparator.comparingDouble(p -> p.y));

                double maxSideLength = mx.FindClosestPair(X, Y, 0, P.length - 1);
                System.out.println((long) maxSideLength);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());        }
    }

    public static void main(String[] args) {
        String inputFile = System.getProperty("user.dir") + "\\src\\input.txt";
        solve(inputFile);
    }
}