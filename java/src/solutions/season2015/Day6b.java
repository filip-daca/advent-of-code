package solutions.season2015;

import solutions.Solution;

import java.util.Arrays;
import java.util.Scanner;

public class Day6b implements Solution {

    int[][] lights = new int[1000][1000];

    private void turn(int value, int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; ++i) {
            for (int j = y1; j <= y2; ++j) {
                lights[i][j] = lights[i][j] + value;
                if (lights[i][j] < 0) {
                    lights[i][j] = 0;
                }
            }
        }
    }

    @Override
    public String solve(Scanner sc) {

        while (sc.hasNextLine()) {
            String w = sc.nextLine();

            int value = 2;
            if (w.contains("turn on")) {
                value = 1;
            } else if (w.contains("turn off")) {
                value = -1;
            }

            String[] numbers = w.split("\\D+");
            Integer[] l = Arrays.stream(numbers)
                    .filter(s -> !s.isBlank())
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            turn(value, l[0], l[1], l[2], l[3]);
        }

        long count = 0;
        for (int i = 0; i < 1000; ++i) {
            for (int j = 0; j < 1000; ++j) {
                count += lights[i][j];
            }
        }

        return count + "";
    }
}
