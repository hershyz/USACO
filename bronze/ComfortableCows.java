import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer> outputs = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = Integer.valueOf(scn.nextLine());
        List<Integer> xCoords = new ArrayList<>();
        List<Integer> yCoords = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String raw = scn.nextLine();
            String[] rawArr = raw.split(" ");
            int x = Integer.valueOf(rawArr[0]);
            int y = Integer.valueOf(rawArr[1]);
            xCoords.add(x);
            yCoords.add(y);

            calculate(xCoords, yCoords);
        }

        for (int output : outputs) {
            System.out.println(output);
        }
    }

    public static void calculate(List<Integer> x, List<Integer> y) {

        int total = 0;

        for (int current = 0; current < x.size(); current++) {

            int adj = 0;
            int currX = x.get(current);
            int currY = y.get(current);

            for (int comparison = 0; comparison < x.size(); comparison++) {

                if (comparison != current) {

                    int compX = x.get(comparison);
                    int compY = y.get(comparison);

                    int xDiff = Math.abs(compX - currX);
                    int yDiff = Math.abs(compY - currY);

                    if (xDiff == 1 && yDiff == 0) {
                        adj++;
                    }

                    if (xDiff == 0 && yDiff == 1) {
                        adj++;
                    }
                }
            }

            if (adj == 3) {
                total++;
            }
        }

        outputs.add(total);
    }
}
