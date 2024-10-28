import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    private static void solve(String inputFile , String outputFile) {
        try {
            MaxSideLength mx = new MaxSideLength();
            BufferedReader inputReader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter outputWriter = new BufferedWriter(new FileWriter(outputFile));
            String line;
            while ((line = inputReader.readLine()) != null) {
                int n = Integer.parseInt(line);
                MaxSideLength.Point[] P = new MaxSideLength.Point[n];
                for (int i = 0; i < n; i++) {
                    String[] pointLine = inputReader.readLine().split(" ");
                    int x = Integer.parseInt(pointLine[0]);
                    int y = Integer.parseInt(pointLine[1]);
                    P[i] = new MaxSideLength.Point(x, y);
                }
                MaxSideLength.Point[] X = P.clone(), Y = P.clone();
                // sort the points by x and y coordinates
                Arrays.sort(X, Comparator.comparingDouble(p -> p.x));
                Arrays.sort(Y, Comparator.comparingDouble(p -> p.y));

                double maxSideLength = mx.FindClosestPair(X, Y, 0, P.length - 1);
                // save the result to the output file
                outputWriter.write((long) maxSideLength + "\n");
                System.out.println((long) maxSideLength);
            }
            inputReader.close();
            outputWriter.close();
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFile;
        String outputFile;

        if (args.length >= 2) {
            inputFile = args[0];
            outputFile = args[1];
        } else {
            System.out.print("Enter the path of the input file: ");
            inputFile = scanner.nextLine();
            System.out.print("Enter the path of the output file: ");
            outputFile = scanner.nextLine();
        }

        solve(inputFile, outputFile);
    }

}