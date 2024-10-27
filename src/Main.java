import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static long solve(String inputFile) {
        try {
            MaxSideLength mx = new MaxSideLength();
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            int n = Integer.parseInt(br.readLine());
            MaxSideLength.Point[] P = new MaxSideLength.Point[n];
            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                int x = Integer.parseInt(line[0]);
                int y = Integer.parseInt(line[1]);
                P[i] = new MaxSideLength.Point(x, y);
            }
            MaxSideLength.Point[] X = P.clone(),Y=P.clone();
            // sort the points by x and y coordinates
            Arrays.sort(X, Comparator.comparingDouble(p -> p.x));
            Arrays.sort(Y, Comparator.comparingDouble(p -> p.y));

            br.close();
            double maxSideLength = mx.FindClosestPair(X,Y,0,P.length-1);

            return (long) (maxSideLength);
        } catch (IOException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        String inputFile = System.getProperty("user.dir") + "\\src\\input.txt";
        System.out.println( solve(inputFile));

    }
}